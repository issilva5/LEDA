
package insertion_sort_recursivo;

import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] array = getArrayInteiros(line);
		sortRecursive(array, 1);
	}
	
	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	public static int[] getArrayInteiros(String arrayString) {
		String[] aux = arrayString.split(" ");
		int[] meuArray = new int[aux.length];
		for(int i = 0; i < aux.length; i++) meuArray[i] = Integer.parseInt(aux[i]);
		return meuArray;
	}
	
	public static void sortRecursive(int[] array, int i) {
		
		if(i < array.length) {
		
			int j = i;
			while(j > 0 && array[j] < array[j-1]) {
				swap(array, j, j-1);
				j--;
			}
			
			System.out.println(Arrays.toString(array));
			sortRecursive(array, i+1);
		}
		
	}
	
}
