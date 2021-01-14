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
		#Addition postive test case
    	| 	4 			|   6			|		+			| =			| 	10			|
    	#Addition negative test case
    	| 	% 			|   /			|		+			| =			| 	Error		|
    	#Addition boundry value test case
    	| 	0 			|   0			|		+			| =			| 	0			|
    	#Substraction postive test case
    	| 	5 			|   3			|		-			| =			| 	2			|
    	#Substraction negative test case
    	| 	% 			|   /			|		-			| =			| 	Error		|
    	#Division postive test case
    	| 	8 			|   2			|		/			| =			| 	4			|
    	#Division negative test case
    	| 	- 			|   /			|		/			| =			| 	Error		|


