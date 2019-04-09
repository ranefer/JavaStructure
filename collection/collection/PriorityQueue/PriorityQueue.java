
package collection.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class PriorityQueue<T> implements Queue<T> {
	
	List<T> data;
	Comparator<T> priority;
	boolean listIncreased;
	

	public PriorityQueue(Comparator<T> priority) {
		this.priority = priority;
		data = new ArrayList<T>();
	}

	@Override
	public void enqueue(T x) {
		data.add(x);
		listIncreased = true;
	}

	@Override
	public T dequeue() {
		prioritize();
        return data.remove(0);
	}

	@Override
	public T peek() throws IndexOutOfBoundsException {
		prioritize();
        return data.remove(0);
	}
	
	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	private void prioritize() {
        if(listIncreased) {
            Collections.sort(data, priority);
            listIncreased = false;
		}
	}
}
