package ordenacao;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		boolean estaOrdenado = false;
		
		while(!estaOrdenado) {
			
			estaOrdenado = true;
			
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					T aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
					estaOrdenado = false;
				}
			}
			
		}
		
	}
	
	public void sortRecursive(T[] array) {
		
		sortRecursive(array, array.length);
		
	}
	
	private void sortRecursive(T[] array, int length) {
		
		if(length > 1) {
			
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					T aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
				}
			}
			
			sortRecursive(array, length - 1);
		}
		
	}

	public static void main(String[] args) {
		BubbleSort<String> i = new BubbleSort<>();
		String[] array = new String[]{};
		i.sortRecursive(array);
		System.out.println(Arrays.toString(array));
	}

}
