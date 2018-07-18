package com.list.ontobase.jena.rdf.model;

import org.apache.jena.rdf.model.Model;

import junit.framework.TestCase;

public class OntoModelTest extends TestCase {
	
	public Model model;

	public void setUp() {
		model = new OntoModel("192.168.0.11", 9999, "NationalLibrary");
	}
	
	public void testSearch() {
		Model model = new OntoModel("192.168.0.11", 9999, "NationalLibrary");
		assertNotNull(model);
	}
	
	public void testSize() {
		System.out.println(this.model.size());
		assertTrue(true);
	}
}
