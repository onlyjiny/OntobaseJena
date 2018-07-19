package com.list.ontobase.jena.rdf.model;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.AnonId;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFVisitor;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OntoResource implements Resource {
	
	private static Logger logger = LoggerFactory.getLogger(OntoResource.class);

	private final OntoModel model;
	private final Resource r;
	
	public OntoResource(OntoModel model, Resource r) {
		this.model = model;
		this.r = r;
	}

	public boolean isAnon() {
		return this.r.isAnon();
	}

	public boolean isLiteral() {
		return this.r.isLiteral();
	}

	public boolean isURIResource() {
		return this.r.isURIResource();
	}

	public boolean isResource() {
		return this.r.isResource();
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
		return new OntoResource(this.model, this.r.asResource());
	}

	public Literal asLiteral() {
		return new OntoLiteral(this.model, this.r.asLiteral());
	}

	public Node asNode() {
		return this.r.asNode();
	}

	public AnonId getId() {
		return this.r.getId();
	}

	public Resource inModel(Model m) {
		return this;
	}

	public boolean hasURI(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public String getURI() {
		return this.r.getURI();
	}

	public String getNameSpace() {
		return this.r.getNameSpace();
	}

	public String getLocalName() {
		return this.r.getLocalName();
	}

	public Statement getRequiredProperty(Property p) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement getRequiredProperty(Property p, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement getProperty(Property p) {
		StmtIterator osi = this.model.listStatements(this.r, p, (RDFNode) null);
		if(osi.hasNext()) {
			return osi.next();
		} else {
			return null;
		}
	}

	public Statement getProperty(Property p, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public StmtIterator listProperties(Property p) {
		return this.model.listStatements(this.r, p, (RDFNode) null);
	}

	public StmtIterator listProperties(Property p, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public StmtIterator listProperties() {
		return this.model.listStatements(this.r, null, (RDFNode) null);
	}

	public Resource addLiteral(Property p, boolean o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addLiteral(Property p, long o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addLiteral(Property p, char o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addLiteral(Property value, double d) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addLiteral(Property value, float d) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addLiteral(Property p, Object o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addLiteral(Property p, Literal o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addProperty(Property p, String o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addProperty(Property p, String o, String l) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addProperty(Property p, String lexicalForm, RDFDatatype datatype) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource addProperty(Property p, RDFNode o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public boolean hasProperty(Property p) {
		StmtIterator si = this.listProperties(p);
		return si.hasNext();
	}

	public boolean hasLiteral(Property p, boolean o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasLiteral(Property p, long o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasLiteral(Property p, char o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasLiteral(Property p, double o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasLiteral(Property p, float o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasLiteral(Property p, Object o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasProperty(Property p, String o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasProperty(Property p, String o, String l) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public boolean hasProperty(Property p, RDFNode o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.r, p, lit);
		return si.hasNext();
	}

	public Resource removeProperties() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource removeAll(Property p) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource begin() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource abort() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource commit() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource getPropertyResourceValue(Property p) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public String toString() {
		return this.r.toString();
	}
}
