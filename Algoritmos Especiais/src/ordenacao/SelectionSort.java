package ordenacao;

import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		for(int i = 0; i < array.length; i++) {
		
			int menorIndex = i;
			
			for(int j = i+1; j < array.length; j++) {
				if(array[j].compareTo(array[menorIndex]) < 0) menorIndex = j;
			}
			
			T aux = array[i];
			array[i] = array[menorIndex];
			array[menorIndex] = aux;
		}
		
	}
	
	public void sortRecursive(T[] array) {
		
		sortRecursive(array, 0);
		
	}
	
	private void sortRecursive(T[] array, int i) {
		
		if(i < array.length) {
		
			int menorIndex = i;
			
			for(int j = i+1; j < array.length; j++)
				if(array[j].compareTo(array[menorIndex]) < 0) menorIndex = j;
			
			T aux = array[i];
			array[i] = array[menorIndex];
			array[menorIndex] = aux;
			
			sortRecursive(array, i+1);
			
		}
		
	}

	public static void main(String[] args) {
		SelectionSort<String> i = new SelectionSort<>();
		String[] array = new String[]{"pedro", "debora", "ana", "anana", "campos"};
		i.sortRecursive(array);
		System.out.println(Arrays.toString(array));
	}

}
