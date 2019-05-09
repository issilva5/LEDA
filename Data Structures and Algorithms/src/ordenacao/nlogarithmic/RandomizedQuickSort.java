package ordenacao.nlogarithmic;

import java.util.Random;

import ordenacao.quadratic.SortingAlgorithm;

public class RandomizedQuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

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
	
	private int choosePivot(int left, int right) {
		Random rand = new Random();
		return rand.nextInt(right - left + 1) + left;
	}
	
	private int lomutoPartition(T[] array, int left, int right) {
		
		int pivot = choosePivot(left, right);
		
		T aux = array[pivot];
		array[pivot] = array[left];
		array[left] = aux;
		pivot = left;
		
		int i = left;
		
		for(int j = i + 1; j <= right; j++) {
			if(array[j].compareTo(array[pivot]) < 0) {
				i++;
				aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		
		if(pivot != i) {
			aux = array[pivot];
			array[pivot] = array[i];
			array[i] = aux;
			pivot = i;
		}
		
		return pivot;
		
	}

}
