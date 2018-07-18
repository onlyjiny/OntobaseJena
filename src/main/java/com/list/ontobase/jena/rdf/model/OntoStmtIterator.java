package com.list.ontobase.jena.rdf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OntoStmtIterator implements StmtIterator {
	
	private static Logger logger = LoggerFactory.getLogger(OntoStmtIterator.class);
	
	private final OntoModel model;
	private final ResultSet rs;
	private final Resource s;
	private final Property p;
	private final RDFNode o;

	public OntoStmtIterator(OntoModel model, ResultSet rs, Resource s, Property p, RDFNode o) {
		this.model = model;
		this.rs = rs;
		this.s = s;
		this.p = p;
		this.o = o;
	}
	
	public Statement removeNext() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public <X extends Statement> ExtendedIterator<Statement> andThen(Iterator<X> other) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ExtendedIterator<Statement> filterKeep(Predicate<Statement> f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ExtendedIterator<Statement> filterDrop(Predicate<Statement> f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public <U> ExtendedIterator<U> mapWith(Function<Statement, U> map1) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public List<Statement> toList() {
		List<Statement> result = new ArrayList<Statement>();
		while(this.hasNext()) {
			Statement statement = this.next();
			result.add(new OntoStatement(this.model, statement));
		}
		return result;
	}

	public Set<Statement> toSet() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public void close() {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public boolean hasNext() {
		return this.rs.hasNext();
	}

	public Statement next() {
		QuerySolution qs = this.rs.nextSolution();
		Resource subject;
		Property predicate;
		RDFNode object;
		if(s == null) {
			subject = qs.getResource("s");
		} else {
			subject = s;
		}
		if(p == null) {
			predicate = (Property) qs.getResource("p");
		} else {
			predicate = p;
		}
		if(o == null) {
			object = qs.get("o");
		} else {
			object = o;
		}
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this.model, subject), new OntoProperty(this.model, predicate), new OntoRDFNode(this.model, object));
		return new OntoStatement(this.model, stmt);
	}

	public Statement nextStatement() throws NoSuchElementException {
		return this.next();
	}

}
