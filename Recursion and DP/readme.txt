Recursion can be used for problems statements:
    - Design an algorithm to compute the nth.....
    - Write code to list the first n.....
    - Implement a method to compute all.....

Recursion: divide problem into sub-problems
--------------------------------------------------
 Approach to divide a PROBLEM into SUB-PROBLEMS:

Bottom Up Approach:
 - start with solving the problem for simple case (eg: for 1 element) and progress.

 Top-Down Approach:
 - Think about how we can divide the problem for case N into sub problems.

 Half and Half Approach:
 - Divide the data set in half.
 - Eg: Binary search works with a "half and half" approach.

 -------------------------------------------------
Recursion: 
- very space inefficient as each call adds a new layer to the stack.
- All recursive algorithm can be implemented recursively.


DYNAMIC PROGRAMMING:
- taking a recursive algorithm and finding the overlapping subproblems.

Memoization: top-down
Dynamic Programming: bottom-up


Fibonacci Numbers with Memoization: [Top-down]
/*
	Runtime: O(n)
*/
int fibonacci(int n){
	return fibo(n, new int[n+1]);
}

int fibo(int n, int[] memo){
	if (n==0||n==1) return 1;
	if (memo[n]==0){
		memo[n] = fibo(n-1, memo)+ fibo(n-2, memo);
	}
	return memo[n];
}

Bottom-up:
int fibo_bottomup(int n){
	if (n==0) return 0;
	else if (n==1) return 1;

	int [] memo = new int[n];
	memo[0]=1;
	memo[1]=1;
	for(int i=2;i<n;i++){
		memo[i] = memo[i-1]+ memo[i-2];
	}
	return memo[n-1]+memo[n-2];
}
