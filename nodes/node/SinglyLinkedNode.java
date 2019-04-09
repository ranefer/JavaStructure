package node;

public class SinglyLinkedNode<T> implements Node<T> {
	public T data;
	public SinglyLinkedNode<T> next;

	public SinglyLinkedNode(T data) {
		this.data = data;
	}

	public SinglyLinkedNode() {
		this.data = null;
	}

	@Override
	public String toString() {
		String result = null;
		result = data == null ? "null" : data.toString();
		return result;
	}
}
