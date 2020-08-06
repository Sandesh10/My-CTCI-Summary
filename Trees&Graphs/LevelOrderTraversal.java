import java.util.*;
// import MinimalTree;

// class Node{
// 	int data;
// 	Node left;
// 	Node right;

// 	Node(int val){
// 		this.data = val;
// 		this.left = null;
// 		this.right = null;
// 	}
// }

public class LevelOrderTraversal{
	public ArrayList<ArrayList<Integer>> getLevel(Node root){
		if(root==null){
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		// result.add(queue);
		ArrayList<Integer> temp;
		// Node n;
		LinkedList<Node> q;
		while (queue.size()>0){
			System.out.println(queue.size());
			temp = new ArrayList<Integer>();
			q = new LinkedList<Node>();
			for(Node n:queue){
				temp.add(n.data);
				if (n.left!=null){
					q.add(n.left);
				}
				if (n.right!=null){
					q.add(n.right);
				}
			}
			result.add(temp);
			queue = q;
		}
		return result;
	}

	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		MinimalTree obj = new MinimalTree();
		Node r = obj.createMinimalBST(arr);
		ArrayList<ArrayList<Integer>> res = new LevelOrderTraversal().getLevel(r);
		
		for (ArrayList<Integer> re:res){
			for(int i:re){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}				
}