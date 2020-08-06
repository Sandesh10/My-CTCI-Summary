/*
2.5 
Sum Lists: You have two numbers represented by a linked list, 
where each node contains a single digit. The digits are stored 
in reverse order, such that the 1 's digit is at the head of 
the list. Write a function that adds the two numbers 
and returns the sum as a linked list.

EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.
Output: 2 - > 1 - > 9. That is, 912.

FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
Output: 9 - > 1 - > 2. That is, 912.
*/

class Node{
	Node next;
	int data;

	public Node(int data){
		this.next=null;
		this.data=data;
	}
}

class SumLists{

	public static Node addLists(Node n, Node m, int carry){
		if (n==null && m==null && carry==0){
			return null;
		}
		Node res;
		int val = carry;
		if (n!=null){
			val += n.data;
		}
		if (m!=null){
			val+= m.data;
		}
		res = new Node(val %10);
		carry = val/10;

		if (n!=null || m!=null){
			Node temp = addLists(n==null?null:n.next, 
								 m==null?null:m.next,
								 carry);
			res.next = temp;	
		}
		
		return res;

	}

	public static void printLinkedList(Node head){
		while (head!=null){
			System.out.print(head.data+" -> ");
			head = head.next;
		}
		System.out.println();
	}


	public static void main(String[] args){
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(5);
		Node n4 = new Node(6);
		
		Node m1 = new Node(5);
		Node m2 = new Node(1);
		Node m3 = new Node(9);
		Node m4 = new Node(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		m1.next = m2;
		m2.next = m3;
		m3.next = m4;

		/*
		Input: (7->1->5->6 + 5->1->9->2) = 6517+3915
		Output:  10432
		*/
		Node n = addLists(n1,m1,0);
		printLinkedList(n);
	}
}