package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (this.verificaLimites(array, leftIndex, rightIndex)) {
		
			boolean estaOrdenado = false;
	
			while (!estaOrdenado) {
	
				estaOrdenado = true;
	
				for (int i = leftIndex; i < rightIndex; i++) {
					if (array[i].compareTo(array[i+1]) > 0) {
						Util.swap(array, i, i+1);
						estaOrdenado = false;
					}
				}
	
				rightIndex--;
	
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
