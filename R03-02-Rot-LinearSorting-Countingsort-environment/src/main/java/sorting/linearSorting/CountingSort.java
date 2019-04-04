package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {

      if (verificaLimites(array, leftIndex, rightIndex)) {

         int greatest = findGreatest(array, leftIndex, rightIndex);

         int[] count = new int[greatest];
         Integer[] helper = new Integer[array.length];

         accumulateFrequence(array, count, leftIndex, rightIndex);

         for (int i = rightIndex; i >= leftIndex; i--) {

            helper[leftIndex + count[array[i] - 1] - 1] = array[i];
            count[array[i] - 1]--;

         }

         for (int i = leftIndex; i <= rightIndex; i++) {

            array[i] = helper[i];

         }

      }

   }

   private void accumulateFrequence(Integer[] array, int[] count, int leftIndex, int rightIndex) {

      for (int i = leftIndex; i <= rightIndex; i++) {

         count[array[i] - 1]++;

      }

      for (int i = 1; i < count.length; i++) {

         count[i] += count[i - 1];

      }

   }

   private int findGreatest(Integer[] array, int leftIndex, int rightIndex) {

      int greatest = array[leftIndex];

      for (int i = leftIndex + 1; i <= rightIndex; i++) {

         greatest = Math.max(greatest, array[i]);

      }

      return greatest;

   }

   private boolean verificaLimites(Integer[] array, int leftIndex, int rightIndex) {

      boolean result = true;

      if (array == null) {
         result = false;
      } else if (leftIndex < 0 || leftIndex > rightIndex) {
         result = false;
      } else if (rightIndex >= array.length) {
         result = false;
      }

      return result;
   }

}
