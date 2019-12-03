package test;

public class NodeStack<T> {
	private T value;
	private NodeStack prev;
	
	public NodeStack(T value,NodeStack prev) {
		this.value = value;
		this.prev = prev;
	}

	public NodeStack getPrev() {
		return prev;
	}
	
	public T getValue() {
		return value;
	}

}
