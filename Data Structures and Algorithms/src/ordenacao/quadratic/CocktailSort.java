package ordenacao.quadratic;

public class CocktailSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		boolean estaOrdenado = false;
		
		while(!estaOrdenado) {
			
			estaOrdenado = true;
			
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					T aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
					estaOrdenado = false;
				}
			}
			
			for(int i = array.length - 1; i > 1; i--) {
				if(array[i].compareTo(array[i-1]) < 0) {
					T aux = array[i];
					array[i] = array[i-1];
					array[i-1] = aux;
					estaOrdenado = false;
				}
			}
			
		}
	}

}
