/*
3.5 Sort Stack: Write a program to sort a stack such that 
the smallest items are on the top. You can use an additional
 temporary stack, but you may not copy the elements into any 
 other data structure(such as an array). The stack supports 
 the following operations: push, pop, peek, and isEmpty.
*/

/*
Approach 1:
Use 3 stacks:
- find smallest element each time[usong two stacks] 
and push into the stack3.

Approach 2:
Use 2 stacks:
- use temp stack
- push elements in temp stacks in such a way that the 
smallest elements are pushed first.
This can be done by:
while !t.isEmpty():
	if t.peek()> cur:
	stack.push(t.pop())
t.push(cur)

*/

import java.util.*;

 class SortStack{
 	public static void sortStack(Stack<Integer> s){
 		Stack<Integer> t =  new Stack<Integer>();
 		while(!s.isEmpty()){
 			int temp= s.pop();
 			while(!t.isEmpty() && t.peek()>temp){
 				s.push(t.pop());
 			}
 			t.push(temp);
 		}
 		// copy elements back to stack s.
 		while(!t.isEmpty()){
 			s.push(t.pop());
 		}

 	}

 	public static void printStack(Stack<Integer> s){
 		while(!s.isEmpty()){
 			System.out.print(s.pop()+" - ");
 		}
 		System.out.println();
 	}

 	public static void main(String[] args){
 		Stack<Integer> s = new Stack<Integer>();
 		int[] nums = new int[] {100,22,55,3,87,13,12};
 		for(int i:nums){
 			s.push(i);
 		}
 		sortStack(s);
 		printStack(s);
 	}	
 }

 /*
	Time complexity: O(N^2)
	Space complexity: O(N)

 */