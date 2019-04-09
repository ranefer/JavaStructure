package map;



public interface Map<K,V>  { 
	
	public class Pair<K, V> {
		K key;
		V value;
		
		Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public void put(Map.Pair<K,V> p);
	public void put(K key, V value);
	public V value(K key);
	public K key(V value);
	public Map<K,V> getAll();
	public Map<K,V> removeAll();
	//newInstance
	
}
