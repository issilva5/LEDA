package util;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

	private int numMaximo;
	private int numMinimo;
	
	public ArrayGenerator() {
		this(0, (int) 1e6);
	}
	
	public ArrayGenerator(int numMinimo, int numMaximo) {
		this.numMaximo = numMaximo;
		this.numMinimo = numMinimo;
	}
	
	public Integer[] generateIntegerArray(int length) {
		Integer[] array = new Integer[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = this.numMinimo + geraRandom(this.numMaximo - this.numMinimo);
		}
		
		return array;
	}
	
	public Integer[] generateIntegerArraySorted(int length) {
		Integer[] array = new Integer[length];
		
		for(int i = 0; i < length; i++) {
			array[i] = this.numMinimo + geraRandom(this.numMaximo - this.numMinimo);
		}
		
		Arrays.sort(array);
		return array;
	}

	private int geraRandom(int i) {
		Random r = new Random();
		return r.nextInt(i);
	}
	
}
