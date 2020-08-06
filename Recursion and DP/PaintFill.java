/*
8.10 Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
fill in the surrounding area until the color changes from the original color.
*/
import java.util.*;
class Node {
	int r;
	int c;
	Node(int r, int c){
		this.r = r;
		this.c = c;
	}
}
class PaintFill {
	enum Color {Black, White, Red, Yellow, Green}
	boolean PaintFill(Color[][] screen, int r, int c, Color ncolor){
		if (screen[r][c]== ncolor) return false;
		return PaintHelper(screen,r,c, screen[r][c], ncolor);
	}

	// Depth First Search Approach
	boolean PaintHelper(Color[][] screen,
		int r, int c, Color curColor, Color newColor){
		if (r<0 || c <0 || r >= screen.length || c>=screen[0].length){
			return false;
		}
		if (screen[r][c]==curColor){
			screen[r][c] = newColor;
			PaintHelper(screen,r-1,c,curColor, newColor);
			PaintHelper(screen,r+1,c,curColor, newColor);
			PaintHelper(screen,r,c-1,curColor, newColor);
			PaintHelper(screen,r,c+1,curColor, newColor);
		}
		return true;
	}

	// Breadth First Search Approach
	boolean PaintHelperBFS(Color[][] screen,
		int r, int c, Color curColor, Color newColor){
		if (r<0 || c <0 || r >= screen.length || c>=screen[0].length){
			return false;
		}
		Node cur = new Node(r,c);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(cur);
		while (!queue.isEmpty()){
			Queue<Node> newQueue = new LinkedList<Node>();
			for (int i=0;i<queue.size();i++){
				Node temp = queue.remove();
				if (screen[temp.r][temp.c]==curColor){
					screen[temp.r][temp.c] = newColor;
					newQueue.add(new Node(temp.r+1,temp.c));
					newQueue.add(new Node(temp.r-1,temp.c));
					newQueue.add(new Node(temp.r,temp.c+1));
					newQueue.add(new Node(temp.r,temp.c-1));
				}
			// 	if (temp.r<screen.length-1 && screen[temp.r+1][temp.c]==curColor){
			// 			newQueue.add(new Node(temp.r+1,temp.c));
			// 	}
			// 	if (temp.r>0 && screen[temp.r-1][temp.c]==curColor){
			// 			newQueue.add(new Node(temp.r-1,temp.c));
			// 	}
			// 	if (temp.c<screen[0].length-1 && screen[temp.r][temp.c+1]==curColor){
			// 			newQueue.add(new Node(temp.r,temp.c+1));
			// 	}
			// 	if (temp.c>0 && screen[temp.r][temp.c-1]==curColor){
			// 			newQueue.add(new Node(temp.r,temp.c-1));
			// 	}	
			}
			queue = newQueue;
		}
		return true;
	}

	public static void main(String[] args){
		Color [][] screen = new Color[][]{{Color.Black, Color.Red,Color.Red, Color.Red, Color.Red, Color.Yellow},
										{Color.Black, Color.Red, Color.Red, Color.Red, Color.Red, Color.Yellow},
										{Color.Black, Color.Red, Color.Red, Color.Red, Color.Yellow, Color.Yellow},
										{Color.Black, Color.Red, Color.Red, Color.Red, Color.Yellow, Color.Yellow},
										{Color.Black, Color.Red, Color.Red, Color.Red, Color.Yellow, Color.Yellow},
										{Color.Red, Color.Black, Color.Black, Color.Red, Color.Yellow, Color.Yellow}};
		for(int i=0;i<screen.length;i++){
			for(int j=0;j<screen[0].length;j++){
				System.out.print(screen[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
		new PaintFill().PaintFill(screen,2,3,Color.White);
		for(int i=0;i<screen.length;i++){
			for(int j=0;j<screen[0].length;j++){
				System.out.print(screen[i][j]+"  ");
			}
			System.out.println();
		}		
	}
}