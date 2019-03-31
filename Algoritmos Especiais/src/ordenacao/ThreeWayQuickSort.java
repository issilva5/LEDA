package ordenacao;

public class ThreeWayQuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		
		sort(array, 0, array.length - 1);
		
	}
	
	private void sort(T[] array, int left, int right) {
		
		if(left < right) {
			
			T pivot = array[left];
			int pivotBegin = left;
			int pivotEnd = right;
			int it = left;
			
			while(it <= pivotEnd) {
				
				if(array[it].compareTo(pivot) < 0) {
					T aux = array[pivotBegin];
					array[pivotBegin] = array[it];
					array[it] = aux;
					pivotBegin++;
					it++;
				} else if(array[it].compareTo(pivot) > 0) {
					T aux = array[pivotEnd];
					array[pivotEnd] = array[it];
					array[it] = aux;
					pivotEnd--;
				} else {
					it++;
				}
				
			}
			
			sort(array, left, pivotBegin - 1);
			sort(array, pivotEnd + 1, right);
			
		}
		
	}
	
}
