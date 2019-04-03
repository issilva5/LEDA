package ordenacao.linear;

import java.util.ArrayList;
import java.util.List;

public class BucketSort implements SortingAlgorithmLinear {

	@Override
	public int[] sort(int[] array) {
		
		int greatest = findGreatest(array);
		List< List<Integer> > buckets = new ArrayList<>();
		for(int i = 0; i < greatest/100 + 1; i++) buckets.add(new ArrayList<>());
		
		for(int i = 0; i < array.length; i++) {
			buckets.get(array[i]/100).add(array[i]);
		}
		
		int k = 0;
		
		for(int i = 0; i < buckets.size(); i++) {
			
			int[] littleBucket = buckets.get(i).stream().mapToInt((Integer p) -> p.intValue()).toArray();
			int[] aux = sortAuxiliar(littleBucket);
			
			for(int j = 0; j < aux.length; j++) {
				array[k] = aux[j];
				k++;
			}
			
		}
		
		return array;
		
	}
	
	private int findGreatest(int[] array) {
		
		int greatest = 0;
		
		for(int i = 0; i < array.length; i++) {
			greatest = Math.max(greatest, array[i]);
		}
		
		return greatest;
	}
	
	private int[] sortAuxiliar(int[] array) {
		
		int greatest = findGreatest(array);
		int[] frequence = new int[greatest];
		int[] output = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			frequence[array[i] - 1]++;
		}
		
		accumulate(frequence);
		
		for(int i = array.length-1; i > -1; i--) {
			output[frequence[array[i] - 1] - 1] = array[i];
			frequence[array[i] - 1]--;
		}
		
		return output;
		
	}

	private void accumulate(int[] frequence) {
		
		for(int i = 1; i < frequence.length; i++ ) {
			frequence[i] += frequence[i-1];
		}
		
	}

}
