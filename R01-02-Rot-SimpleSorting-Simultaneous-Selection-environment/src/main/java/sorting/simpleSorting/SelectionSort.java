package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (this.verificaLimites(array, leftIndex, rightIndex)) {
		
			for (int i = leftIndex; i <= rightIndex; i++) {
	
				int indiceMenor = i;
				for (int j = i + 1; j <= rightIndex; j++) {
					if (array[j].compareTo(array[indiceMenor]) < 0) {
						indiceMenor = j;
					}
				}
	
				if (indiceMenor != i) {
					Util.swap(array, i, indiceMenor);
				}
	
			}
			
		}

	}
	
	private boolean verificaLimites(T[] array, int leftIndex, int rightIndex) {
		
		boolean result = true;
		
		if (array == null) {
			result = false;
		} else if (leftIndex < 0 || leftIndex > rightIndex) {
			result = false;
		} else if (rightIndex >= array.length || rightIndex < leftIndex) {
			result = false;
		}
		
		return result;
	}
}
