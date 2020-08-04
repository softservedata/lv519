** Task 554:
 
*	An integer number n is given, n>1. find all a,b,c that a*a + b*b = c*c

                      Invalid                                  Valid
	---------------------------------------|----------------------------------------
                    Partition 1              0   1          Partition 2

Equivalence partitioning

	Representative from each equivalence class:
	Valid  P2 : 5,15; 20
	Invalid P1 : 1;2;3;4;-1;-2;Integer.MAX_VALUE + 1; Integer.MIN_VALUE
Boundary value

	Valid: 5
	Invalid: Integer.MIN_VALUE
	
The total amount of tests = 7