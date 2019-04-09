/**
 * 
 */
package collection.Sequence;

import collection.Stack.Stack;

/**
 * <pre>
 * @author Nate
 * 
 * @convention
 * 
 * @correspondence
 * {@code}
 * 
 * 
 * </pre>
 */
public class Sequence<T> {

	Stack<T> first;
	Stack<T> second;
	int firstLength;
	int secondLength;

	public Sequence() {
		this.first = new Stack<T>();
		this.second = new Stack<T>();
		this.firstLength = 0;
		this.secondLength = 0;
	}

	/**
	 * <pre>
	 * Moves this.first s.t. this.fistLenght = index
	 * i.e. {@code this.add(T x, 0)} will add x to the front of {@code this}
	 * 
	 * @param index
	 * 	the position in {@code this} to move to
	 * 
	 * @require
	 * 	{@code pos} > 0
	 *  
	 *  @ensures
	 * 	{@code this.firstLenght} = {@code index}
	 * 
	 * </pre>
	 */
	private void moveTo(int index) {
		while (index < firstLength) {
			second.push(first.pop());
			firstLength--;
			secondLength++;
		}
		while (index > firstLength) {
			first.push(second.pop());
			firstLength++;
			secondLength--;
		}
	}

	/**
	 * 
	 * <pre>
	 * 
	 * @param x
	 * @param index
	 *  
	 *  @requires
	 *  	{@code 0 <= index < this.length()}
	 *  @updates
	 *  	{@code this}
	 * 
	 * </pre>
	 */
	public void add(T x, int index) {
		this.moveTo(index);
		this.first.push(x);
		this.firstLength++;
	}

	public void remove(T x) {
		moveTo(0);
		boolean removed = false;
		for (int i = 0; i < this.firstLength + this.secondLength && !removed; i++) {
			if (this.peek(i).equals(x)) {
				this.first.pop();
				removed = true;
			}
		}
	}

	public T peek(int index) {
		moveTo(index + 1);
		return this.first.peek();
	}

	/**
	 * 
	 * <pre>
	 * 
	 * @param x
	 *  
	 *  @requires
	 *  @updates
	 *  @restore
	 *  @clears
	 *  @ensures
	 *  
	 *  @returns
	 *  	true if {@code this.peek(i)} == x, i : [0, {@code this.length()}]
	 * 
	 * </pre>
	 */
	public boolean contains(T x) {
		boolean result = false;
		for (int i = 0; i < this.firstLength + this.secondLength; i++) {
			result = this.peek(i) == x;
		}
		return result;
	}

	public int length() {
		return this.firstLength + this.secondLength;
	}

	@Override
	public String toString() {
		String result = "(";
		for (int i = 1; i <= firstLength + secondLength; i++) {
			moveTo(i);
			result += first.peek();
			result += secondLength > 0 ? ", " : "";
		}
		result += ")";
		return result;
	}
}
