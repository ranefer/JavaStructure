package collection.PriorityQueue;

public interface Queue<T> {
	public void enqueue(T x);
	public T dequeue();
	public T peek();
	public boolean isEmpty();
}
