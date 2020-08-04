##Task 331:
##### 	An integer number n is given, n>1.Get combination of one/all x,y,z that n = x*x + y*y + z*z
##                                  OneCombination true

                      Invalid                                  Valid
	---------------------------------------|----------------------------------------
                    Partition 1              2   3          Partition 2

Equivalence partitioning
	Representative from each equivalence class:
	Valid  P2 : 3; 9;
	Invalid P1 : 2
Boundary value
	Valid: 2; 3
	Invalid: Integer.MAX_VALUE + 1; -1;-2; 0; Integer.MIN_VALUE; Integer.MIN_VALUE
The total amount of tests = 9

##              					OneCombination false

                      Invalid                                  Valid
	---------------------------------------|----------------------------------------
                    Partition 1              2   3          Partition 2

Equivalence partitioning

	Representative from each equivalence class:
	Valid  P2 : 3; 9;
	Invalid P1 : 2
Boundary value
	Valid: 2; 3
	Invalid: Integer.MAX_VALUE + 1; -1;-2; 0; Integer.MIN_VALUE; Integer.MIN_VALUE
The total amount of tests = 9

