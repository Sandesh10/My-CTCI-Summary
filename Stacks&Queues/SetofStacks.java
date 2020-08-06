import java.util.*;

class SetofStacks{
	ArrayList<MyStack> stacks = new ArrayList<MyStack>();
	public int capacity;

	public SetofStacks(int capacity){
		this.capacity = capacity;
	}

	public MyStack getLastStack(){
		if(stacks.size()==0) return null;
		return stacks.get(stacks.size()-1);
	}

	public void push(int v){
		MyStack last = getLastStack();
		if (last!=null && !last.isFull()){
			last.push(v);
		}else{
			MyStack stack = new MyStack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop(){
		MyStack last = getLastStack();
		if (last==null) throw new EmptyStackException();
		int v =last.pop();
		if (last.size ==0) stacks.remove(stacks.size()-1);	
		return v;
	}

	public boolean isEmpty(){
		MyStack last = getLastStack();
		return last==null || last.isEmpty();
	}

	public int popAt(int index){
		return leftShift(index,true);
	}

	public int leftShift(int index,boolean removeTop){
		MyStack stack = stack.get(index);
		int removed_item;
		if (removeTop) removed_item = stack.pop();
		else{
			removed_item = stack.removeBottom();
		}
		if (stack.isEmpty()){
			stacks.remove(index);
		}else if (stacks.size() > index+1){
			int v = leftShift(index+1,false);
			stack.push(v); 
		}
		return removed_item;
	}

}