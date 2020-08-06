/*
8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
*/

import java.util.*;

class TripleStep {
	public static int countWays(int n){
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}

	public static int countWays(int n, int[] memo){
		if (n<0){
			return 0;
		}
		else if (n==0){
			return 1;
		}else if (memo[n]>-1){
			return memo[n];
		}else{
			return countWays(n-1, memo)+ countWays(n-2, memo)+ countWays(n-3, memo);
		}
	}

	public static void main(String[] args){
		int count = countWays(10);
		System.out.println(count);
	}
}


/*
Brute Force: O(3^n);
Memoization: 
      Time: O(n);
      Space: number of ways can quickly overflow. Using long can delay
             but not completely solve this issue;
			How to solve?
			- use BigInteger class;             

*/