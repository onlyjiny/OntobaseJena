package com.list.ontobase.jena.rdf.model;

import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFVisitor;
import org.apache.jena.rdf.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OntoRDFNode implements RDFNode {
	
	private static Logger logger = LoggerFactory.getLogger(OntoRDFNode.class);

	private final OntoModel model;
	private final RDFNode node;

	public OntoRDFNode(OntoModel model, RDFNode node) {
		this.model = model;
		this.node = node;
	}

	public Node asNode() {
		return this.node.asNode();
	}

	public <T extends RDFNode> T as(Class<T> arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Literal asLiteral() {
		return new OntoLiteral(this.model, this.node.asLiteral());
	}

	public Resource asResource() {
		return new OntoResource(this.model, this.node.asResource());
	}

	public <T extends RDFNode> boolean canAs(Class<T> arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public Model getModel() {
		return this.model;
	}

	public RDFNode inModel(Model arg0) {
		return this;
	}

	public boolean isAnon() {
		return this.node.isAnon();
	}

	public boolean isLiteral() {
		return this.node.isLiteral();
	}

	public boolean isResource() {
		return this.node.isResource();
	}

	public boolean isURIResource() {
		return this.node.isURIResource();
	}

	public Object visitWith(RDFVisitor arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String toString() {
		return this.node.toString();
	}
}
