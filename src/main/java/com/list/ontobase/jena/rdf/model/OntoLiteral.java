package com.list.ontobase.jena.rdf.model;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFVisitor;
import org.apache.jena.rdf.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OntoLiteral implements Literal {
	
	private static Logger logger = LoggerFactory.getLogger(OntoLiteral.class);

	private final OntoModel model;
	private final Literal l;
	
	public OntoLiteral(OntoModel model, Literal l) {
		this.model = model;
		this.l = l;
	}
	
	public boolean isAnon() {
		return false;
	}
	
	public boolean isLiteral() {
		return true;
	}
	
	public boolean isURIResource() {
		return false;
	}
	
	public boolean isResource() {
		return false;
	}
	
	public <T extends RDFNode> T as(Class<T> view) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public <T extends RDFNode> boolean canAs(Class<T> view) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public Object visitWith(RDFVisitor rv) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public Resource asResource() {
		return this.l.asResource();
	}
	
	public Literal asLiteral() {
		return new OntoLiteral(this.model, this.l.asLiteral());
	}
	
	public Node asNode() {
		return this.l.asNode();
	}
	
	public Literal inModel(Model m) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public Object getValue() {
		return this.l.getValue();
	}
	
	public RDFDatatype getDatatype() {
		return this.l.getDatatype();
	}
	
	public String getDatatypeURI() {
		return this.l.getDatatypeURI();
	}
	
	public String getLexicalForm() {
		return this.l.getLexicalForm();
	}
	
	public boolean getBoolean() {
		return this.l.getBoolean();
	}
	
	public byte getByte() {
		return this.l.getByte();
	}
	
	public short getShort() {
		return this.l.getShort();
	}
	
	public int getInt() {
		return this.l.getInt();
	}
	
	public long getLong() {
		return this.l.getLong();
	}
	
	public char getChar() {
		return this.l.getChar();
	}
	
	public float getFloat() {
		return this.l.getFloat();
	}
	
	public double getDouble() {
		return this.l.getDouble();
	}
	
	public String getString() {
		return this.l.getString();
	}
	
	public String getLanguage() {
		return this.l.getLanguage();
	}
	
	public boolean isWellFormedXML() {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}
	
	public boolean sameValueAs(Literal other) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}
	
	public String toString() {
		return this.l.toString();
	}
}
