/*
2.8 Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.

EXAMPLE
Input: A -> B -> C - > D -> E -> C [the same C as earlier)
Output: C

Our algorithm is derived directly from parts 1, 2 and 3.
1. Create two pointers, FastPointer and SlowPointer.
2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
4. Move SlowPointer and FastPointer at a·rate of one step. Return the new collision point.

*/

class LoopDetectionLinkedList{

	public static Node findLoop(Node head){
		Node fast=head;
		Node slow=head;

		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}

		// no loop
		if (fast==null || fast.next==null){
			return null;
		}
		// System.out.println(slow.data+" "+fast.data);
		

		/* slow points to head. Each are k steps from
		the loop start. If they move at the same pace, 
		they must meet at Loop start.
		*/
		slow = head;
		while(slow !=fast){
			// System.out.println(slow.data+" "+fast.data);
			slow = slow.next;
			fast = fast.next;
		}
	return fast;	
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
		n7.next = n3;

		Node sloop = findLoop(n1);
		System.out.println(sloop.data);	
	}
	
}

