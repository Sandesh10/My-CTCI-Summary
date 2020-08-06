/*
Recursive Multiply: Write a recursive function to multiply two positive integers without using
the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
minimize the number of those operations.
*/

/*
Approach:
minProduct(31, 35) = 2 * minProduct(15, 35) + 35
*/

int minProduct(int a, int b) {
	int bigger = a >b ? a : b;
	int smaller = a >b? b: a;
	return minProduct(smaller, bigger);
}

int minProductHelper(int smaller, int bigger){
	if (smaller == 0){return 0;}
	else if (smaller == 1){return bigger;}

	int s = smaller >> 1;
	int halfProd = minProductHelper(s, bigger);
	if (smaller %2 == 0){
		return halfProd + halfProd;
	}else{
		return halfProd + halfProd + bigger;
	}
}

/*
Complexity:
Time: O(log s) where s is the smallest of the two numbers;
*/