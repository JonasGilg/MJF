
object Queries{
    val foodTypes = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX mjf: <http://michajonasfood.com/>\n" +
            "SELECT DISTINCT ?x \n" +
            "WHERE {\n" +
            "    ?x  rdfs:subClassOf mjf:food .\n" +
            "}"
    val allFood = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX mjf: <http://michajonasfood.com/>\n" +
            "SELECT DISTINCT ?foodName \n" +
            "WHERE {\n" +
            "    ?t  rdfs:subClassOf mjf:food .\n" +
            "    ?food a ?t ;" +
            "    foaf:name ?foodName ." +
            "}"

    val fridgeContents = "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX mjf: <http://michajonasfood.com/>\n" +
            "SELECT DISTINCT ?foodName \n" +
            "WHERE {\n" +
            "    mjf:fridge  mjf:hasFood ?f .\n" +
            "    ?f foaf:name ?foodName ." +
            "}"

    val possibleDishesFromFridge = "TODO"


}