package collection.search;

public abstract class Searchable<T> {
	public String name;
	
	/**
	 * <pre>
	 * f: g + h
	 * g: cost from start
	 * h: heuristic, estimated cost to goal
	 * </pre>
	 */

	double f = 0;
	double g = 0;
	double h = 0;
	
}
