/*
8.4 Power Set: Write a method to return all subsets of a set.
*/


/*
RECURSIVE APPROACH:

We compute P(n-1), clone the result and then add nth element to each of these cloned sets.
*/
import java.util.*;

class PowerSet{
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets;
		if(set.size()==index){ // base case - add empty set
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>(Arrays.asList()));

		}else{
			allSubsets = getSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allSubsets){
				ArrayList<Integer> newset = new ArrayList<>();
				newset.addAll(subset);
				newset.add(item);
				moresubsets.add(newset);
			} 
			allSubsets.addAll(moresubsets);	
		}
		return allSubsets;
	}

	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> res = new PowerSet().getSubsets(
			new ArrayList<Integer>(Arrays.asList(1,2,3)), 0);
		for(ArrayList<Integer> a: res){
			for(Integer i:a){
				System.out.print(i);
			}
			System.out.println();
		}
	}	
}

/*
Time: O(N*2^N)
Space: O(N*2^N)
*/

