# ShortestPathRL-DP


This is a simple JAVA program to find the shortest path from a given cell to the closest goal cell. 

The program only works for rectangular matrices. 


To run : Down load the who project folder at it is. Navigate to root folder in terminal. Run : javac Main.java
After the program has compiled : Java Main

The program prints the value of valueFunction matrix and policyMatrix after each iteration. At the end, the final result is printed.

Guide to reading policy matrix:
1 -> move North
2 -> move East
4 -> move WEST
8 -> move SOUTH

If there is a cell where you can move NORTH as well as EAST
 => NORTH + EAST = 1 + 2 = 3; Therefore, 3 represents that we can move NORTH as well as EAST.
 Similarly can be done for any other directions.

Initially it is assumed that we can travel to any of the four directions, hence every cell (other than goal) is initialized with 15 (=NORTH+EAST+WEST+SOUTH = 1+2+4+8).

The valueFuntion is assumed to be -1.0 innitially. 

A reward of -1 is awarded for each step taken to each a goal.

Guide to reading final result : 

N -> Move North
E -> Move East
W -> Move West
S -> Move South

If we can move in multiple directions from a cell, multiple characters are used. 
For example if we can move SOUTH as well as EAST, then SE is written.

The program asummes correct input of data i.e., no input exceptions are handled.

Output Example:

Aayushs-MacBook-Air:ShortestPath aayush$ javac Main.java 
Aayushs-MacBook-Air:ShortestPath aayush$ java Main

Enter number of rows: 4
Enter number of columns: 4
Enter number of goals: 2
Enter row number of goal 1: 0
Enter column number of goal 1: 0
Enter row number of goal 2: 3
Enter column number of goal 2: 3



Value Function: 
0.0	-1.0	-1.0	-1.0	
-1.0	-1.0	-1.0	-1.0	
-1.0	-1.0	-1.0	-1.0	
-1.0	-1.0	-1.0	0.0	

Policy: 
0	15	15	15	
15	15	15	15	
15	15	15	15	
15	15	15	0	


Value Function: 
0.0	-1.75	-2.0	-2.0	
-1.75	-2.0	-2.0	-2.0	
-2.0	-2.0	-2.0	-1.75	
-2.0	-2.0	-1.75	0.0	

Policy: 
0	4	4	12	
1	5	15	8	
1	15	10	8	
3	2	2	0	


Value Function: 
0.0	-2.4375	-2.9375	-3.0	
-2.4375	-2.875	-3.0	-2.9375	
-2.9375	-3.0	-2.875	-2.4375	
-3.0	-2.9375	-2.4375	0.0	

Policy: 
0	4	4	12	
1	5	12	8	
1	3	10	8	
3	2	2	0	

Final Result: 
G	  W	  W	  SW	
N	  WN	SW	S	
N	  EN	SE	S	
EN	E	  E 	G	





