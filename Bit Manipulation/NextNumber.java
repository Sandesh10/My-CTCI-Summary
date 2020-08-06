/*
5.4 Next Number: 
Given a positive integer, print the next smallest and the next largest
 number that have the same number of 1 bits in their binary representation.
*/

/*
Approach 1: Bit Manipulation Approach
Observation: Given a number n and two bit locations i and j, 
suppose we flip bit i from a 1 to a 13, and bit j from a 13 
to a 1. If i > j, then n will have decreased. If i < j, then
 n will have increased.

 Page: 294 solution
*/

class NextNumber{
	int getNextLargerst(int n){
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c&1)==0) && (c!=0)){
			c0++;
			c >>=1;
		}
		while ((c & 1)==1){
			c1++;
			c >>=1;
		}

		if (c0+c1==0){
			return -1;
		}

		// position of rightmost non-trailing zero
		int p = c0+c1;

		// flip rightmost non-trailing zero
		n |= (1<<p);

		//clear all bits to the right of p
		int a = 1<<p;   // all 0s except 1 at pth position
		int b = a-1;    // 0s followed by p 1s.
		int mask = ~b;
		n = n & mask;   // n &= ~((1<<p)-1);
 
		// Insert (c1-1) ones to the right
		a = 1<<(c1-1);
		b =  a-1;
		n = n | b;    // n |= (1<<(c1-1))-1

		return n;
	}

	int getNextSmallest(int n){
		int temp =n;
		int c0 = 0;
		int c1 = 0;

		while (temp & 1==1){
			c1++;
			temp >>=1;
		}

		if (temp==0) return -1;

		while((temp & 1)==0) && (temp!=0){
			c0++;
			temp>>=1;
		}
		int p = c0 + c1; // position of rightmost non-trailing one
		n &= ((~0) << (p+1)) // clear from bit p onwards

		int mask = (1<<(c1+1))-1 // sequence of (c1+1) ones
		n |= mask <<(c0-1);

		return n;
	}


	public static void main(String[] args){
		int res = new NextNumber().getNextLargerst(13948);
		System.out.println(res);
	}
}