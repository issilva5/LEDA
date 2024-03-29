package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends AbstractSorting<T> {

   public void sort(T[] array, int leftIndex, int rightIndex) {
	  
	   if (this.verificaLimites(array, leftIndex, rightIndex)) {
	      
		  while (leftIndex < rightIndex) {
	
	         int indiceMaior = leftIndex;
	         for (int i = leftIndex + 1; i <= rightIndex; i++) {
	            if (array[i].compareTo(array[indiceMaior]) > 0) {
	               indiceMaior = i;
	            }
	         }
	
	         Util.swap(array, rightIndex, indiceMaior);
	         rightIndex--;
	
	         int indiceMenor = rightIndex;
	         for (int i = rightIndex - 1; i >= leftIndex; i--) {
	            if (array[i].compareTo(array[indiceMenor]) < 0) {
	               indiceMenor = i;
	            }
	         }
	
	         Util.swap(array, leftIndex, indiceMenor);
	         leftIndex++;
	
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
