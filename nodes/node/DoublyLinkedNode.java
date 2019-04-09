package node;

public class DoublyLinkedNode<T extends Comparable<T>> implements
		Comparable<DoublyLinkedNode<T>> {
	T data;
	public DoublyLinkedNode<T> next;
	public DoublyLinkedNode<T> previous;

	public DoublyLinkedNode() {
	};

	public DoublyLinkedNode(T data) {
		this.data = data;
	}

	public T retrieveData() {
		return this.data;
	}

	@Override
	public int compareTo(DoublyLinkedNode<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
