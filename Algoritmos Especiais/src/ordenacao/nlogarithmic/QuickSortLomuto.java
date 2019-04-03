package ordenacao.nlogarithmic;

import ordenacao.quadratic.SortingAlgorithm;

public class QuickSortLomuto<T extends Comparable<T>> implements SortingAlgorithm<T> {
	
	@Override
	public void sort(T[] array) {
		
		sort(array, 0, array.length - 1);
		
	}
	
	private void sort(T[] array, int left, int right) {
		
		if(left < right) {
			
			int pivot = lomutoPartition(array, left, right);
			sort(array, left, pivot - 1);
			sort(array, pivot + 1, right);
			
		}
		
	}
	
	private int lomutoPartition(T[] array, int left, int right) {
		
		int pivot = left;
		int i = left;
		
		for(int j = i + 1; j <= right; j++) {
			if(array[j].compareTo(array[pivot]) < 0) {
				i++;
				T aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		
		if(pivot != i) {
			T aux = array[pivot];
			array[pivot] = array[i];
			array[i] = aux;
			pivot = i;
		}
		
		return pivot;
		
	}

}
