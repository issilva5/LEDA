package ordenacao;

public interface SortingAlgorithm<T extends Comparable<T>> {

	public void sort(T[] array);
	
}
