package com.list.ontobase.jena.util;

import org.apache.jena.rdf.model.Literal;

import junit.framework.TestCase;

public class LiteralFactoryTest extends TestCase {
	
	public void setUp() {
		
	}
	
	public void testCreateLiteral() {
		Literal lit = LiteralFactory.createLiteral("\"a\"@en");
		System.out.println(lit);
		assertTrue(true);
	}

}
