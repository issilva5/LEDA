package ordenacao;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		for(int i = 1; i < array.length; i++) {
			int j = i;
			while(j > 0 && array[j].compareTo(array[j-1]) < 0) {
				T aux = (T) array[j];
				array[j] = array[j-1];
				array[j-1] = aux;
				
				j--;
			}
		}
		
	}
	
	public void sortRecursive(T[] array) {
		
		sortRecursive(array, 0);
		
	}
	
	private void sortRecursive(T[] array, int i) {
		
		if(i < array.length) {
		
			int j = i;
			while(j > 0 && array[j].compareTo(array[j-1]) < 0) {
				T aux = (T) array[j];
				array[j] = array[j-1];
				array[j-1] = aux;
				
				j--;
			}
			
			sortRecursive(array, i+1);
			
		}
		
	}

	public static void main(String[] args) {
		InsertionSort<String> i = new InsertionSort<>();
		String[] array = new String[]{"pedro", "debora", "ana", "anana", "campos"};
		i.sortRecursive(array);
		System.out.println(Arrays.toString(array));
	}

}
