/*
3.4 Queue via Stacks: 
Implement a MyQueue class which implements 
a queue using two stacks.
*/

import java.util.*;

class QueueviaStacks<T>{
	Stack<T> stack1, stack2;

	public QueueviaStacks(){
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();
	}

	// add
	public static void enqueue(int i){
		stack1.push(i);
	}

	// shift stacks from stack1 to stack2
	public static void stabilize(){
		if (stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
	}
	// remove
	public static T dequeue(){
		stabilize();
		return stack2.pop();
	}

	// peek
	public static T peek(){
		stabilize();
		return stack2.peek();
	}

	//size
	public static int size(){
		return stack1.size()+ stack2.size();
	}
}