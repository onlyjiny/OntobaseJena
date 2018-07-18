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

public class OntoProperty implements Property {
	
	private static Logger logger = LoggerFactory.getLogger(OntoProperty.class);

	private final OntoModel model;
	private final Property p;
	
	public OntoProperty(OntoModel model, Property p) {
		this.model = model;
		this.p = p;
	}
	
	public AnonId getId() {
		return this.p.getId();
	}
	
	public boolean hasURI(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}
	
	public String getURI() {
		return this.p.getURI();
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
		StmtIterator osi = this.model.listStatements(this.p.asResource(), p, (RDFNode) null);
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
		return this.model.listStatements(this.p.asResource(), p, (RDFNode) null);
	}
	
	public StmtIterator listProperties(Property p, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public StmtIterator listProperties() {
		return this.model.listStatements(this.p.asResource(), null, (RDFNode) null);
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
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasLiteral(Property p, long o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasLiteral(Property p, char o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasLiteral(Property p, double o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasLiteral(Property p, float o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasLiteral(Property p, Object o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasProperty(Property p, String o) {
		Literal lit = ResourceFactory.createTypedLiteral(o);
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasProperty(Property p, String o, String l) {
		Literal lit = ResourceFactory.createLangLiteral(o, l);
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, lit);
		return si.hasNext();
	}
	
	public boolean hasProperty(Property p, RDFNode o) {
		StmtIterator si = this.model.listStatements(this.p.asResource(), p, o);
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
	
	public boolean isAnon() {
		return this.p.isAnon();
	}
	
	public boolean isLiteral() {
		return this.p.isLiteral();
	}
	
	public boolean isURIResource() {
		return this.p.isURIResource();
	}
	
	public boolean isResource() {
		return this.p.isResource();
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
		return new OntoResource(this.model, this.p.asResource());
	}
	
	public Literal asLiteral() {
		return new OntoLiteral(this.model, this.p.asLiteral());
	}
	
	public Node asNode() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public boolean isProperty() {
		return this.p.isProperty();
	}
	
	public String getNameSpace() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public Property inModel(Model m) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}
	
	public String getLocalName() {
		return this.p.getLocalName();
	}
	
	public int getOrdinal() {
		logger.error("This method is not implemented, so it returns null.");
		return 0;
	}
}
