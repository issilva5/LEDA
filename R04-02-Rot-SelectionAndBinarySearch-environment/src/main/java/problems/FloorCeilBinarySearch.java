package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		int left = 0;
		int rigth = array.length;
		Integer floor = null;

		while (left < rigth) {

			int meio = (left + rigth)/2;

			if (array[meio].compareTo(x) == 0) {
				rigth = meio - 1;
				floor = array[meio];
			} else if (array[meio].compareTo(x) < 0) {
				left = meio + 1;
				floor = Integer.max(floor, array[meio]);
			} else {
				rigth = meio - 1;
			}

		}

		return floor;

	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {

		int left = 0;
		int rigth = array.length;
		Integer ceil = null;

		while (left < rigth) {

			int meio = (left + rigth)/2;

			if (array[meio].compareTo(x) == 0) {
				rigth = meio - 1;
				ceil = array[meio];
			} else if (array[meio].compareTo(x) < 0) {
				left = meio + 1;
			} else {
				rigth = meio - 1;
				ceil = Integer.min(ceil, array[meio]);
			}

		}

		return ceil;

	}

}
