/*
8.7. Permutations without Dups: Write a method to compute all permutations of a string of unique
characters.
*/

/*
Approach 1: 
P(abc) = {a+P(b,c)| + {b+P(a,c)} + {c + P(a,b)}
       = abc + acb + bac + bca + cab + cba
*/
class Permutation {
	ArrayList<String> getPerms(String remainder){
		int len = remainder.length();
		ArrayList<String> result =  new ArrayList<String>();

		if (len ==0){
			result.add("");
			return result;
		}

		for (int i=0;i< len; i++){
			String before = remainder.substring(0,i);
			String after = remainder.subString(i+1,len);

			ArrayList<String> partials = getPerms(before+ after);

			// prepend char i to each permutation
			for (String s:partials){
				result.add(remainder.charAt(i)+s);
			}
		}
		return result;
	}	
}

/*
Runtime: O(n!)
Explaination: If we have 7 characters then, once we pick the first letter,
we have 6 choices and so on. So, there are n! permutation.
*/
