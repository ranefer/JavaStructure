package search;

import java.util.HashMap;
import java.util.ArrayList;

public class AdjencyList {

	HashMap<Searchable<?>, ArrayList<Searchable<?>>> adjencyList;
	
	public void add(Searchable<?> node, ArrayList<Searchable<?>> adjecent) {
		adjencyList.put(node, adjecent);
	}
	
	public ArrayList<Searchable<?>> getAdjencyList(Searchable<?> node) {
		return adjencyList.get(node);
	}
}
