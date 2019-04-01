package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {

      if (verificaLimites(array, leftIndex, rightIndex)) {

         if (leftIndex < rightIndex) {

            int midIndex = (leftIndex + rightIndex) / 2;
            sort(array, leftIndex, midIndex);
            sort(array, midIndex + 1, rightIndex);

            merge(array, leftIndex, rightIndex);

         }

      }

   }

   private void merge(T[] array, int leftIndex, int rightIndex) {

      int midIndex = (leftIndex + rightIndex) / 2;
      T[] helper = (T[]) new Comparable[array.length];

      for (int i = leftIndex; i <= rightIndex; i++) {
         helper[i] = array[i];
      }

      int firstIterator = leftIndex;
      int secondIterator = midIndex + 1;
      int arrayIterator = leftIndex;

      while (firstIterator <= midIndex && secondIterator <= rightIndex) {

         if (helper[firstIterator].compareTo(helper[secondIterator]) < 0) {

            array[arrayIterator] = helper[firstIterator];
            firstIterator++;

         } else {

            array[arrayIterator] = helper[secondIterator];
            secondIterator++;

         }

         arrayIterator++;

      }

      while (firstIterator <= midIndex) {

         array[arrayIterator] = helper[firstIterator];
         firstIterator++;
         arrayIterator++;

      }

      while (secondIterator <= rightIndex) {

         array[arrayIterator] = helper[secondIterator];
         secondIterator++;
         arrayIterator++;

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
