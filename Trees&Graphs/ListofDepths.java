/*
List of Depths: Given a binary tree, design an algorithm which creates 
a linked list of all the nodes at each depth 
(e.g., if you have a tree with depth D, you 'll have D linked lists).
*/


// DFS approach
void createLevelLinkedList(Node root, 
			ArrayList<LinkedList<Node>> lists,
			int level)
{
	if (root==null) return;  // base case.

	LinkedList<Node> list = null;
	if (lists.size()==level)  // level not contained in list
	{
		list = new LinkedList<Node>();
		lists.add(list);
	}else
	{
		list = lists.get(level)
	}
	list.add(root);
	createLinkedList(root.left,lists, level+1);
	createLinkedList(root.right,lists, level+1);
}

ArrayList<LinkedList<Node>> createLevelLinkedList(Node n){
	ArrayList<LinkedList<Node>> res = new ArrayList<LinkedList<Node>>();
	createLevelLinkedList(n, res,0);
	return lists;
}


// BFS approach - Level Order approach

/*

Time Complexity: O(N) for both BFS and DFS
Space Complexity:
	For DFS - O(log N) for recursive call
	        - O(N) for returning data;
	Overall = O(N)

	For BFS - no recursive call
	        - O(N) for data that must be returned.

*/