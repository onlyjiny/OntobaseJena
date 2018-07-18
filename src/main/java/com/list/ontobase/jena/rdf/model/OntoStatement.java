package com.list.ontobase.jena.rdf.model;

import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Alt;
import org.apache.jena.rdf.model.Bag;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RSIterator;
import org.apache.jena.rdf.model.ReifiedStatement;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceF;
import org.apache.jena.rdf.model.Seq;
import org.apache.jena.rdf.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("deprecation")
public class OntoStatement implements Statement {
	
	private static Logger logger = LoggerFactory.getLogger(OntoStatement.class);

	private final OntoModel model;
	private final Statement stmt;

	public OntoStatement(OntoModel model, Statement stmt) {
		this.model = model;
		this.stmt = stmt;
	}

	public Triple asTriple() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeLiteralObject(boolean arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeLiteralObject(long arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeLiteralObject(int arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeLiteralObject(char arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeLiteralObject(float arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeLiteralObject(double arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeObject(String arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeObject(RDFNode arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeObject(String arg0, boolean arg1) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeObject(String arg0, String arg1) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement changeObject(String arg0, String arg1, boolean arg2) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ReifiedStatement createReifiedStatement() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ReifiedStatement createReifiedStatement(String arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Alt getAlt() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Bag getBag() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public boolean getBoolean() {
		return this.stmt.getObject().asLiteral().getBoolean();
	}

	public byte getByte() {
		return this.stmt.getObject().asLiteral().getByte();
	}

	public char getChar() {
		return this.stmt.getObject().asLiteral().getChar();
	}

	public double getDouble() {
		return this.stmt.getObject().asLiteral().getDouble();
	}

	public float getFloat() {
		return this.stmt.getObject().asLiteral().getFloat();
	}

	public int getInt() {
		return this.stmt.getObject().asLiteral().getInt();
	}

	public String getLanguage() {
		return this.stmt.getObject().asLiteral().getLanguage();
	}

	public Literal getLiteral() {
		return this.stmt.getObject().asLiteral();
	}

	public long getLong() {
		return this.stmt.getObject().asLiteral().getLong();
	}

	public Model getModel() {
		return this.model;
	}

	public RDFNode getObject() {
		return this.stmt.getObject();
	}

	public Property getPredicate() {
		return this.stmt.getPredicate();
	}

	public Statement getProperty(Property arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource getResource() {
		return this.stmt.getResource();
	}

	public Resource getResource(ResourceF arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Seq getSeq() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public short getShort() {
		logger.error("This method is not implemented, so it returns null.");
		return 0;
	}

	public Statement getStatementProperty(Property arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String getString() {
		return this.stmt.getObject().asLiteral().getString();
	}

	public Resource getSubject() {
		return this.stmt.getSubject();
	}

	public boolean hasWellFormedXML() {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean isReified() {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public RSIterator listReifiedStatements() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement remove() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public void removeReification() {
		logger.error("This method is not implemented, so it returns null.");
		
	}
}
