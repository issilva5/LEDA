package merge_sort_passo_a_passo;

import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] array = getArrayInteiros(line);
		sort(array, 0, array.length - 1);
		sc.close();
	}
	
	private static int[] getArrayInteiros(String arrayString) {
		String[] aux = arrayString.split(" ");
		int[] meuArray = new int[aux.length];
		for(int i = 0; i < aux.length; i++) meuArray[i] = Integer.parseInt(aux[i]);
		return meuArray;
	}
	
	
	private static void sort(int[] array, int left, int right) {
		
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, left, right+1)));
		
		if(left < right) {
			
			int mid = (left + right)/2;
			sort(array, left, mid);
			sort(array, mid+1, right);
			
			merge(array, left, right);
			
			System.out.println(Arrays.toString(Arrays.copyOfRange(array, left, right+1)));
			
		}
		
	}

	private static void merge(int[] array, int left, int right) {
		
		int mid = (left + right)/2;
		int[] helper = new int[array.length];
		
		int i = left;
		int j = mid + 1;
		int k = left;
		
		while(i <= mid && j <= right) {
			if(array[i] < array[j]) {
				helper[k] = array[i];
				i++;
			} else {
				helper[k] = array[j];
				j++;
			}
			
			k++;
		}
		
		while(i <= mid) {
			helper[k] = array[i];
			i++;
			k++;
		}
		
		while(j <= right) {
			helper[k] = array[j];
			j++;
			k++;
		}
		
		for(i = left; i <= right; i++) {
			array[i] = helper[i];
		}
	}
	
}
