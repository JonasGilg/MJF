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
			ORDER BY DESC (?calories)
			"""

	const val margarithaCalories =
			"""
			PREFIX foaf: <http://xmlns.com/foaf/0.1/>
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX mjf: <http://michajonasfood.com/>
			SELECT ?foodName sum(?calories)
			WHERE {
				?food a mjf:dish ;
				      mjf:contains ?ingredient ;
					  foaf:name ?foodName .
				?ingredient mjf:caloriesPer100g ?calories .
			}
			GROUP BY ?foodName
			"""

	const val foodWithLessThan100Cals =
			"""
			PREFIX foaf: <http://xmlns.com/foaf/0.1/>
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX mjf: <http://michajonasfood.com/>
			SELECT DISTINCT ?foodName
			WHERE {
				?foodType rdfs:subClassOf mjf:food .
				?food a ?foodType ;
				      foaf:name ?foodName .
				FILTER NOT EXISTS { ?food mjf:caloriesPer100g ?calories }
			}
			"""

	const val someAsk =
			"""
			PREFIX foaf: <http://xmlns.com/foaf/0.1/>
			PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
			PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
			PREFIX mjf: <http://michajonasfood.com/>
			ASK {
				?pizza foaf:name "margarita" .
				FILTER EXISTS { ?pizza mjf:contains mjf:basil } .
			}
			"""

	val possibleDishesFromFridge = "TODO"
}