class Successor{
	public Node inOrderSucc(Node n){
		if( n==null) return null;

		if (n.right!=null){
			return leftMostChild(n.right);
		}
		else{
			Node temp = n;
			Node p = temp.parent;
			while(temp!=null && p.left!=temp){
				temp = p;
				p = p.parent;
			}
			return p;
		}
	}

	Node leftMostChild(Node n){
		if(n==null) return null;
		while (n.left!=null){
			n = n.left;
		}
		return n;
	}
}