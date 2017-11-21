
import org.apache.jena.query.QueryExecutionFactory
import org.apache.jena.query.ResultSetFormatter
import org.apache.jena.query.Syntax
import org.apache.jena.rdf.model.ModelFactory


fun main(args: Array<String>) {
	val model = ModelFactory.createDefaultModel()
	model.read(Queries.javaClass.getResource("mjfOntology.ttl").file, "TURTLE")

	val query = Queries.someAsk

	val result = QueryExecutionFactory.create(query, Syntax.syntaxARQ, model)
	val results = result.execAsk()

	ResultSetFormatter.out(System.out, results)
}