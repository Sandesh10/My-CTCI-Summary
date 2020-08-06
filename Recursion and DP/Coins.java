/*
8.11 Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
pennies (1 cent), write code to calculate the number of ways of representing n cents.
*/

class Coins{
	int makeChange(int n){
		int[] denoms = {25, 10, 5, 1};
		// store the previous computed values
		int [][] map = new int[n+1][denoms.length];
		return makeChange(n,denoms,0,map);		
	}

	int makeChange(int amount, int[] denoms,
		int index, int[][] map){
		if (map[amount][index]>0){
			return map[amount][index];
		}
		// only one denoms remaining
		if (index>= denoms.length-1) return 1;
		int change = denoms[index];
		int ways=0;
		for(int i=0;i*change<=amount;i++){
			int remaining = amount- i*change;
			ways += makeChange(remaining,denoms, index+1,map);
		}
		map[amount][index] = ways;
		return ways;
	}

	public static void main(String[] args){
		System.out.println(new Coins().makeChange(100));
	}
}

/*
Optimization: Use hashtable to store the previously computed value.
*/