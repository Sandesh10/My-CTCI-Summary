/*
2.7 Intersection: Given two (singly) linked lists, determine 
if the two lists intersect. Return the intersecting node. 
Note that the intersection is defined based on reference, not 
value. That is, if the kth node of the first linked list is 
the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.	
*/

Putting it all together.
We now have a multistep process.
1. Run through each linked list to get the lengths and the tails.
2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
3. Set two pointers to the start of each linked list.
4. On the longer linked list, advance its pointer by the difference in lengths.
5. Now, traverse on each linked list until the pointers are the same.


class LinkedListIntersection{
		

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