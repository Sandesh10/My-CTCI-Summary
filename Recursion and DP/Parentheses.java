/*
8.9 Parens: Implement an algorithm to print all valid (Le., properly opened and closed) combinations
of n pairs of parentheses.
*/

/*
Approach:

On each recursive call, we have the index for a particular character in the string. We need to select either a
left or a right paren. When can we use a left paren, and when can we use a right paren?
1. Left Paren: As long as we haven't used up all the left parentheses, we can always insert a left paren.
2. Right Paren: We can insert a right paren as long as it won't lead to a syntax error. When will we get a
syntax error? We will get a syntax error if there are more right parentheses than left.
*/


import java.util.*;
class Parentheses {
	public void addParen(ArrayList<String> res,int left, int right, char[] charArray, int index){
		if (left<0 || right<left) return; // invalid state

		if (left==0 && right==0){
			res.add(String.copyValueOf(charArray));
		}else{
			charArray[index] = '(';
			addParen(res,left-1,right,charArray,index+1);
			charArray[index] = ')';
			addParen(res,left,right-1,charArray, index+1);
		}
	}

	public ArrayList<String> generateParens(int count){
		char[] str = new char[2*count];
		ArrayList<String> ls = new ArrayList<String>();
		addParen(ls,count,count,str,0);
		return ls;
	}

	public static void main(String[] args){
		ArrayList<String> res = new Parentheses().generateParens(3);
		for(String s: res){
			System.out.println(s);
		}
	}
}