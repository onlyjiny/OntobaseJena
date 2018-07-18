package com.list.ontobase.jena.rdf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OntoNodeIterator implements NodeIterator {
	
	private static Logger logger = LoggerFactory.getLogger(OntoNodeIterator.class);
	
	private final OntoModel model;
	private final ResultSet rs;
	private final String varName;
	
	public OntoNodeIterator(OntoModel model, ResultSet rs, String varName) {
		this.model = model;
		this.rs = rs;
		this.varName = varName;
	}

	public RDFNode removeNext() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public <X extends RDFNode> ExtendedIterator<RDFNode> andThen(Iterator<X> other) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ExtendedIterator<RDFNode> filterKeep(Predicate<RDFNode> f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ExtendedIterator<RDFNode> filterDrop(Predicate<RDFNode> f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public <U> ExtendedIterator<U> mapWith(Function<RDFNode, U> map1) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public List<RDFNode> toList() {
		List<RDFNode> result = new ArrayList<RDFNode>();
		while(this.hasNext()) {
			result.add(this.next());
		}
		return result;
	}

	public Set<RDFNode> toSet() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public boolean hasNext() {
		return this.rs.hasNext();
	}

	public RDFNode next() throws NoSuchElementException {
		return new OntoRDFNode(this.model, this.rs.next().get(this.varName));
	}

	public RDFNode nextNode() throws NoSuchElementException {
		return this.next();
	}

	public void remove() throws NoSuchElementException {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public void close() {
		logger.error("This method is not implemented, so it returns null.");
		
	}

}
