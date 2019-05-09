package ordenacao.quadratic;

public class RecursiveSelectionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		sort(array, 0);
		
	}
	
	private void sort(T[] array, int i) {
		
		if(i < array.length - 1) {
		
			int menorIndex = i;
			
			for(int j = i+1; j < array.length; j++)
				if(array[j].compareTo(array[menorIndex]) < 0) menorIndex = j;
			
			T aux = array[i];
			array[i] = array[menorIndex];
			array[menorIndex] = aux;
			
			sort(array, i+1);
			
		}
		
	}

}
