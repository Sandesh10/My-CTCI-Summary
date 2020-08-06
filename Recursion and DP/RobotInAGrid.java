/*
8.2 Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.

*/

import java.util.*;

class Point {
	int row, col;
	Point(int r, int c){
		row = r;
		col = c;
	}
}

// Brute Force
class RobotInAGrid {
	static ArrayList<Point> getPath(boolean[][] maze){
		if (maze == null || maze.length == 0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		if (getPath(maze, maze.length-1, maze[0].length-1, path)){
			return path;
		}
		return null;
	}

	static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path){
		if (col < 0 || row < 0 || !maze[row][col]){
			return false;
		}
		boolean isAtOrigin = (row == 0) && (col == 0);
		if (isAtOrigin || getPath(maze, row, col-1, path) ||
			getPath(maze, row-1,col, path)) {
			Point p = new Point(row, col);
		path.add(p);
		return true;
		}
		return false;
	}

	public static void main(String[] main){
		boolean [][] maze = new boolean[][] {{true, true, true, true, true},
											   {true, true, false, false, true},
											   {false, true, false, false, true},
											   {true, true, false, false, true},
											   {true, true, true, true, true}};
		ArrayList<Point> res = getPath(maze);
		for (Point p: res){
			System.out.println(p.row +" "+p.col);	
		}
		
	}	
}
/*
Runtime: O(2^(r+c)) since each path has r+c steps and there are two choices we 
					can make at each step. 
*/


// DYNAMIC PROGRAMMING
// RUNTIME: O(Row * Col) 
ArrayList<Point> getPath(boolean[][] maze){
	if (maze == null || maze.length==0) return null;
	ArrayList<Point> path = new ArrayList<Point>();
	HashSet<Point> failedPoints = new HashSet<Point>();
	if (getPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)){
		return path;
	}
	return null;
}


boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
	if (col<0 || row <0 || !maze[row][col]){
		return false;
	}
	Point p = new Point(row, col);

	if (failedPoints.contains(p)){
		return false;
	}

	boolean isOrigin = (row==0) && (col==0);

	if (isOrigin || getPath(maze, row-1, col,path,failedPoints)
		|| getPath(maze, row, col-1,path,failedPoints)){
		path.add(p);
		return true;
	}
	failedPoints.add(p); 
	return false;
}