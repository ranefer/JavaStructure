package collection.list;

import java.util.Comparator;

import collection.set.Set;

public interface List<T extends Comparable<T>> extends Set<T> {

	public void Sort(Comparator<T> c);
}
