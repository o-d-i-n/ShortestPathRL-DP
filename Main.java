import java.util.*;
import PolicyFolder.*;

import PolicyFolder.ValueFunctionFolder.*;
public class Main{
	public static void main(String[] args) {
		boolean firstIteration = true;
		int row, col, numOfGoals;
		int[] goal;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of rows: ");
		row = scan.nextInt();
		System.out.print("Enter number of columns: ");
		col = scan.nextInt();
		System.out.print("Enter number of goals: ");
		numOfGoals = scan.nextInt();
		goal = new int[2*numOfGoals];
		for(int i=0;i<numOfGoals;i++){
			System.out.print("Enter row number of goal " + (i+1) + ": ");
			goal[2*i] = scan.nextInt();
			System.out.print("Enter column number of goal " + (i+1) + ": ");
			goal[2*i+1] = scan.nextInt();
		}
		System.out.println();
		System.out.println();

		ValueFunction valueFunction = new ValueFunction(row,col,goal);
		Policy oldPolicy = new Policy(row,col,goal);
		Policy newPolicy = new Policy(row,col,goal);

		while(!oldPolicy.equals(newPolicy) || firstIteration){
			System.out.println();

			if(firstIteration){
				System.out.println("Value Function: ");
				valueFunction.printValueFunction();
				System.out.println();
				System.out.println("Policy: ");
				newPolicy.printPolicy();
				firstIteration = false;
				valueFunction.updateValueMatrix();
				newPolicy.updatePolicy(valueFunction);

			}
			else{
				System.out.println();
				System.out.println("Value Function: ");
				valueFunction.printValueFunction();
				System.out.println();
				System.out.println("Policy: ");
				newPolicy.printPolicy();
				oldPolicy.copy(newPolicy.returnPolicyMatrix());
				valueFunction.updateValueMatrix();
				newPolicy.updatePolicy(valueFunction);
			}
		}
		System.out.println();
		System.out.println("Final Result: ");
		newPolicy.printConvertedPolicy();
		System.out.println();
	}
}