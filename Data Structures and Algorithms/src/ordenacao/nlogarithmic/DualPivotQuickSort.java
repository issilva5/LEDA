package ordenacao.nlogarithmic;

import ordenacao.quadratic.SortingAlgorithm;

public class DualPivotQuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
	
	@Override
	public void sort(T[] array) {
		
		sort(array, 0, array.length - 1);
		
	}
	
	private void sort(T[] array, int left, int right) {
		
		if(left < right) {
			
			int pivotLeft = left;
			int pivotRight = right;
			if(array[left].compareTo(array[right]) > 0) {
				T aux = array[left];
				array[left] = array[right];
				array[right] = aux;
			}
			
			int pivotBegin = left;
			
			for(int j = pivotBegin + 1; j <= right; j++) {
				if(array[j].compareTo(array[pivotLeft]) < 0) {
					pivotBegin++;
					T aux = array[pivotBegin];
					array[pivotBegin] = array[j];
					array[j] = aux;
				}
			}
			
			if(pivotLeft != pivotBegin) {
				T aux = array[pivotLeft];
				array[pivotLeft] = array[pivotBegin];
				array[pivotBegin] = aux;
			}
			
			//Determinando pivotEnd
			int pivotEnd = right;
			
			for(int j = pivotEnd - 1; j > pivotBegin; j--) {
				if(array[j].compareTo(array[pivotRight]) > 0) {
					pivotEnd--;
					T aux = array[pivotEnd];
					array[pivotEnd] = array[j];
					array[j] = aux;
				}
			}
			
			if(pivotRight != pivotEnd) {
				T aux = array[pivotRight];
				array[pivotRight] = array[pivotEnd];
				array[pivotEnd] = aux;
			}
			
			sort(array, left, pivotBegin - 1);
			sort(array, pivotBegin + 1, pivotEnd - 1);
			sort(array, pivotEnd + 1, right);
			
		}
		
	}

	/*
	for(int j = pivotBegin + 1; j <= right; j++) {
		if(array[j].compareTo(array[pivotLeft]) < 0) {
			pivotBegin++;
			T aux = array[pivotBegin];
			array[pivotBegin] = array[j];
			array[j] = aux;
		}
	}
	
	if(pivotLeft != pivotBegin) {
		T aux = array[pivotLeft];
		array[pivotLeft] = array[pivotBegin];
		array[pivotBegin] = aux;
	}
	
	//Determinando pivotEnd
	//int pivotEnd = right;
	
	for(int j = pivotEnd - 1; j > pivotBegin; j--) {
		if(array[j].compareTo(array[pivotRight]) > 0) {
			pivotEnd--;
			T aux = array[pivotEnd];
			array[pivotEnd] = array[j];
			array[j] = aux;
		}
	}
	
	if(pivotRight != pivotEnd) {
		T aux = array[pivotRight];
		array[pivotRight] = array[pivotEnd];
		array[pivotEnd] = aux;
	}
	*/
	
}
