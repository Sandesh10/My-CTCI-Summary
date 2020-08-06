/*
8.8 Permutations with Duplicates: Write a method to compute all permutations of a string whose
characters are not necessarily unique. The list of permutations should not have duplicates.
*/

/*
Why approach from permutation I is not a better approach?
Consider a string with all duplicate characters, like aaaaaaaaaaaaaaa. This will take
an extremely long time (since there are over 6 billion permutations of a 13-character string), even though
there is only one unique permutation.
Ideally, we would like to only create the unique permutations, rather than creating every permutation and
then ruling out the duplicates.
*/

import java.util.*;

class PermutationII {
	ArrayList<String> getPerms(String s){
		ArrayList<String> res = new ArrayList<String>();
		HashMap<Character,Integer> map = buildMap(s);
		helper(map, "", s.length(), res);
		return res;
	}

	HashMap<Character, Integer> buildMap(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c: s.toCharArray()){
			if (!map.contains(c)){
				map.put(c,0);	
			}
			map.put(c, map.get(c)+1);
		}
		return map;
	}

	void helper(HashMap<Character, Integer> map, String cur, int remaining, 
		ArrayList<String> res){
		if (remaining==0){
			res.add(cur);
			return;
		}

		for (Character c: map.KeySet()){
			int count = map.get(c);
			if (count>0){
				map.put(c, count-1);
				helper(map, cur+c,remaining-1,result);
				map.put(c,count);
			}
		}
	}
}