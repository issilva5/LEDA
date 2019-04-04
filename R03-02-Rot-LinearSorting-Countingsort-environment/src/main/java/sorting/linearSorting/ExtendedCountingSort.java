package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (verificaLimites(array, leftIndex, rightIndex)) {

			int greatest = findGreatest(array, leftIndex, rightIndex);
			int smallest = findSmallest(array, leftIndex, rightIndex);
			int length = greatest - smallest + 1;

			int[] count = new int[length];
			Integer[] helper = new Integer[array.length];

			accumulateFrequence(array, count, leftIndex, rightIndex, smallest);

			for (int i = rightIndex; i >= leftIndex; i--) {

				helper[leftIndex + count[array[i] - smallest] - 1] = array[i];
				count[array[i] - smallest]--;

			}

			for (int i = leftIndex; i <= rightIndex; i++) {

				array[i] = helper[i];

			}

		}

	}

	private void accumulateFrequence(Integer[] array, int[] count, int leftIndex, int rightIndex, int smallest) {

		for (int i = leftIndex; i <= rightIndex; i++) {

			count[array[i] - smallest]++;

		}

		for (int i = 1; i < count.length; i++) {

			count[i] += count[i-1];

		}

	}

	private int findGreatest(Integer[] array, int leftIndex, int rightIndex) {

		int greatest = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {

			greatest = Math.max(greatest, array[i]);

		}

		return greatest;

	}

	private int findSmallest(Integer[] array, int leftIndex, int rightIndex) {

		int smallest = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {

			smallest = Math.min(smallest, array[i]);

		}

		return smallest;

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
