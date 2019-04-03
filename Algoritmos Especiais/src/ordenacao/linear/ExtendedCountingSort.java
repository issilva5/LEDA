package ordenacao.linear;

public class ExtendedCountingSort implements SortingAlgorithmLinear {

	@Override
	public int[] sort(int[] array) {
		
		int greatest = findGreatest(array);
		int smallest = findSmallest(array);
		int length = greatest - smallest + 1;
		
		int[] frequence = new int[length];
		int[] output = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			frequence[array[i] - smallest]++;
		}
		
		accumulate(frequence);
		
		for(int i = array.length-1; i > -1; i--) {
			output[frequence[array[i] - smallest] - 1] = array[i];
			frequence[array[i] - smallest]--;
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
	
	private int findSmallest(int[] array) {
		
		int smallest = 1;
		
		for(int i = 0; i < array.length; i++) {
			smallest = Math.min(smallest, array[i]);
		}
		
		return smallest;
	}
}
