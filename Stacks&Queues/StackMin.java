/*
3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
*/

/*
Approach 1:

Maintain int value and minValue as the member of Stack class.
Each element has value and minValue field.

Disadvantage: requires more space as we keep track
			  of repeatitive minValue.

*/
public class StackMin extends MyStack<NodeWithMin>{
	public void push(int value){
		int newMin = Math.min(value,min());
		super.push(new NodeWithMin(value,newMin));
	}

	public int min(){
		if (this.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return peek().min;
		}
	}

	public void printStack(){
		while (this.peek()!=null){
			System.out.println(this.peek().value+" , "+ this.peek().min);
			this.pop();
		}
	} 
	public static void main(String[] args){
		StackMin stack = new StackMin();
		stack.push(10);
		// stack.printStack();
		stack.push(1);
		stack.push(11);
		stack.printStack();
	} 
	
}

class NodeWithMin {
	public int value;
	public int min;

	public NodeWithMin(int v, int min){
		value = v;
		this.min = min;
	}
}



/*
Approach 2:
Maintain a separate stack to put the minValue.
*/

public class StackMin2 extends MyStack<Integer>{
	Stack<Integer> minStack;

	public StackMin2(){
		minStack = new Stack<Integer>();
	}

	public void push(int value){
		if(value <= min()){
			minStack.push(value);			
		}
		super.push(value);
	}

	public Integer pop(){
		int value = super.pop();
		if (value==min()){
			minStack.pop();
		}
		return value;
	}

	public int min(){
		if (minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}
}