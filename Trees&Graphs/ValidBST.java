/*
Validate 8ST: Implement a function to check if a binary tree is a binary search tree.
*/

/* Approach 1: In-order traversal and storing it in
array and verifying
*/

// static int index = 0;

// void storeBST(Node root,int[] arr){
// 	if (root==null) return;
// 	storeBST(root.left, arr);
// 	arr[index]= root.data;
// 	index++;
// 	storeBST(root.right, arr);
// }

// boolean checkBST(Node root){
// 	int[] arr = new int[root.size];
// 	storeBST(root,array);
// 	for (int i=1;i<arr.length;i++){
// 		if(arr[i]<= arr[i-1]) return false;
// 	}
// 	return true;
// }


/*
Approach 2: Min-Max solution
*/
class ValidBST{
	boolean checkBST(Node root){
		return isBST(root, null, null);
	}


	boolean isBST(Node root, Integer min, Integer max){
		if (root==null){
			return true;
		}

		if (((min!=null) && root.data<=min) || ((max!=null) && root.data>max)) {
			return false;
		}

		return isBST(root.left, min, root.data) && isBST(root.right, root.data,max);
	}

	public static void main(String[] args){
		int[] arr = new int[]{11,2,3,4,5,6,7,8,9,10};
		MinimalTree obj = new MinimalTree();
		Node r = obj.createMinimalBST(arr);
		boolean status = new ValidBST().checkBST(r);
		System.out.println(status);
	}	
}