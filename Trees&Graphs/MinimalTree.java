/*
Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
algorithm to create a binary search tree with minimal height.
*/

class Node{
	int data;
	Node left, right;

	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class MinimalTree{
	public Node createMinimalBST(int[] arr){
		return createBST(arr, 0, arr.length-1);
	}

	public Node createBST(int[] arr, int start, int end){
		if(end<start){
			return null;
		}
		System.out.println(start+" "+end);
		int mid = (end+start)/2;
		Node root = new Node(arr[mid]);
		root.left = createBST(arr,start, mid-1);
		root.right = createBST(arr,mid+1,end);
		return root;		
	}

	public void printTree(Node root){
		if(root==null){
			System.out.println();
			return;
		}
		
		if (root.left!=null) {
			this.printTree(root.left);}
		System.out.print(root.data+" ");
		if (root.right!=null) {this.printTree(root.right);}

	}

	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		MinimalTree obj = new MinimalTree();
		Node r = obj.createMinimalBST(arr);
		// obj.printTree(r);
	}

}