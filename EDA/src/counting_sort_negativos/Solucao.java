package counting_sort_negativos;

import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] array = getArrayInteiros(line);
		int greatest = Integer.parseInt(sc.nextLine());
		int smallest = Integer.parseInt(sc.nextLine());
		int[] output = sort(array, smallest, greatest);
		System.out.println(Arrays.toString(output));
		sc.close();
	}
	
	private static int[] sort(int[] array, int smallest, int greatest) {
		
		int length = greatest - smallest + 1;
		
		int[] frequence = new int[length];
		int[] output = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			frequence[array[i] - smallest]++;
			System.out.println(Arrays.toString(frequence));
		}
		
		accumulate(frequence);
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(frequence));
		
		for(int i = array.length-1; i > -1; i--) {
			output[frequence[array[i] - smallest] - 1] = array[i];
			frequence[array[i] - smallest]--;
		}
		
		System.out.println(Arrays.toString(frequence));
		
		return output;
		
	}

	private static void accumulate(int[] frequence) {
		
		for(int i = 1; i < frequence.length; i++ ) {
			frequence[i] += frequence[i-1];
		}
		
	}
	
	private static int[] getArrayInteiros(String arrayString) {
		String[] aux = arrayString.split(" ");
		int[] meuArray = new int[aux.length];
		for(int i = 0; i < aux.length; i++) meuArray[i] = Integer.parseInt(aux[i]);
		return meuArray;
	}
	
}
