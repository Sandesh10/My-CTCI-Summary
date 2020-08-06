import java.util.LinkedList;

class Graph{
	public int v;
	public LinkedList<Integer> adj[]; 

	public Graph(int v){
		this.v = v;
		adj= new LinkedList[v];
		for (int i=0;i<v;i++){
			adj[i] = new LinkedList();
		}
	}

	public boolean isConnected()

}

class RouteBetweenNodes{
	enum State {Unvisited,Visited,Visiting;}

	public isConnected(Graph g,Node start, Node end){
		if(start==end) return true;

		LinkedList<Node> q = new LinkedList<Node>();

		for (Node u: g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;

		while(!q.isEmpty()){
			u = q.removeFirst();
			if(u!=null){
				for(Node v: u.getAdjacent()) {
					if (v.state == State.Unvisited){
						if (v == end){
							return true;
						}else{
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
	// function ends
}