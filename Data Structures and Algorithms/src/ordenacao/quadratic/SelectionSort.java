package ordenacao.quadratic;

public class SelectionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		for(int i = 0; i < array.length; i++) {
		
			int menorIndex = i;
			
			for(int j = i+1; j < array.length; j++) {
				if(array[j].compareTo(array[menorIndex]) < 0) menorIndex = j;
			}
			
			T aux = array[i];
			array[i] = array[menorIndex];
			array[menorIndex] = aux;
		}
		
	}

}
