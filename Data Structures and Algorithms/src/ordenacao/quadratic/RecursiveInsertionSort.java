package ordenacao.quadratic;

public class RecursiveInsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override	
	public void sort(T[] array) {
		
		sort(array, 1);
		
	}
	
	private void sort(T[] array, int i) {
		
		if(i < array.length) {
		
			int j = i;
			while(j > 0 && array[j].compareTo(array[j-1]) < 0) {
				T aux = (T) array[j];
				array[j] = array[j-1];
				array[j-1] = aux;
				
				j--;
			}
			
			sort(array, i+1);
			
		}
		
	}

}
