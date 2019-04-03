package estatistica_de_ordem;

import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] array = getArrayInteiros(line);
		int ordem = partition(array, 0, array.length - 1);
		System.out.println(ordem+1);
		sc.close();
	}
	
	private static int partition(int[] array, int leftIndex, int rightIndex) {

		int pivotIndex = leftIndex;
		int pivotIterator = leftIndex;

		for(int i = leftIndex + 1; i <= rightIndex; i++) {

			if (array[i] < array[pivotIndex]) {

				pivotIterator++;
				swap(array, pivotIterator, i);

			}

		}

		swap(array, pivotIndex, pivotIterator);
		pivotIndex = pivotIterator;

		return pivotIndex;

	}
	
	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	private static int[] getArrayInteiros(String arrayString) {
		String[] aux = arrayString.split(" ");
		int[] meuArray = new int[aux.length];
		for(int i = 0; i < aux.length; i++) meuArray[i] = Integer.parseInt(aux[i]);
		return meuArray;
	}
	
}
