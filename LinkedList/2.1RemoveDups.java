/*
2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?

SOLUTION 1:
Hash Table:
Iterate through the linklist, adding each element into the hash
table. When we discover a duplicate element, we remove the element
and continue iterating.
 	HashSet<Integer> set =  new HashSet<Integer>();
 	set.add(n.data);
 	if (set.contains(n.data)) {prev.next = cur.next;}
	
Time Complexity: O(N)


SOLUTION 2: [If no buffer allowed]
If no buffer is allowed, then we can iterate with two pointers - current 
which iterate through the linked list, and runner which checks all subsequent 
nodes for duplicates.

Time Complexity: O(N2)
Space Complexity: O(1)


*/

class Node{
	Node next;
	int data;

	public Node(int data){
		this.next=null;
		this.data=data;
	}
}

class RemoveDups{
	public static Node removeDuplicate(Node head){
		if (head.next==null){
			return head;
		}
		Node cur = head;
		while(cur!=null){
			Node runner = cur;
			while (runner.next!=null){
				if(runner.next.data == cur.data){
					System.out.println("Duplicate"+runner.next.data);
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			cur = cur.next;
		}
		return head; 
	}

	public static void printLinkedList(Node head){
		while (head!=null){
			System.out.println(head.data);
			head = head.next;
		}
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
		removeDuplicate(n1);
		printLinkedList(n1);
	}
}