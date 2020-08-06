/*
Approach: 
1. Runner:
  - use fast and slow runner.
  - fast = fast.next.next  for each slow=slow.next

Push the fast half of the linkedlist into the stack.
If odd length, then do, slow = slow.next;
Pop element from stack and compare with the slow.

*/

import java.util.*;

class Node{
	Node next;
	int data;

	public Node(int data){
		this.next=null;
		this.data=data;
	}
}

class LinkedListPalindromeIterative{
	public static boolean isPalindrome(Node head){
		Node fast = head;
		Node slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		/*
		Push first half into the stack. When the fast runner
		reaches the end of the linkedlist, we know we are at 
		the middle.
		*/
		while(fast!=null && fast.next!=null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		// for linked list with odd number of elements.
		if(fast!=null){
			slow= slow.next;
		}

		while(slow!=null){
			int top = stack.pop().intValue();

			if(top!=slow.data){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args){
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(5);
		Node n4 = new Node(6);
		Node n5 = new Node(5);
		Node n6 = new Node(1);
		Node n7 = new Node(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		
		boolean b = isPalindrome(n1);
		System.out.println(b);
		
	}
}