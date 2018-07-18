package com.list.ontobase.jena.util;

import java.io.StringReader;

import org.apache.jena.rdf.model.Literal;

public class LiteralFactory {
	
	private static LiteralStringReader lsr = new LiteralStringReader();

	public static Literal createLiteral(String s) {
		return lsr.read(new StringReader(s + " ."));
	}
}
