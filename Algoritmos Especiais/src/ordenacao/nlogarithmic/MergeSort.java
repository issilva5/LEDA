package ordenacao.nlogarithmic;

import ordenacao.quadratic.SortingAlgorithm;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length - 1);
	}
	
	private void sort(T[] array, int left, int right) {
		
		if(left < right) {
			
			int mid = (left + right)/2;
			sort(array, left, mid);
			sort(array, mid+1, right);
			
			merge(array, left, right);
			
		}
		
	}

	@SuppressWarnings("unchecked")
	private void merge(T[] array, int left, int right) {
		
		int mid = (left + right)/2;
		T[] helper = (T[]) new Comparable[array.length];
		
		int i = left;
		int j = mid + 1;
		int k = left;
		
		while(i <= mid && j <= right) {
			if(array[i].compareTo(array[j]) < 0) {
				helper[k] = array[i];
				i++;
			} else {
				helper[k] = array[j];
				j++;
			}
			
			k++;
		}
		
		while(i <= mid) {
			helper[k] = array[i];
			i++;
			k++;
		}
		
		while(j <= right) {
			helper[k] = array[j];
			j++;
			k++;
		}
		
		for(i = left; i <= right; i++) {
			array[i] = (T) helper[i];
		}
	}

}
