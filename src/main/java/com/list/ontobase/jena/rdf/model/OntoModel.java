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
import org.apache.jena.datatypes.TypeMapper;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
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
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.Seq;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.shared.Command;
import org.apache.jena.shared.Lock;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.sparql.resultset.SPARQLResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.list.ontobase.client.query.SparqlQuery;
import com.list.ontobase.jena.util.LiteralFactory;
import com.list.ontobase.msg.common.OntoException;

@SuppressWarnings("deprecation")
public class OntoModel implements Model {
	
	private static Logger logger = LoggerFactory.getLogger(OntoModel.class);
	
	private SparqlQuery sq;
	private TypeMapper tm;
	
	public OntoModel(String ip, int port, String service) {
		logger.info("Create instance model connected with Ontobase " + ip + ":" + port + "/" + service);
		this.sq = new SparqlQuery(ip, port, service);
		this.tm = TypeMapper.getInstance();
	}
	
	private ResultSet query(String query) {
		SPARQLResult result = null;
		try {
			result = this.sq.execute(query);
		} catch (OntoException e) {
			logger.error("Ontobase query exception: " + e.getMessage());
			logger.error(e.getPrintStackTrace());
		}
		return result.getResultSet();
	}
	
	public Resource getResource(String uri, ResourceF f) {
		return new OntoResource(this, ResourceFactory.createResource(uri));
	}

	public Property getProperty(String uri) {
		return new OntoProperty(this, ResourceFactory.createProperty(uri));
	}

	public Bag getBag(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Bag getBag(Resource r) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Alt getAlt(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Alt getAlt(Resource r) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Seq getSeq(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Seq getSeq(Resource r) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource createResource(Resource type) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFNode getRDFNode(Node n) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource createResource(String uri, Resource type) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource createResource(ResourceF f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource createResource(String uri, ResourceF f) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Property createProperty(String uri) {
		return this.getProperty(uri);
	}

	public Literal createLiteral(String v) {
		return new OntoLiteral(this, LiteralFactory.createLiteral(v));
	}

	public Literal createTypedLiteral(boolean v) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(v));
	}

	public Literal createTypedLiteral(int v) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(v));
	}

