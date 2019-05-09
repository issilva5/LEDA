package hash_structures;

public interface HashMethod<K> {
	
	public int hash(K element, int mod);
	
}
