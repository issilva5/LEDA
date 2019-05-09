package ordenacao.linear;

import java.util.Arrays;

public class RadixSortLSD implements SortingAlgorithmLinear {

	@Override
	public int[] sort(int[] array) {
		
		int logLimit = getLimit(array);
		int exp = 1;
		
		for(int i = 0; i < logLimit; i++) {
			
			array = Arrays.copyOf(sortAuxiliar(array, exp), array.length);
			exp *= 10;
			//System.out.println(Arrays.toString(array));
		}
		
		return array;
	}

	private int getLimit(int[] array) {
	
		int logLimit = 0;
		
		for(int i = 0; i < array.length; i++) {
			logLimit = Math.max(logLimit, (int) Math.log10(array[i]) + 1);
		}
		
		return logLimit;
	}
	
	public int[] sortAuxiliar(int[] array, int exp) {
		
		int[] frequence = new int[10];
		int[] output = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			frequence[(array[i]/exp) % 10]++;
		}
		
		accumulate(frequence);
		
		for(int i = array.length-1; i > -1; i--) {
			output[frequence[(array[i]/exp) % 10] - 1] = array[i];
			frequence[(array[i]/exp) % 10]--;
		}
		
		return output;
		
	}

	private void accumulate(int[] frequence) {
		
		for(int i = 1; i < frequence.length; i++ ) {
			frequence[i] += frequence[i-1];
		}
		
	}

}
