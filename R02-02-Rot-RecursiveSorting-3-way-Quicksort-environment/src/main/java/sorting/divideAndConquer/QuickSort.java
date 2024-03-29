package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (verificaLimites(array, leftIndex, rightIndex)) {

			if (leftIndex < rightIndex) {
				
				int pivot = partition(array, leftIndex, rightIndex);
				sort(array, leftIndex, pivot - 1);
				sort(array, pivot + 1, rightIndex);

			}

		}

	}

	private int partition(T[] array, int leftIndex, int rightIndex) {

		int pivotIndex = leftIndex;
		int pivotIterator = leftIndex;

		for(int i = leftIndex + 1; i <= rightIndex; i++) {

			if (array[i].compareTo(array[pivotIndex]) < 0) {

				pivotIterator++;
				Util.swap(array, pivotIterator, i);

			}

		}

		Util.swap(array, pivotIndex, pivotIterator);
		pivotIndex = pivotIterator;

		return pivotIndex;

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
