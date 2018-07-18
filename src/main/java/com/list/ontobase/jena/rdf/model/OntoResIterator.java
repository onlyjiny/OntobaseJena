package com.list.ontobase.jena.rdf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OntoResIterator implements ResIterator {
	
	private static Logger logger = LoggerFactory.getLogger(OntoResIterator.class);
	
	private final OntoModel model;
	private final ResultSet rs;
	private final String varName;
	
	public OntoResIterator(OntoModel model, ResultSet rs, String varName) {
		this.model = model;
		this.rs = rs;
		this.varName = varName;
	}

	public Resource removeNext() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public <X extends Resource> ExtendedIterator<Resource> andThen(Iterator<X> other) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ExtendedIterator<Resource> filterKeep(Predicate<Resource> f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ExtendedIterator<Resource> filterDrop(Predicate<Resource> f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public <U> ExtendedIterator<U> mapWith(Function<Resource, U> map1) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public List<Resource> toList() {
		List<Resource> result = new ArrayList<Resource>();
		while(this.hasNext()) {
			result.add(this.next());
		}
		return result;
	}

	public Set<Resource> toSet() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public void close() {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public boolean hasNext() {
		return this.rs.hasNext();
	}

	public Resource next() {
		return new OntoResource(this.model, this.rs.next().get(this.varName).asResource());
	}

	public Resource nextResource() {
		return this.next();
	}

}
