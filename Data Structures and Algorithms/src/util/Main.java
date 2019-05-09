package util;

import java.util.Arrays;
import java.util.Random;

import ordenacao.linear.*;

public class Main {
	
	private static int geraRandom(int i) {
		Random r = new Random();
		return r.nextInt(i);
	}
	
	public static void main(String[] args) {
		
		//SortingTimeGet time = new SortingTimeGet();
		//long[] times = time.generateData(new SortingAlgorithm[]{
		//		new CountingSort()
		//}, 1000);
		
		SortingAlgorithmLinear sort = new RadixSortLSD();
		
		int length = 10000000;
		int numMinimo = 0;
		int numMaximo = (int) 1e+6;
		int[] array = new int[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = numMinimo + geraRandom(numMaximo - numMinimo);
		}
		
		//System.out.println(Arrays.toString(array));
		
		int[] array2 = Arrays.copyOf(array, array.length);
		Arrays.sort(array2);
		
		long start = System.currentTimeMillis(); 
        
		int[] aux = sort.sort(array);
		
        long end = System.currentTimeMillis();
        
        assert(Arrays.equals(aux, array2));
		
		System.out.println((end - start) /*+ " " + Arrays.toString(aux)*/);
		
	}

}
