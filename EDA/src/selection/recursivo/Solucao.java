package selection.recursivo;

import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] array = getArrayInteiros(line);
		sortRecursive(array, 0);
		sc.close();
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
		
		if(i < array.length - 1) {
			int menorIndex = i;
			
			for(int j = i+1; j < array.length; j++)
				if(array[j] < array[menorIndex]) menorIndex = j;
			
			swap(array, i, menorIndex);
			
			System.out.println(Arrays.toString(array));
			sortRecursive(array, i+1);
			
		}
		
	}
	
}
