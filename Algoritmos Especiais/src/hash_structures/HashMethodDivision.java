package hash_structures;

public class HashMethodDivision<K> implements HashMethod<K> {

	public int hash(K element, int mod) {
		
		return element.hashCode() % mod;
		
	}

}
