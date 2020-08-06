/*
2.3 Delete Middle Node: Implement an algorithm to delete a 
node in the middle (Le., any node but the fi rst and last 
node, not necessarily the exact middle) of a singly linked list, 
given only access to that node.
EXAMPLE
Input: the node c from the linked list a - >b- >c - >d - >e- >f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f

*/

// Does not work for the last node in the linked list.
// For last node, we can considering making a node as dummy.
class Node{
	Node next;
	int data;

	public Node(int data){
		this.next=null;
		this.data=data;
	}
}

class DeleteMiddleNode{
	public static boolean deleteNode(Node n){
		if (n==null || n.next==null){
			return false;
		}
		Node temp = n.next;
		n.data = temp.data;
		n.next = temp.next;
		return true;
	}

	public static void printLinkedList(Node head){
		while (head!=null){
			System.out.print(head.data+" -> ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		Node n1 = new Node(10);
		Node n2 = new Node(1);
		Node n3 = new Node(5);
		Node n4 = new Node(6);
		Node n5 = new Node(10);
		Node n6 = new Node(1);
		Node n7 = new Node(9);
		Node n8 = new Node(11);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		printLinkedList(n1);
		deleteNode(n7);
		printLinkedList(n1);
	}
}