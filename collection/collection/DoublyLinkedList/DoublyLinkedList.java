package collection.DoublyLinkedList;

import java.util.Comparator;
import java.util.Iterator;

import collection.Collection;
import collection.list.List;
import node.DoublyLinkedNode;

public class DoublyLinkedList<T extends Comparable<T>> implements List<T>, Iterable<T> {

	private DoublyLinkedNode<T> preHead;
	private DoublyLinkedNode<T> postTail;
	private DoublyLinkedNode<T> pointer;
	private int length;

	public DoublyLinkedList() {
		this.createNewRep();
	}

	private void createNewRep() {
		this.preHead = new DoublyLinkedNode<T>();
		this.postTail = new DoublyLinkedNode<T>();
		this.pointer = preHead;

		this.preHead.next = this.postTail;
		this.postTail.previous = this.preHead;
		this.pointer = this.preHead;
		this.length = 0;
	}

	/**
	 * 
	 * 
	 * @param data
	 * @returns {@code true} if {@code data} is in {@code this}
	 */
	private boolean moveTo(T data) {
		assert this.length > 0 : "This must not be empty";
		this.pointer = this.preHead.next;
		while (this.pointer != postTail && this.pointer.retrieveData().compareTo(data) != 0) {
			this.pointer = this.pointer.next;
		}
		return this.pointer != postTail;
	}

	@Override
	public void add(T data) {
		DoublyLinkedNode<T> next = new DoublyLinkedNode<T>(data);
		next.next = this.pointer.next;
		next.previous = next.next.previous;
		next.next.previous = next;
		next.previous.next = next;
		this.pointer = next;
		this.length++;
	}

	@Override
	public boolean remove(T data) {
		boolean result = false;
		if (this.length > 0 && (result = this.moveTo(data))) {
			this.pointer.next.previous = this.pointer.previous;
			this.pointer.previous.next = this.pointer.next;
			this.pointer.next = null;
			this.pointer.previous = null;
			this.length--;
			this.pointer = this.pointer.next;
		}
		return result;
	}

	public T remove() {
		T result = null;
		if (this.length > 0 && this.pointer != this.preHead && this.pointer != this.postTail) {
			result = this.pointer.retrieveData();
			this.pointer.next.previous = this.pointer.previous;
			this.pointer.previous.next = this.pointer.next;
			this.pointer.next = null;
			this.pointer.previous = null;
			this.length--;
		}
		return result;
	}

	@Override
	public T removeFirst() {
		assert this.length > 0 : "Requires this.length > 0";
		DoublyLinkedNode<T> removed = this.preHead.next;
		this.preHead.next = removed.next;
		this.preHead.next.previous = this.preHead;

		removed.next = null;
		removed.previous = null;
		this.length--;

		return removed.retrieveData();
	}

	@Override
	public boolean contains(T data) {
		DoublyLinkedNode<T> front = this.preHead.next;
		while (front != this.postTail && front.retrieveData().compareTo(data) != 0) {
			front = front.next;
		}
		return front != this.postTail;
	}

	@Override
	public Collection<T> copy() {
		// TODO Auto-generated method stub
		Collection<T> all = new DoublyLinkedList<T>();
		for (T x : this) {
			all.add(x);
		}
		return all;
	}

	@Override
	public Collection<T> removeAll() {

		Collection<T> c = new DoublyLinkedList<T>();
		for (T x : this) {
			c.add(x);
		}
		this.preHead.next.previous = null;
		this.preHead.next = this.postTail;
		this.postTail.previous.next = null;
		this.postTail.previous = this.preHead;
		this.length = 0;
		return c;
	}

	@Override
	public int compareTo(Collection<T> o) {
		int retVal = 0;
		if ((retVal = this.length() - ((DoublyLinkedList<T>) o).length()) != 0) {
			DoublyLinkedList<T> t = (DoublyLinkedList<T>) this.copy();
			DoublyLinkedList<T> oo = (DoublyLinkedList<T>) o.copy();
			while (t.length() > 0) {
				DoublyLinkedNode<T> ttemp = new DoublyLinkedNode<T>(t.removeFirst());
				DoublyLinkedNode<T> otemp = new DoublyLinkedNode<T>(t.removeFirst());

				if ((retVal = ttemp.compareTo(otemp)) != 0) {
					return retVal;
				}
			}
		}
		// equal

		return 0;
	}

	@Override
	public void Sort(Comparator<T> c) {

	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public String toString() {
		String rep = "(";
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			rep += it.next().toString();
			if (it.hasNext()) {
				rep += ",";
			}
		}
		rep += ")";
		return rep;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator_dll();
	}

	public class Iterator_dll implements Iterator<T> {
		DoublyLinkedNode<T> p;

		public Iterator_dll() {
			p = preHead;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return p.next != null && p.next != preHead && p.next != postTail;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			p = p.next;
			return p.retrieveData();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			DoublyLinkedNode<T> removed = p;
			p = p.next;
			removed.next.previous = removed.previous;
			removed.previous.next = removed.next;
			removed.next = null;
			removed.previous = null;
			length--;

		}

	}

}
