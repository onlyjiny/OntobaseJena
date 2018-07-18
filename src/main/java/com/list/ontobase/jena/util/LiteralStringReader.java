package com.list.ontobase.jena.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.jena.datatypes.TypeMapper;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.RDFErrorHandler;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.impl.RDFDefaultErrorHandler;
import org.apache.jena.shared.JenaException;
import org.apache.jena.shared.SyntaxError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiteralStringReader {
	
	static final Logger log = LoggerFactory.getLogger(LiteralStringReader.class);
	
	private static final TypeMapper JENA_TYPE_MAPPER = TypeMapper.getInstance();

	private IStream in = null;
	private boolean inErr = false;
	private int errCount = 0;
	private static final int sbLength = 200;

	private RDFErrorHandler errorHandler = new RDFDefaultErrorHandler();

	private String base = "";
	
	public LiteralStringReader() {
		
	}
	
	public Literal read(Reader reader) {
		in = new IStream(reader);
		Literal lit = unwrappedReadRDFNode();
		if (errCount != 0) {
			throw new SyntaxError("unknown");
		}
		return lit;
	}

	protected final Literal unwrappedReadRDFNode() {
		Literal object = null;
		while (!in.eof()) {
			while (!in.eof()) {
				inErr = false;

				skipWhiteSpace();
				if (in.eof()) {
					return object;
				}

				if (inErr)
					break;

				skipWhiteSpace();
				object = readNode();
				if (inErr)
					break;

				skipWhiteSpace();
				if (badEOF())
					break;

				if (!expect("."))
					break;
			}
			if (inErr) {
				errCount++;
				while (!in.eof() && in.readChar() != '\n') {
				}
			}
		}
		return object;
	}

	private Literal readNode() {
		skipWhiteSpace();
		switch (in.nextChar()) {
		case '"':
			return readLiteral();
		case '<':
		case '_':
		default:
			syntaxError("unexpected input");
			return null;
		}
	}
	
	protected String readURI() {
		StringBuffer uri = new StringBuffer(sbLength);

		while (in.nextChar() != '>') {
			char inChar = in.readChar();

			if (inChar == '\\') {
				expect("u");
				inChar = readUnicode4Escape();
			}
			if (badEOF()) {
				return null;
			}
			uri = uri.append(inChar);
		}
		return uri.toString();
	}
	
	protected Literal readLiteral() {
		StringBuffer lit = new StringBuffer(sbLength);

		if (!expect("\""))
			return null;

		while (true) {
			char inChar = in.readChar();
			if (badEOF())
				return null;
			if (inChar == '\\') {
				char c = in.readChar();
				if (in.eof()) {
					inErr = true;
					return null;
				}
				if (c == 'n') {
					inChar = '\n';
				} else if (c == 'r') {
					inChar = '\r';
				} else if (c == 't') {
					inChar = '\t';
				} else if (c == '\\' || c == '"') {
					inChar = c;
				} else if (c == 'u') {
					inChar = readUnicode4Escape();
					if (inErr)
						return null;
				} else {
					syntaxError("illegal escape sequence '" + c + "'");
					return null;
				}
			} else if (inChar == '"') {
				String lang;
				if ('@' == in.nextChar()) {
					expect("@");
					lang = readLang();
				} else if ('-' == in.nextChar()) {
					expect("-");
					deprecated("Language tags should be introduced with @ not -.");
					lang = readLang();
				} else {
					lang = "";
				}
				if ('^' == in.nextChar()) {
					String datatypeURI = null;
					if (!expect("^^<")) {
						syntaxError("ill-formed datatype");
						return null;
					}
					datatypeURI = readURI();
					if (datatypeURI == null || !expect(">"))
						return null;
					if (lang.length() > 0)
						deprecated("Language tags are not permitted on typed literals.");

					return ResourceFactory.createTypedLiteral(lit.toString(), JENA_TYPE_MAPPER.getSafeTypeByName(datatypeURI));
				} else if (lang.length() > 0) {
					return ResourceFactory.createLangLiteral(lit.toString(), lang);
				} else {
					return ResourceFactory.createPlainLiteral(lit.toString());
				}
			}
			else if (inChar == '\n' || inChar == '\r') {
				deprecated("Raw NL or CR not permitted in N-Triples data");
				return null;
			}
			lit = lit.append(inChar);
		}
	}
	
	private String readLang() {
		StringBuffer lang = new StringBuffer(15);

		while (true) {
			char inChar = in.nextChar();
			if (Character.isWhitespace(inChar) || inChar == '.' || inChar == '^')
				return lang.toString();
			lang = lang.append(in.readChar());
		}
	}
	
	private boolean expect(String str) {
		for (int i = 0; i < str.length(); i++) {
			char want = str.charAt(i);

			if (badEOF())
				return false;

			char inChar = in.readChar();

			if (inChar != want) {
				syntaxError("expected \"" + str + "\"");
				return false;
			}
		}
		return true;
	}
	
	private boolean badEOF() {
		if (in.eof()) {
			syntaxError("premature end of file");
		}
		return inErr;
	}
	
	private char readUnicode4Escape() {
		char buf[] = new char[] { in.readChar(), in.readChar(), in.readChar(), in.readChar() };
		if (badEOF()) {
			return 0;
		}
		try {
			return (char) Integer.parseInt(new String(buf), 16);
		} catch (NumberFormatException e) {
			syntaxError("bad unicode escape sequence");
			return 0;
		}
	}
	
	private void skipWhiteSpace() {
		while (Character.isWhitespace(in.nextChar()) || in.nextChar() == '#') {
			char inChar = in.readChar();
			if (in.eof()) {
				return;
			}
			if (inChar == '#') {
				while (inChar != '\n') {
					inChar = in.readChar();
					if (in.eof()) {
						return;
					}
				}
			}
		}
	}
	
	private void syntaxError(String s) {
		errorHandler.error(new SyntaxError(syntaxErrorMessage("Syntax error", s, in.getLinepos(), in.getCharpos())));
		inErr = true;
	}
	
	private void deprecated(String s) {
		errorHandler.warning(
				new SyntaxError(syntaxErrorMessage("Deprecation warning", s, in.getLinepos(), in.getCharpos())));
	}
	
	private String syntaxErrorMessage(String sort, String msg, int linepos, int charpos) {
		return base + sort + " at line " + linepos + " position " + charpos + ": " + msg;
	}
}

class IStream {

	Reader in;
	char[] thisChar = new char[1];
	boolean eof;
	int charpos = 1;
	int linepos = 1;

	protected IStream(Reader in) {
		try {
			this.in = in;
			eof = (in.read(thisChar, 0, 1) == -1);
		} catch (IOException e) {
			throw new JenaException(e);
		}
	}

	protected char readChar() {
		try {
			if (eof)
				return '\000';
			char rv = thisChar[0];
			eof = (in.read(thisChar, 0, 1) == -1);
			if (rv == '\n') {
				linepos++;
				charpos = 0;
			} else {
				charpos++;
			}
			return rv;
		} catch (java.io.IOException e) {
			throw new JenaException(e);
		}
	}

	protected char nextChar() {
		return eof ? '\000' : thisChar[0];
	}

	protected boolean eof() {
		return eof;
	}

	protected int getLinepos() {
		return linepos;
	}

	protected int getCharpos() {
		return charpos;
	}
}
