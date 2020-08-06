/*
4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
*/


/*
Approach 1:
every time recurse through the entire subtree
TIME COMPLEXITY: O(N log N) since each node is touched once per node above it.
*/
int getHeight(Node root){
	if (root==null) return -1;
	return Math.max(getHeight(root.left), getHeight(root.right))+1;
}

int isBalanced(Node root){
	if (root== null) return true;
	int diff = getHeight(root.left)- getHeight(root.right);
	if (diff>1){
		return false;
	}else{
		return isBalanced(root.left) && isBalanced(root.right);
	}
}

/*
Approach 2:

TIME COMPLEXITY: O(N)
SPACE : O(H) where H is the height of the binary tree.
*/

int checkHeight(Node root){
	if (root==null){
		return -1;
	}

	int left = checkHeight(root.left);
	if (left == Integer.MIN_VALUE) return Integer.MIN_VALUE;

	int right = checkHeight(root.right);
	if (right == Integer.MIN_VALUE) return Integer.MIN_VALUE;

	int diff = Math.abs(left-right);
	if (diff>1){
		return Integer.MIN_VALUE;
	}else{
		return Math.max(left, right)+1;
	}
}

boolean isBalanced(Node root){
	return checkHeight(root)!= Integer.MIN_VALUE;
}
