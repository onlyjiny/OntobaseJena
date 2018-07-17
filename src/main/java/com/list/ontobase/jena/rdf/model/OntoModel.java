package com.list.ontobase.jena.rdf.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.apache.jena.rdf.model.Alt;
import org.apache.jena.rdf.model.AnonId;
import org.apache.jena.rdf.model.Bag;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelChangedListener;
import org.apache.jena.rdf.model.NodeIterator;
import org.apache.jena.rdf.model.NsIterator;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFList;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFReader;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.RSIterator;
import org.apache.jena.rdf.model.ReifiedStatement;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceF;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.Seq;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.shared.Command;
import org.apache.jena.shared.Lock;
import org.apache.jena.shared.PrefixMapping;

public class OntoModel implements Model {

	public Resource getResource(String uri, ResourceF f) {
		// TODO Auto-generated method stub
		return null;
	}

	public Property getProperty(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bag getBag(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bag getBag(Resource r) {
		// TODO Auto-generated method stub
		return null;
	}

	public Alt getAlt(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Alt getAlt(Resource r) {
		// TODO Auto-generated method stub
		return null;
	}

	public Seq getSeq(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Seq getSeq(Resource r) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource createResource(Resource type) {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFNode getRDFNode(Node n) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource createResource(String uri, Resource type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource createResource(ResourceF f) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource createResource(String uri, ResourceF f) {
		// TODO Auto-generated method stub
		return null;
	}

	public Property createProperty(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createLiteral(String v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(boolean v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(int v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(long v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(Calendar d) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(char v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(float v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(double v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(String v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(String lex, String typeURI) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(Object value, String typeURI) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createLiteralStatement(Resource s, Property p, boolean o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createLiteralStatement(Resource s, Property p, float o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createLiteralStatement(Resource s, Property p, double o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createLiteralStatement(Resource s, Property p, long o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createLiteralStatement(Resource s, Property p, int o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createLiteralStatement(Resource s, Property p, char o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createLiteralStatement(Resource s, Property p, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createStatement(Resource s, Property p, String o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createStatement(Resource s, Property p, String o, String l) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createStatement(Resource s, Property p, String o, boolean wellFormed) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createStatement(Resource s, Property p, String o, String l, boolean wellFormed) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bag createBag() {
		// TODO Auto-generated method stub
		return null;
	}

	public Bag createBag(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Alt createAlt() {
		// TODO Auto-generated method stub
		return null;
	}

	public Alt createAlt(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Seq createSeq() {
		// TODO Auto-generated method stub
		return null;
	}

	public Seq createSeq(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Resource s, Property p, RDFNode o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, boolean o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, long o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, int o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, char o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, float o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, double o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model addLiteral(Resource s, Property p, Literal o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Resource s, Property p, String o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Resource s, Property p, String lex, RDFDatatype datatype) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Resource s, Property p, String o, boolean wellFormed) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Resource s, Property p, String o, String l) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model remove(Resource s, Property p, RDFNode o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model remove(StmtIterator iter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model remove(Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, boolean object) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, char object) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, long object) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, int object) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, float object) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, double object) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listStatements(Resource subject, Property predicate, String object) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listStatements(Resource subject, Property predicate, String object, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p, boolean o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p, long o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p, char o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p, float o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p, double o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listSubjectsWithProperty(Property p, String o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listSubjectsWithProperty(Property p, String o, String l) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean containsLiteral(Resource s, Property p, boolean o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsLiteral(Resource s, Property p, long o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsLiteral(Resource s, Property p, int o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsLiteral(Resource s, Property p, char o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsLiteral(Resource s, Property p, float o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsLiteral(Resource s, Property p, double o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsLiteral(Resource s, Property p, Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Resource s, Property p, String o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Resource s, Property p, String o, String l) {
		// TODO Auto-generated method stub
		return false;
	}

	public Statement asStatement(Triple t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Graph getGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFNode asRDFNode(Node n) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource wrapAsResource(Node n) {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFReader getReader() {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFReader getReader(String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public String setReaderClassName(String lang, String className) {
		// TODO Auto-generated method stub
		return null;
	}

	public void resetRDFReaderF() {
		// TODO Auto-generated method stub
		
	}

	public String removeReader(String lang) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFWriter getWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFWriter getWriter(String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public String setWriterClassName(String lang, String className) {
		// TODO Auto-generated method stub
		return null;
	}

	public void resetRDFWriterF() {
		// TODO Auto-generated method stub
		
	}

	public String removeWriter(String lang) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrefixMapping setNsPrefix(String prefix, String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public PrefixMapping removeNsPrefix(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	public PrefixMapping clearNsPrefixMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public PrefixMapping setNsPrefixes(PrefixMapping other) {
		// TODO Auto-generated method stub
		return null;
	}

	public PrefixMapping setNsPrefixes(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public PrefixMapping withDefaultMappings(PrefixMapping map) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNsPrefixURI(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNsURIPrefix(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> getNsPrefixMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public String expandPrefix(String prefixed) {
		// TODO Auto-generated method stub
		return null;
	}

	public String shortForm(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public String qnameFor(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public PrefixMapping lock() {
		// TODO Auto-generated method stub
		return null;
	}

	public int numPrefixes() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean samePrefixMappingAs(PrefixMapping other) {
		// TODO Auto-generated method stub
		return false;
	}

	public void enterCriticalSection(boolean readLockRequested) {
		// TODO Auto-generated method stub
		
	}

	public void leaveCriticalSection() {
		// TODO Auto-generated method stub
		
	}

	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public ResIterator listSubjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public NsIterator listNameSpaces() {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource getResource(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Property getProperty(String nameSpace, String localName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource createResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource createResource(AnonId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource createResource(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Property createProperty(String nameSpace, String localName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createLiteral(String v, String language) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createLiteral(String v, boolean wellFormed) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(String lex, RDFDatatype dtype) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(Object value, RDFDatatype dtype) {
		// TODO Auto-generated method stub
		return null;
	}

	public Literal createTypedLiteral(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement createStatement(Resource s, Property p, RDFNode o) {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFList createList() {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFList createList(Iterator<? extends RDFNode> members) {
		// TODO Auto-generated method stub
		return null;
	}

	public RDFList createList(RDFNode[] members) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Statement s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Statement[] statements) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model remove(Statement[] statements) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(List<Statement> statements) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model remove(List<Statement> statements) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(StmtIterator iter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model add(Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model read(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model read(InputStream in, String base) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model read(InputStream in, String base, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model read(Reader reader, String base) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model read(String url, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model read(Reader reader, String base, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model read(String url, String base, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model write(Writer writer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model write(Writer writer, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model write(Writer writer, String lang, String base) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model write(OutputStream out) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model write(OutputStream out, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model write(OutputStream out, String lang, String base) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model remove(Statement s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement getRequiredProperty(Resource s, Property p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement getRequiredProperty(Resource s, Property p, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement getProperty(Resource s, Property p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement getProperty(Resource s, Property p, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listSubjectsWithProperty(Property p) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listSubjectsWithProperty(Property p, RDFNode o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResIterator listResourcesWithProperty(Property p, RDFNode o) {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeIterator listObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeIterator listObjectsOfProperty(Property p) {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeIterator listObjectsOfProperty(Resource s, Property p) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean contains(Resource s, Property p) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsResource(RDFNode r) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Resource s, Property p, RDFNode o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Statement s) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAny(StmtIterator iter) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(StmtIterator iter) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAny(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isReified(Statement s) {
		// TODO Auto-generated method stub
		return false;
	}

	public Resource getAnyReifiedStatement(Statement s) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAllReifications(Statement s) {
		// TODO Auto-generated method stub
		
	}

	public void removeReification(ReifiedStatement rs) {
		// TODO Auto-generated method stub
		
	}

	public StmtIterator listStatements() {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listStatements(Selector s) {
		// TODO Auto-generated method stub
		return null;
	}

	public StmtIterator listStatements(Resource s, Property p, RDFNode o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ReifiedStatement createReifiedStatement(Statement s) {
		// TODO Auto-generated method stub
		return null;
	}

	public ReifiedStatement createReifiedStatement(String uri, Statement s) {
		// TODO Auto-generated method stub
		return null;
	}

	public RSIterator listReifiedStatements() {
		// TODO Auto-generated method stub
		return null;
	}

	public RSIterator listReifiedStatements(Statement st) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model query(Selector s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model union(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model intersection(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model difference(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model begin() {
		// TODO Auto-generated method stub
		return null;
	}

	public Model abort() {
		// TODO Auto-generated method stub
		return null;
	}

	public Model commit() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object executeInTransaction(Command cmd) {
		// TODO Auto-generated method stub
		return null;
	}

	public void executeInTxn(Runnable action) {
		// TODO Auto-generated method stub
		
	}

	public <T> T calculateInTxn(Supplier<T> action) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean independent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean supportsTransactions() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean supportsSetOperations() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isIsomorphicWith(Model g) {
		// TODO Auto-generated method stub
		return false;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public Lock getLock() {
		// TODO Auto-generated method stub
		return null;
	}

	public Model register(ModelChangedListener listener) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model unregister(ModelChangedListener listener) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model notifyEvent(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	public Model removeAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Model removeAll(Resource s, Property p, RDFNode r) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}

}
