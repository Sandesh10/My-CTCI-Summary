/*
2.2 Return Kth to Last: Implement an algorithm to find 
the kth to last element of a singly linked list.
*/


class Node{
	Node next;
	int data;

	public Node(int data){
		this.next=null;
		this.data=data;
	}
}

//for recursive approach 2
class Index {
	public int val = 0;
}

class KthtoLastElement{
	// Recursive which prints and not return.
	public static int kthToLast(Node head,int k){
		if (head==null){
			return 0;
		}
		int index = kthToLast(head.next,k)+1;
		if (index==k){
			System.out.println(k+"th to last element is "+head.data);
		}
		return index; 
	}

	// Recursive approach 2
	public static Node kthToLast2(Node head, int k){
		Index idx = new Index();
		return kthToLast(head,k,idx);
	}

	public static Node kthToLast(Node head, int k, Index idx){

		if (head==null){
			return null;
		}
		// System.out.println("Before : "+head.data+" , "+k+" , "+idx.val);
		// Recursive call
		Node node = kthToLast(head.next, k, idx);
		idx.val +=1;
		// System.out.println("After : "+head.data+" , "+k+" , "+idx.val);
		if(idx.val == k){
			return head;
		}
		return node;
	}

	// Iterative Approach 2
	public static Node kthToLastIterative(Node head,int k){
		Node p1 = head;
		Node p2 = head;

		for (int i=0;i<k;i++){
			if (p1==null) return null;
			p1 = p1.next;
		}

		/* Now Move both pointers. When P1 hits the end
		P2 will be at the kth element. */

		while(p1 !=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;		
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
		kthToLast(n1,5);
		Node res1 = kthToLast2(n1,5);
		System.out.println(res1.data);

		Node res2 = kthToLastIterative(n1,5);
		System.out.println(res2.data);

	}
}

/* Analysis:
	Recursive method:
	Space complexity: O(n)  // due to recursive call

	Iterative method:
	Time complexity: O(n)
	Space complexity: O(1)
*/