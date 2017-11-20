object Queries {
	const val foodTypes =
			"""
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX mjf: <http://michajonasfood.com/>
			SELECT DISTINCT ?x
			WHERE {
				?x  rdfs:subClassOf mjf:food .
			}
			"""

	const val allFood =
			"""
			PREFIX foaf: <http://xmlns.com/foaf/0.1/>
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX mjf: <http://michajonasfood.com/>
			SELECT DISTINCT ?foodName
			WHERE {
			    ?t  rdfs:subClassOf mjf:food .
			    ?food a ?t ;
			    foaf:name ?foodName .
			}
			"""

	const val fridgeContents =
			"""
			PREFIX foaf: <http://xmlns.com/foaf/0.1/>
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX mjf: <http://michajonasfood.com/>
			SELECT DISTINCT ?foodName
			WHERE {
				mjf:fridge  mjf:hasFood ?f .
				?f foaf:name ?foodName .
			}
			"""

	const val foodWithCalories =
			"""
			PREFIX foaf: <http://xmlns.com/foaf/0.1/>                          
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX mjf: <http://michajonasfood.com/>
			SELECT DISTINCT ?foodName ?calories
			WHERE {
			    ?t  rdfs:subClassOf mjf:food .
			    ?food a ?t ;          
				foaf:name ?foodName .    
				OPTIONAL { ?food mjf:caloriesPer100g ?calories }
			}
			"""

	val possibleDishesFromFridge = "TODO"
}