class Insertion{
	int updateBits(int n, int m, int i, int j){
		int allOnes = ~0;  // all 1s
		// 1s before position j then 0s.
		int left = allOnes <<(j+1);
		int right = ((1<<i)-1);
		int mask = left | right;

		// clear bits j through i then put mask in there
		int clear = n & mask; // clear bits j through i
		int m_shifted = m<<i;
		return clear | m_shifted;

	}
	public static void main(String [] args){
		int N = 2048;
		int M = 19;
		int i = 2;
		int j = 6;

		int res = new Insertion().updateBits(N,M,i,j);
		System.out.println(Integer.toBinaryString(res));
	}
}

//Output: 10001001100