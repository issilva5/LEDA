package ordenacao.nlogarithmic;

import ordenacao.quadratic.SortingAlgorithm;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		sort(array, 0, array.length-1);
		
	}
	
	private void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			
			int[] pivotBounds = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotBounds[0] - 1);
			sort(array, pivotBounds[1] + 1, rightIndex);

		}

	}

	private int[] partition(T[] array, int leftIndex, int rightIndex) {
		
		int pivotBegin = leftIndex;
		int pivotEnd = rightIndex;
		int iterator = leftIndex;
		
		while (iterator <= pivotEnd) {
			
			if (array[iterator].compareTo(array[pivotBegin]) < 0) {
				Util.swap(array, iterator, pivotBegin);
				pivotBegin++;
				iterator++;
			} else if (array[iterator].compareTo(array[pivotBegin]) > 0) {
				Util.swap(array, iterator, pivotEnd);
				pivotEnd--;
			} else {
				iterator++;
			}
			
		}
		
		int[] pivotBounds = new int[] {pivotBegin, pivotEnd};
		
		return pivotBounds;

	}
	
}
