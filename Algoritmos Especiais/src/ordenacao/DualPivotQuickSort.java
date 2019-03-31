package ordenacao;

import java.util.Arrays;

/*
 * The idea of dual pivot quick sort is to take two pivots,
 * one in the left end of the array and the second, in the right end of the array.
 * 
 * The left pivot must be less than or equal to the right pivot, so we swap them if necessary.
 * 
 * Then, we begin partitioning the array into three parts:
 * in the first part, all elements will be less than the left pivot,
 * in the second part all elements will be greater or equal to the left pivot and also will be less than or equal to the right pivot,
 * and in the third part all elements will be greater than the right pivot.
 * 
 * Then, we shift the two pivots to their appropriate positions as we see in the below bar, 
 * and after that we begin quicksorting these three parts recursively, using this method.
 */
public class DualPivotQuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
	
	@Override
	public void sort(T[] array) {
		
		sort(array, 0, array.length - 1);
		
	}
	
	private void sort(T[] array, int left, int right) {
		
		if(left < right) {
			
			//TODO
			
		}
		
	}
	
	public static void main(String[] args) {
		SortingAlgorithm<Integer> i = new DualPivotQuickSort<>();
		Integer[] array = new Integer[]{-15, 11, -17, 34, 2, -1, 3, 9, 0, 17, -32};
		i.sort(array);
		System.out.println(Arrays.toString(array));
	}

	
}
