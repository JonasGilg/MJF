
import org.apache.jena.query.QueryExecutionFactory
import org.apache.jena.query.QueryFactory
import org.apache.jena.query.ResultSetFormatter
import org.apache.jena.rdf.model.ModelFactory


class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val model = ModelFactory.createDefaultModel()
            model.read(Queries.javaClass.getResource("mjfOntology.ttl").file, "TURTLE")

            val query = QueryFactory.create(Queries.fridgeContents)

            val result = QueryExecutionFactory.create(query, model)
            val results = result.execSelect()

            ResultSetFormatter.out(System.out, results, query)
        }
    }

}