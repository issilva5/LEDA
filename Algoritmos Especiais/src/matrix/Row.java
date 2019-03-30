package matrix;

import java.util.Arrays;

public class Row implements Comparable<Row> {
	
	private int number;
	private double[] values;
	private int firstNonZero;
	
	public Row(int number, double[] values) {
		this.number = number;
		this.values = values;
		
		for(int i = 0; i < this.values.length; i++) {
			if(this.values[i] != 0) {
				this.firstNonZero = i;
				break;
			}
		}
	}
	
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double[] getValues() {
		return this.values;
	}

	public void setValues(double[] values) {
		this.values = values;
	}

	public int getFirstNonZero() {
		return this.firstNonZero;
	}

	public void setFirstNonZero(int firstNonZero) {
		this.firstNonZero = firstNonZero;
	}
	
	@Override
	public int compareTo(Row row) {
		return Integer.compare(this.firstNonZero, row.firstNonZero);
	}

	@Override
	public String toString() {
		return "Row [number=" + number + ", values=" + Arrays.toString(values) + ", firstNonZero=" + firstNonZero + "]";
	}
	
}
