/*2.6 Palindrome: Implement a function to check if a linked list is a palindrome.

Approach:
1. reverse the linked list and compare the reversed list to the original list 
    -  Reverse and clone
	-  Reverse

2. Recursive :
*/


class Node{
	Node next;
	int data;

	public Node(int data){
		this.next=null;
		this.data=data;
	}
}

class LinkedListPalindrome{
	
	// reverse and clone
	public static Node reverseAndClone(Node node){
		Node head=null;
		while(node!=null){
			Node temp= new Node(node.data);  //clone
			temp.next = head;
			head = temp;
			node = node.next;
		}
		return head;
	}

	// REVERSE WITHOUT CLONE 
	public static Node reverse(Node head){
		Node prev = null;
		Node cur=head;
		while (cur!=null){
			Node temp = cur.next;
			cur.next = prev;
			prev= cur;
			cur = temp;
		}
		head = prev;
		return head;
	}

	public static boolean isEqual(Node p, Node q){
		while(p!=null && q!=null){
			if (p.data!=q.data){
				return false;
			}
			p = p.next;
			q = q.next;
		}
		return p==null && q==null;
	}

	public static void main(String[] args){
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(5);
		Node n4 = new Node(6);
		Node n5 = new Node(52);
		Node n6 = new Node(12);
		Node n7 = new Node(71);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		Node m = reverse(n1);
		boolean b = isEqual(n1,m);
		System.out.println(b);
		
	}
}