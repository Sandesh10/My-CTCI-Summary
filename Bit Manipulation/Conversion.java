/*
5.6 Conversion: 
Write a function to determine the number of bits you 
would need to flip to convert integer A to integer B.
EXAMPLE
Input:  29 (or: 111(1), 15 (or: (1111)
Output: 2
*/

/*
Approach:
XOR to see how many bits are different between two numbers.
*/

int bitSwapRequired(int n1, int n2){
	int count = 0;
	for (int i = n1 ^ n2; i!=0;i=i>>1){
		count += i & 1;
	}
}