	public Literal createTypedLiteral(long v) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(v));
	}

	public Literal createTypedLiteral(Calendar d) {
		RDFDatatype dataType;
		String dateTime = new String();
		int year = d.get(Calendar.YEAR);
		int month = d.get(Calendar.MONTH);
		int day = d.get(Calendar.DAY_OF_MONTH);
		int hour = d.get(Calendar.HOUR_OF_DAY);
		int minute = d.get(Calendar.MINUTE);
		int second = d.get(Calendar.SECOND);
		
		if((hour == 0) && (minute == 0) && (second == 0)) {
			if(year == 0) {
				if(month == 0) {
					if(day == 0) {
						dateTime = year + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second;
						dataType = XSDDatatype.XSDdateTime;
					} else {
						dateTime = "---" + day;
						dataType = XSDDatatype.XSDgDay;
					}
				} else {
					if(day == 0) {
						dateTime = "--" + month;
						dataType = XSDDatatype.XSDgMonth;
					} else {
						dateTime = "--" + month + "-" + day;
						dataType = XSDDatatype.XSDgMonthDay;
					}
				}
			} else {
				if(month == 0) {
					dateTime = Integer.toString(year);
					dataType = XSDDatatype.XSDgYear;
				} else {
					if(day == 0) {
						dateTime = year + "-" + month;
						dataType = XSDDatatype.XSDgYearMonth;
					} else {
						dateTime = year + "-" + month + "-" + day;
						dataType = XSDDatatype.XSDdate;
					}
				}
			}
		} else {
			if((year == 0) && (month == 0) && (day == 0)) {
				dateTime = hour + ":" + minute + ":" + second;
				dataType = XSDDatatype.XSDtime;
			} else {
				dateTime = year + "-" + month + "-" + day + "T" + hour + ":" + minute + ":" + second;
				dataType = XSDDatatype.XSDdateTime;
			}
		}
		
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(dateTime, dataType));
	}

	public Literal createTypedLiteral(char v) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(v));
	}

	public Literal createTypedLiteral(float v) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(v));
	}

	public Literal createTypedLiteral(double v) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(v));
	}

	public Literal createTypedLiteral(String v) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(v));
	}

	public Literal createTypedLiteral(String lex, String typeURI) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(lex, this.tm.getSafeTypeByName(typeURI)));
	}

	public Literal createTypedLiteral(Object value, String typeURI) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(value.toString(), this.tm.getSafeTypeByName(typeURI)));
	}

	public Statement createLiteralStatement(Resource s, Property p, boolean o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createLiteralStatement(Resource s, Property p, float o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createLiteralStatement(Resource s, Property p, double o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createLiteralStatement(Resource s, Property p, long o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createLiteralStatement(Resource s, Property p, int o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createLiteralStatement(Resource s, Property p, char o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createLiteralStatement(Resource s, Property p, Object o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createStatement(Resource s, Property p, String o) {
		Literal ol = this.createTypedLiteral(o);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createStatement(Resource s, Property p, String o, String l) {
		Literal ol = this.createLiteral(o, l);
		Statement stmt = ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), ol);
		return new OntoStatement(this, stmt);
	}

	public Statement createStatement(Resource s, Property p, String o, boolean wellFormed) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement createStatement(Resource s, Property p, String o, String l, boolean wellFormed) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Bag createBag() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Bag createBag(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Alt createAlt() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Alt createAlt(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Seq createSeq() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Seq createSeq(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Resource s, Property p, RDFNode o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, boolean o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, long o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, int o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, char o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, float o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, double o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, Object o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model addLiteral(Resource s, Property p, Literal o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Resource s, Property p, String o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Resource s, Property p, String lex, RDFDatatype datatype) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Resource s, Property p, String o, boolean wellFormed) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Resource s, Property p, String o, String l) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model remove(Resource s, Property p, RDFNode o) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model remove(StmtIterator iter) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model remove(Model m) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, boolean object) {
		Literal ol = this.createTypedLiteral(object);
		return this.listStatements(subject, predicate, ol);
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, char object) {
		Literal ol = this.createTypedLiteral(object);
		return this.listStatements(subject, predicate, ol);
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, long object) {
		Literal ol = this.createTypedLiteral(object);
		return this.listStatements(subject, predicate, ol);
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, int object) {
		Literal ol = this.createTypedLiteral(object);
		return this.listStatements(subject, predicate, ol);
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, float object) {
		Literal ol = this.createTypedLiteral(object);
		return this.listStatements(subject, predicate, ol);
	}

	public StmtIterator listLiteralStatements(Resource subject, Property predicate, double object) {
		Literal ol = this.createTypedLiteral(object);
		return this.listStatements(subject, predicate, ol);
	}

	public StmtIterator listStatements(Resource subject, Property predicate, String object) {
		Literal ol = this.createTypedLiteral(object);
		return this.listStatements(subject, predicate, ol);
	}

	public StmtIterator listStatements(Resource subject, Property predicate, String object, String lang) {
		Literal ol = this.createLiteral(object, lang);
		return this.listStatements(subject, predicate, ol);
	}

	public ResIterator listResourcesWithProperty(Property p, boolean o) {
		Literal ol = this.createTypedLiteral(o);
		return this.listSubjectsWithProperty(p, ol);
	}

	public ResIterator listResourcesWithProperty(Property p, long o) {
		Literal ol = this.createTypedLiteral(o);
		return this.listSubjectsWithProperty(p, ol);
	}

	public ResIterator listResourcesWithProperty(Property p, char o) {
		Literal ol = this.createTypedLiteral(o);
		return this.listSubjectsWithProperty(p, ol);
	}

	public ResIterator listResourcesWithProperty(Property p, float o) {
		Literal ol = this.createTypedLiteral(o);
		return this.listSubjectsWithProperty(p, ol);
	}

	public ResIterator listResourcesWithProperty(Property p, double o) {
		Literal ol = this.createTypedLiteral(o);
		return this.listSubjectsWithProperty(p, ol);
	}

	public ResIterator listResourcesWithProperty(Property p, Object o) {
		Literal ol = this.createTypedLiteral(o);
		return this.listSubjectsWithProperty(p, ol);
	}

	public ResIterator listSubjectsWithProperty(Property p, String o) {
		Literal ol = this.createTypedLiteral(o);
		return this.listSubjectsWithProperty(p, ol);
	}

	public ResIterator listSubjectsWithProperty(Property p, String o, String l) {
		Literal ol = this.createLiteral(o, l);
		return this.listSubjectsWithProperty(p, ol);
	}
	
	private ResIterator listSubjectsWithProperty(Property p, Literal o) {
		String sparql = "SELECT DISTINCT ?s WHERE { ?s <" + p.toString() + "> " + o + " . }";
		ResultSet rs = this.query(sparql);
		return new OntoResIterator(this, rs, "s");
	}

	public boolean containsLiteral(Resource s, Property p, boolean o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}

	public boolean containsLiteral(Resource s, Property p, long o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}

	public boolean containsLiteral(Resource s, Property p, int o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}

	public boolean containsLiteral(Resource s, Property p, char o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}

	public boolean containsLiteral(Resource s, Property p, float o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}

	public boolean containsLiteral(Resource s, Property p, double o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}

	public boolean containsLiteral(Resource s, Property p, Object o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}

	public boolean contains(Resource s, Property p, String o) {
		Literal ol = this.createTypedLiteral(o);
		return this.contains(s, p, ol);
	}
	
	public boolean contains(Resource s, Property p, String o, String l) {
		Literal ol = this.createLiteral(o, l);
		return this.contains(s, p, ol);
	}

	private boolean contains(Resource s, Property p, Literal o) {
		String sparql = "SELECT DISTINCT ?s WHERE { <" + s.toString() + "> <" + p.toString() + "> " + o + " . }";
		ResultSet rs = this.query(sparql);
		return rs.hasNext();
	}

	public Statement asStatement(Triple t) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Graph getGraph() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFNode asRDFNode(Node n) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource wrapAsResource(Node n) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFReader getReader() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFReader getReader(String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String setReaderClassName(String lang, String className) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public void resetRDFReaderF() {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public String removeReader(String lang) throws IllegalArgumentException {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFWriter getWriter() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFWriter getWriter(String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String setWriterClassName(String lang, String className) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public void resetRDFWriterF() {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public String removeWriter(String lang) throws IllegalArgumentException {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String getNsPrefixURI(String prefix) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String getNsURIPrefix(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Map<String, String> getNsPrefixMap() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String expandPrefix(String prefixed) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String shortForm(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public String qnameFor(String uri) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public PrefixMapping lock() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public int numPrefixes() {
		logger.error("This method is not implemented, so it returns null.");
		return 0;
	}

	public boolean samePrefixMappingAs(PrefixMapping other) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public void enterCriticalSection(boolean readLockRequested) {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public void leaveCriticalSection() {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public long size() {
		String sparql = "SELECT (count(*) AS ?c) WHERE { ?s ?p ?o . }";
		ResultSet rs = this.query(sparql);
		while(rs.hasNext()) {
			QuerySolution qs = rs.nextSolution();
			RDFNode node = qs.get("c");
			return new Integer(node.asLiteral().getValue().toString());
		}
		return 0;
	}

	public boolean isEmpty() {
		String sparql = "SELECT * WHERE { ?s ?p ?o . }";
		ResultSet rs = this.query(sparql);
		return !(rs.hasNext());
	}

	public ResIterator listSubjects() {
		String sparql = "SELECT DISTINCT ?s WHERE { ?s ?p ?o . }";
		ResultSet rs = this.query(sparql);
		return new OntoResIterator(this, rs, "s");
	}

	public NsIterator listNameSpaces() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource getResource(String uri) {
		return new OntoResource(this, ResourceFactory.createResource(uri));
	}

	public Property getProperty(String nameSpace, String localName) {
		return new OntoProperty(this, ResourceFactory.createProperty(nameSpace + localName));
	}

	public Resource createResource() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource createResource(AnonId id) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Resource createResource(String uri) {
		return new OntoResource(this, ResourceFactory.createResource(uri));
	}

	public Property createProperty(String nameSpace, String localName) {
		return new OntoProperty(this, ResourceFactory.createProperty(nameSpace + localName));
	}

	public Literal createLiteral(String v, String language) {
		return new OntoLiteral(this, ResourceFactory.createLangLiteral(v, language));
	}

	public Literal createLiteral(String v, boolean wellFormed) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Literal createTypedLiteral(String lex, RDFDatatype dtype) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(lex, dtype));
	}

	public Literal createTypedLiteral(Object value, RDFDatatype dtype) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(value.toString(), dtype));
	}

	public Literal createTypedLiteral(Object value) {
		return new OntoLiteral(this, ResourceFactory.createTypedLiteral(value));
	}

	public Statement createStatement(Resource s, Property p, RDFNode o) {
		return new OntoStatement(this, ResourceFactory.createStatement(new OntoResource(this, s), new OntoProperty(this, p), new OntoRDFNode(this, o)));
	}

	public RDFList createList() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFList createList(Iterator<? extends RDFNode> members) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RDFList createList(RDFNode[] members) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Statement s) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Statement[] statements) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model remove(Statement[] statements) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(List<Statement> statements) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model remove(List<Statement> statements) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(StmtIterator iter) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model add(Model m) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model read(String url) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model read(InputStream in, String base) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model read(InputStream in, String base, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model read(Reader reader, String base) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model read(String url, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model read(Reader reader, String base, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model read(String url, String base, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model write(Writer writer) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model write(Writer writer, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model write(Writer writer, String lang, String base) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model write(OutputStream out) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model write(OutputStream out, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model write(OutputStream out, String lang, String base) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model remove(Statement s) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement getRequiredProperty(Resource s, Property p) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement getRequiredProperty(Resource s, Property p, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement getProperty(Resource s, Property p) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Statement getProperty(Resource s, Property p, String lang) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ResIterator listSubjectsWithProperty(Property p) {
		String sparql = "SELECT DISTINCT ?s WHERE { ?s <" + p.toString() + "> ?o . }";
		ResultSet rs = this.query(sparql);
		return new OntoResIterator(this, rs, "s");
	}

	public ResIterator listResourcesWithProperty(Property p) {
		return this.listSubjectsWithProperty(p);
	}

	public ResIterator listSubjectsWithProperty(Property p, RDFNode o) {
		String sparql = "SELECT DISTINCT ?s WHERE { ?s <" + p.toString() + "> ";
		sparql += this.createObjectString(o);
		sparql += " . }";
		ResultSet rs = this.query(sparql);
		return new OntoResIterator(this, rs, "s");
	}

	public ResIterator listResourcesWithProperty(Property p, RDFNode o) {
		return this.listSubjectsWithProperty(p, o);
	}

	public NodeIterator listObjects() {
		String sparql = "SELECT DISTINCT ?o WHERE { ?s ?p ?o . }";
		ResultSet rs = this.query(sparql);
		return new OntoNodeIterator(this, rs, "o");
	}

	public NodeIterator listObjectsOfProperty(Property p) {
		String sparql = "SELECT DISTINCT ?o WHERE { ?s <" + p.toString() + "> ?o . }";
		ResultSet rs = this.query(sparql);
		return new OntoNodeIterator(this, rs, "o");
	}

	public NodeIterator listObjectsOfProperty(Resource s, Property p) {
		String sparql = "SELECT DISTINCT ?o WHERE { <" + s.toString() + "> <" + p.toString() + "> ?o . }";
		ResultSet rs = this.query(sparql);
		return new OntoNodeIterator(this, rs, "o");
	}

	public boolean contains(Resource s, Property p) {
		String sparql = "SELECT DISTINCT ?s WHERE { <" + s.toString() + "> <" + p.toString() + "> ?o . }";
		ResultSet rs = this.query(sparql);
		return rs.hasNext();
	}

	public boolean containsResource(RDFNode r) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean contains(Resource s, Property p, RDFNode o) {
		String sparql = this.createListStatementSPARQL(s, p, o);
		ResultSet rs = this.query(sparql);
		return rs.hasNext();
	}

	public boolean contains(Statement s) {
		return this.contains(s.getSubject(), s.getPredicate(), s.getObject());
	}

	public boolean containsAny(StmtIterator iter) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean containsAll(StmtIterator iter) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean containsAny(Model model) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean containsAll(Model model) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean isReified(Statement s) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public Resource getAnyReifiedStatement(Statement s) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public void removeAllReifications(Statement s) {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public void removeReification(ReifiedStatement rs) {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public StmtIterator listStatements() {
		String query = this.createListStatementSPARQL(null, null, null);
		ResultSet results = this.query(query);
		return new OntoStmtIterator(this, results, null, null, null);
	}

	public StmtIterator listStatements(Selector s) {
		String query = this.createListStatementSPARQL(s.getSubject(), s.getPredicate(), s.getObject());
		ResultSet results = this.query(query);
		return new OntoStmtIterator(this, results, s.getSubject(), s.getPredicate(), s.getObject());
	}

	public StmtIterator listStatements(Resource s, Property p, RDFNode o) {
		String query = this.createListStatementSPARQL(s, p, o);
		ResultSet results = this.query(query);
		return new OntoStmtIterator(this, results, s, p, o);
	}

	public ReifiedStatement createReifiedStatement(Statement s) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public ReifiedStatement createReifiedStatement(String uri, Statement s) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RSIterator listReifiedStatements() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public RSIterator listReifiedStatements(Statement st) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model query(Selector s) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model union(Model model) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model intersection(Model model) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model difference(Model model) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model begin() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model abort() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model commit() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Object executeInTransaction(Command cmd) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public void executeInTxn(Runnable action) {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public <T> T calculateInTxn(Supplier<T> action) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public boolean independent() {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean supportsTransactions() {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean supportsSetOperations() {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public boolean isIsomorphicWith(Model g) {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public void close() {
		logger.error("This method is not implemented, so it returns null.");
		
	}

	public Lock getLock() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model register(ModelChangedListener listener) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model unregister(ModelChangedListener listener) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model notifyEvent(Object e) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model removeAll() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model removeAll(Resource s, Property p, RDFNode r) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public boolean isClosed() {
		logger.error("This method is not implemented, so it returns null.");
		return false;
	}

	public Model clearNsPrefixMap() {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model removeNsPrefix(String arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model setNsPrefix(String arg0, String arg1) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model setNsPrefixes(PrefixMapping arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model setNsPrefixes(Map<String, String> arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	public Model withDefaultMappings(PrefixMapping arg0) {
		logger.error("This method is not implemented, so it returns null.");
		return null;
	}

	private String createListStatementSPARQL(Resource s, Property p, RDFNode o) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		if(s == null) {
			sb.append("?s ");
		}
		if(p == null) {
			sb.append("?p ");
		}
		if(o == null) {
			sb.append("?o ");
		}
		sb.append("\n");
		sb.append("WHERE {\n");
		if(s == null) {
			sb.append("?s ");
		} else {
			sb.append("<");
			sb.append(s.getURI());
			sb.append("> ");
		}
		if(p == null) {
			sb.append("?p ");
		} else {
			sb.append("<");
			sb.append(p.getURI());
			sb.append("> ");
		}
		if(o == null) {
			sb.append("?o ");
		} else {
			sb.append(this.createObjectString(o));
			sb.append(" .");
		}
		sb.append("\n");
		sb.append("}");
		return sb.toString();
	}
	
	private String createObjectString(RDFNode o) {
		if(o.isResource()) {
			if(o.isURIResource()) {
				return "<" + o.toString() + ">";
			}  else if(o.isAnon()) {
				if(o.toString().startsWith("_:")) {
					return o.toString();
				} else {
					return "_:" + o.toString();
				}
			} else { 
				return "<" + o.toString() + ">";
			}
		} else if(o.isLiteral()) {
			return o.toString();
		} else {
			return o.toString();
		}
	}
}
