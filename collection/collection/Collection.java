
package collection;

public interface Collection<T> extends Comparable<Collection<T>> {

	public void add(T data);

	public boolean remove(T data);

	public T removeFirst();

	public boolean contains(T data);

	public Collection<T> getAll();

	public Collection<T> removeAll();

	// newInstance();

	public int length();

}
