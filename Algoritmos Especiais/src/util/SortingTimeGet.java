package util;

import ordenacao.quadratic.*;

public class SortingTimeGet {
	
	private ArrayGenerator generator;
	
	public SortingTimeGet() {
		this.generator = new ArrayGenerator();
	}
	
	private long generate(SortingAlgorithm<Integer> sorter, Integer[] array) {
		
		long start = System.currentTimeMillis(); 
	       
        sorter.sort(array);
		
        long end = System.currentTimeMillis();
        
		return end - start;
	}
	
	public long[] generateData(SortingAlgorithm<Integer>[] sorters, int length) {
		
		Integer[] array = this.generator.generateIntegerArray(length);
		long[] times = new long[sorters.length];
		
		for(int i = 0; i < sorters.length; i++) {
			times[i] = this.generate(sorters[i], array);
			System.out.println("Ended " + (i+1));
		}
		
		return times;
	}
	
	public long[] generateDataSorted(SortingAlgorithm<Integer>[] sorters, int length) {
		
		Integer[] array = this.generator.generateIntegerArraySorted(length);
		long[] times = new long[sorters.length];
		
		for(int i = 0; i < sorters.length; i++) {
			times[i] = this.generate(sorters[i], array);
			System.out.println("Ended " + (i+1));
		}
		
		return times;
	}
	
}