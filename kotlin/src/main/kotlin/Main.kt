
import org.apache.jena.query.QueryExecutionFactory
import org.apache.jena.query.QueryFactory
import org.apache.jena.query.ResultSetFormatter
import org.apache.jena.rdf.model.ModelFactory


fun main(args: Array<String>) {
	val model = ModelFactory.createDefaultModel()
	model.read("file:C:\\Users\\jonas\\IntelliJProjects\\MJF\\kotlin\\src\\main\\resources\\mjfOntology.ttl", "TURTLE")

	val query = QueryFactory.create(
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
			"PREFIX mjf: <http://michajonasfood.com/>\n" +
			"\n" +
			"SELECT ?x\n" +
			"WHERE {\n" +
			"    ?x ?z mjf:food .\n" +
			"}")

	val result = QueryExecutionFactory.create(query, model)
	val results = result.execSelect()

	ResultSetFormatter.out(System.out, results, query)
}