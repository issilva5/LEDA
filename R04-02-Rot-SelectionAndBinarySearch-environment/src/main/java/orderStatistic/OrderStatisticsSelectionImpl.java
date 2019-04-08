package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {

		T aux = null;

		if(array != null && array.length > 0) {

			aux = array[0];

			for (int i = 0; i < k; i++) {

				T menor = aux;

				for (int j = 0; j < array.length; j++) {

					if(array[j].compareTo(menor) < 0) {

						menor = array[j];

					}

				}

				aux = menor;

			}

		}

		return aux;


	}

	/*public static void main() {

		OrderStatisticsSelectionImpl<Integer> order = new OrderStatisticsSelectionImpl<>();
		Integer[] array = new Integer[]{9, 5, 1, 14, 3, 2, 0, 67, 4};
		System.out.println(order.getOrderStatistics(array, 1));
		System.out.println(order.getOrderStatistics(array, 2));
		System.out.println(order.getOrderStatistics(array, 3));
		System.out.println(order.getOrderStatistics(array, 4));
		System.out.println(order.getOrderStatistics(array, 5));
		System.out.println(order.getOrderStatistics(array, 6));
		System.out.println(order.getOrderStatistics(array, 7));
		System.out.println(order.getOrderStatistics(array, 8));
		System.out.println(order.getOrderStatistics(array, 9));

	}*/

}
