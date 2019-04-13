package problems;

/**
 * 
 * Dado um array ordenado de elementos comparaveis e um outro elemento comparavel, 
 * implemente o metodo que conte as ocorrências do elemento no array. 
 * 
 * Restricoes:
 * - a complexidade esperada é O (log.n). Soluções com tempo O(n) ou superiores serão desconsideradas.
 * - voce nao pode usar memoria extra
 * - voce nao pode usar metodos prontos da bilbioteca de arrays (exceto o metodo length)
 * - Dica: tente pensar numa forma eficiente (em log n) de descobrir a posicao de um 
 *   elemento no array e use essa ideia para contar as ocorrencias desse elemento no array
 * 
 * @author campelo
 *
 * @param <T>
 */
public class OccurrencesCounterImpl<T extends Comparable<T>> {

	/*
	 * Se elem está presente no array[], retorna a quantidade de ocorrências de elem.
	 * Caso contrário, retorna 0.
	 */
	public int count(T[] array, T elem) {

		int occurrences = 0;

		if (array != null && elem != null) {

			int firstOccurrence = floor(array, elem);
			int lastOccurrence = ceil(array, elem);

			if (firstOccurrence != -1 && lastOccurrence != -1) {

				occurrences = lastOccurrence - firstOccurrence + 1;

			}

		}

		return occurrences;
		
	}

	private int floor(T[] array, T elem) {

		int floorPos = -1;

		int begin = 0;
		int end = array.length - 1;

		while (begin <= end) {

			int mid = (begin + end) / 2;

			if (array[mid].compareTo(elem) == 0) {

				floorPos = mid;
				end = mid - 1;

			} else if (array[mid].compareTo(elem) > 0) {

				end = mid - 1;

			} else {

				begin = mid + 1;

			}

		}

		return floorPos;

	}

	private int ceil(T[] array, T elem) {

		int ceilPos = -1;

		int begin = 0;
		int end = array.length - 1;

		while (begin <= end) {

			int mid = (begin + end) / 2;

			if (array[mid].compareTo(elem) == 0) {

				ceilPos = mid;
				begin = mid + 1;

			} else if (array[mid].compareTo(elem) > 0) {

				end = mid - 1;

			} else {

				begin = mid + 1;

			}

		}

		return ceilPos;

	}

}
