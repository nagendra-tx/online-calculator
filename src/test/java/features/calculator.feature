Feature: Test online calculator scenarios
Scenario Outline: Test subtraction, division and CE functionalities
Given Open chrome browser and start application
When I enter following values and press CE button
			|value1 		| <value1>		|
			|operator1 		| <operator1>	|
			|value2 		| <value2>		|
			|operator2 		| <operator2>	|			
Then I should be able to see
			|	expected |<expected>|
Examples:
		| value1  		| value2 		| operator1			| operator2	|	expected	|
    	| 	4 			|   6			|		+			| =			| 	10			|
    	| 	5 			|   2			|		-			| =			| 	3			|
    	| 	2 			|   2			|		/			| =			| 	1			|
    	| 	3 			|   5			|		-			| =			| 	-2			|

