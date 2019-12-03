package test;

public class Stack<T>{
	private NodeStack<T> last;
	
	public void push(T node) {
		NodeStack newNode = new NodeStack(node,last);
		last = newNode;
	}
	
	public T pop() {
		NodeStack<T> aux = last;
		last = last.getPrev();
		return aux.getValue();
	}
	
	public boolean isEmpty() {
		return (last == null);
	}
}
