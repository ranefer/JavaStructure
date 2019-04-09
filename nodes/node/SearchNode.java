package node;

import collection.search.Searchable;

public class SearchNode<T> extends Searchable<T> implements Comparable<SearchNode> {
	SearchNode parent = null;

	SearchNode(SearchNode parent) {
		this.parent = parent;
	}

	@Override
	public int compareTo(SearchNode o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
