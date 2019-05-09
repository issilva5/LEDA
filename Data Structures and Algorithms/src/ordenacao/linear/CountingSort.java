package ordenacao.linear;

public class CountingSort implements SortingAlgorithmLinear {
	
	public int[] sort(int[] array) {
		
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

	private int findGreatest(int[] array) {
		
		int greatest = 0;
		
		for(int i = 0; i < array.length; i++) {
			greatest = Math.max(greatest, array[i]);
		}
		
		return greatest;
	}
	
}
