package collection.search;

import java.util.HashMap;

import node.SearchNode;
import collection.PriorityQueue.PriorityQueue;

public abstract class SearchOverlord {

	public void run() {
		PriorityQueue<SearchNode> queue;
	}

	public abstract PriorityQueue setQueue();

	public abstract HashMap<String, SearchNode> setAdjentcyList(
			PriorityQueue queue);

}
