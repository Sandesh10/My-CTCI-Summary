/*
5.3 Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
find the length of the longest sequence of 1 s you could create.
EXAMPLE
Input: 1775 (11011101111)
Output: 8
*/

/*
Approach:
TIME : O(b),  b= number of bits
SPACE: O(1)

We keep track of only the prev and cur 1 sequence.
When we see 0, we update prevLen as:
 - if nextbit is 1, prevLen should be set to curLen.
 - if nextbit is 0, prevLen should be 0. 
*/

class FlipBittoWin{
	int flipBit(int n){
		if (~n==0) return Integer.BYTES *8;
		int curLen = 0;
		int prevLen = 0;
		int maxLen = 1;
		while (n!=0){
			if ((n & 1)==1){  // cur bit is 1
				curLen++;
			}else if ((n & 1)==0){  //cur bit is 0
				// update to 0 if next is 0 or curLen if next is 1.
				prevLen = (n & 2) == 0 ? 0 : curLen;
				curLen = 0;
			}
			maxLen = Math.max(prevLen + curLen+1, maxLen);
			n >>>=1;
		}
		return maxLen;
	}

	public static void main(String[] args){
		int a = new FlipBittoWin().flipBit(1775);
		System.out.println(a);
	}
}