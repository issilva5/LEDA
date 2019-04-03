package ordenacao.quadratic;

public class RecursiveBubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		sort(array, array.length);
		
	}
	
	private void sort(T[] array, int length) {
		
		if(length > 1) {
			
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					T aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
				}
			}
			
			sort(array, length - 1);
		}
		
	}

}
