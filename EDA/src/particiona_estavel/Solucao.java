package particiona_estavel;

import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] array = getArrayInteiros(line);
		partition(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		sc.close();
	}
	
	private static void partition(int[] array, int leftIndex, int rightIndex) {

		int pivotIndex = leftIndex;
		int pivotIterator = leftIndex;

		for(int i = leftIndex + 1; i <= rightIndex; i++) {

			if (array[i] <= array[pivotIndex]) {
				
				pivotIterator++;
				inserePelaEsquerda(array, i, pivotIterator);

			}

		}

		insereOrdenadoPrimeiro(array);

	}
	
	private static void inserePelaEsquerda(int[] array, int posicaoInicial, int posicaoFinal) {
		
		int i = posicaoInicial;
		int j = posicaoInicial - 1;
		
		while(j >= posicaoFinal) {
			swap(array, i, j);
			i--;
			j--;
		}
		
	}
	
	private static void insereOrdenadoPrimeiro(int[] array) {
		
		int i = 0;
		int j = i + 1;
		
		while(j < array.length && array[i] > array[j]) {
			swap(array, i, j);
			i++;
			j++;
		}
		
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
