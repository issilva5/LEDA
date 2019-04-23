package hash_structures;
@SuppressWarnings("unchecked")
public class HashTable<K, V> {
	
	private Pair<K,V> table[];
	private HashMethod<K> hashMethod;
	private int capacity;
	
	public HashTable() {
		this(23);
	}
	
	public HashTable(int capacity) {
		this.capacity = capacity;
		this.table = (Pair<K, V>[]) new Object[this.capacity];
		this.hashMethod = new HashMethodDivision<>();
	}
	
	public void put(K key, V value) {
		
		int hash = this.hashMethod.hash(key, this.capacity);
		this.table[hash] = new Pair<K, V>(key, value);
		
	}
	
	public boolean contains(K key) {
		
		int hash = this.hashMethod.hash(key, this.capacity);
		
		return this.table[hash] != null;
		
	}
	
	public V remove(K key) {
		
		int hash = this.hashMethod.hash(key, this.capacity);
		
		V value = this.table[hash].getValue();
		
		this.table[hash] = null;
		
		return value;
		
	}
	
}

class Pair<K, V> {
	
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}



