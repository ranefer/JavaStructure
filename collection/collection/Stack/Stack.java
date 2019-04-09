/**
 * 
 */
package collection.Stack;

import node.SinglyLinkedNode;

/**
 * <pre>
 * @author Nate
 * 
 * @convention
 * 
 * @correspondence
 * </pre>
 */
public class Stack<T> {
	SinglyLinkedNode<T> top;

	public Stack() {
		top = new SinglyLinkedNode<T>();
	}

	/**
	 * 
	 * <pre>
	 * @param x
	 * 	the new top of {@code this}
	 * @requires
	 * @updates
	 * 	{@code this}
	 * @ensures {@code {this = x + this}}
	 * 
	 * </pre>
	 */
	public void push(T x) {
		SinglyLinkedNode<T> newTop = new SinglyLinkedNode<T>(x);
		newTop.next = this.top;
		this.top = newTop;
	}

	/**
	 * <pre>
	 * 
	 * @param top
	 * 		the top of the stack
	 * @requires
	 * 		{@code !this.isEmpty}
	 * 
	 * @ensures {@code this = {this - top}}
	 * 
	 * @return
	 * 		{@code top}
	 * </pre>
	 */
	public T pop() {
		T result = this.top.data;
		this.top = this.top.next;
		return result;
	}

	/**
	 * <pre>
	 * @return
	 *  
	 *  @requires
	 *  		{@code !this.isEmpty}
	 * </pre>
	 */
	public T peek() {
		return this.top.data;
	}

	@Override
	public String toString() {
		SinglyLinkedNode<T> next = this.top;

		String result = "{" + next.toString();
		while (next != null) {
			result += "," + next.toString();
			next = next.next;
		}
		result += "}";

		return result;
	}

	/**
	 * <pre>
	 * @param top
	 * 		the top of the {@code this}
	 * @return
	 * 	true if {@code top} == null;
	 * 	false otherwise
	 * </pre>
	 */
	public boolean isEmpty() {
		return this.top != null;
	}

}
