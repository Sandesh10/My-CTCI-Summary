import java.util.*;

public class MyStack<T> {
	public static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data){
			this.data = data;
		}
	}

	private StackNode<T> top;

	public T pop(){
		if (top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item){
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}

	public T peek(){
		if (top==null) return null;
		return top.data;
	}

	public boolean isEmpty(){
		return top==null;
	}
}