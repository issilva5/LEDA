package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Matrix {
	
	protected int row;
	protected int column;
	protected double[][] matrix;
	
	/*
	 * Constructors
	 */
	
	public Matrix(int row, int column, double[] valores) {
		if(valores.length != row*column)
			throw new IllegalArgumentException("" + valores.length);
		
		this.row = row;
		this.column = column;
		this.matrix = new double[this.row][this.column];
		
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				int pos = i * this.column + j;
				this.matrix[i][j] = valores[pos];
			}
		}
	}
	
	public Matrix(int row, int column, double[][] valores) {
		if(valores.length != row*column)
			throw new IllegalArgumentException();
		
		this.row = row;
		this.column = column;
		this.matrix = valores;
		
	}
	
	public Matrix(int row, int column) {
		this.row = row;
		this.column = column;
		this.matrix = new double[this.row][this.column];
	}

	public Matrix(Matrix matrix) {
		this.row = matrix.row;
		this.column = matrix.column;
		this.matrix = matrix.matrix;
	}

	/*
	 * Matrix operations.
	 */
	
	public Matrix sum(Matrix b) {
		
		if(this.row != b.row)
			throw new UnsupportedOperationException();
		
		if(this.column != b.column)
			throw new UnsupportedOperationException();
		
		Matrix result = new Matrix(this);
		
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				result.matrix[i][j] += b.matrix[i][j];
			}
		}
		
		return result;
	}
	
	public Matrix sub(Matrix b) {
		
		if(this.row != b.row)
			throw new UnsupportedOperationException();
		
		if(this.column != b.column)
			throw new UnsupportedOperationException();
		
		Matrix result = new Matrix(this);
		
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				result.matrix[i][j] -= b.matrix[i][j];
			}
		}
		
		return result;
	}
	
	public Matrix prod(double k) {
		
		Matrix result = new Matrix(this);
		
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				result.matrix[i][j] *= k;
			}
		}
		
		return result;
	}
	
	public Matrix prod(Matrix b) {
		
		if(this.column != b.row)
			throw new UnsupportedOperationException();
		
		Matrix result = new Matrix(this.row, b.column);
		
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < b.column; j++) {
				for(int k = 0; k < this.column; k++) {
					result.matrix[i][j] += this.matrix[i][k] * b.matrix[k][j];
				}
				
			}
		}
		
		return result;
	}
	
	public Matrix transpose() {
		Matrix transpose = new Matrix(this);
		
		for(int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				transpose.matrix[j][i] = this.matrix[i][j];
			}
		}
		
		return transpose;
	}
	
	/*
	 * Row elementary operations
	 */
	
	public void rowAddition(int firstRow, int secondRow, double fistFactor, double secondFactor) {
		
		for(int j = 0; j < this.column; j++) {
			this.matrix[firstRow][j] = fistFactor * this.matrix[firstRow][j] + this.matrix[secondRow][j]*secondFactor;
		}
		
	}
	
	public void rowAddition(int firstRow, int secondRow, double secondFactor) {
		
		this.rowAddition(firstRow, secondRow, 1, secondFactor);
		
	}
	
	public void rowMultiplication(int row, double factor) {
		
		for(int j = 0; j < this.column; j++) {
			this.matrix[row][j] *= factor;
		}
		
	}
	
	public void rowSwitch(int firstRow, int secondRow) {
		
		for(int j = 0; j < this.column; j++) {
			double aux = this.matrix[firstRow][j];
			this.matrix[firstRow][j] = this.matrix[secondRow][j];
			this.matrix[secondRow][j] = aux;
		}
		
	}
	
	/*
	 * More advance operations
	 */
	
	public Matrix findSubmatrix(int[] rows, int[] columns) {
		Matrix submatrix = new Matrix(rows.length, columns.length);
		
		for(int i = 0; i < rows.length; i++) {
			for(int j = 0; j < columns.length; j++) {
				submatrix.matrix[i][j] = this.matrix[rows[i]-1][columns[j]-1];
			}
		}
		
		return submatrix;
	}
	
	public Matrix findSubmatrix(int row, int column) {
		
		return this.findSubmatrix(new int[] {row}, new int[] {column});
		
	}
	
	public void gaussianElimination() {
		
		if(this.isNullMatrix()) return;
		
		List<Integer> nullLines = new ArrayList<>();
		List<Row> stairColumns = new ArrayList<>();
		
		for(int i = 0; i < this.row; i++) {
			
			int column = -1;
			
			for(int j = 0; j < this.column; j++) {
				if(this.matrix[i][j] != 0) {
					
					if(this.matrix[i][j] != 1)
						this.rowMultiplication(i, 1/this.matrix[i][j]);
					
					column = j;
					break;
				}
			}
			
			if(column == -1) {
				nullLines.add(i);
				continue;
			}
			
			for(int line = 0; line < this.row; line++) {
				if(line != i) {
					this.rowAddition(line, i, -1 * this.matrix[line][column]);
					
					if(this.isNullRow(line))
						nullLines.add(line);
				}
			}
			
		}
		
		int last = this.row - 1;
		
		if(nullLines.size() > 0) {
			
			for(Integer i : nullLines) {
				if(i.intValue() == last) {
					last--;
					continue;
				} else {
					this.rowSwitch(i.intValue(), last);
				}
			}
		}
		
		for(int i = 0; i < last; i++)
			stairColumns.add(new Row(i, this.getRow(i)));
		
		Collections.sort(stairColumns);
		
		for(int i = 0; i < last; i++)
			this.setRow(i, stairColumns.get(i).getValues());
		
	}
	
	/*
	 * Booleans questions
	 */
	
	public boolean isRowMatrix() {
		return this.row == 1;
	}
	
	public boolean isColumnMatrix() {
		return this.column == 1;
	}
	
	public boolean isSymetric() {
		return this.equals(this.transpose());
	}
	
	public boolean isNullMatrix() {
		boolean isNull = true;
		
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				if(this.matrix[i][j] != 0) {
					isNull = false;
					break;
				}
			}
		}
		
		return isNull;
	}
	
	public boolean isNullRow(int row) {
		boolean isNullRow = true;
		
		for(int j = 0; j < this.column; j++) {
			if(this.matrix[row][j] != 0) {
				isNullRow = false;
				break;
			}
		}
		
		return isNullRow;
	}
	
	/*
	 * Getters and setters
	 */
	
	public int getRowSize() {
		return this.row;
	}
	
	public int getColumnSize() {
		return this.column;
	}
	
	public double[] getRow(int row) {
		double[] valores = new double[this.column];
		
		for(int j = 0; j < this.column; j++)
			valores[j] = this.matrix[row][j];
		
		return valores;
	}
	
	public double[] getColumn(int column) {
		double[] valores = new double[this.row];
		
		for(int i = 0; i < this.row; i++)
			valores[i] = this.matrix[i][column];
		
		return valores;
	}
	
	public void setRow(int row, double[] valores) {
		
		if(valores.length != this.column)
			throw new UnsupportedOperationException();
		
		for(int j = 0; j < this.column; j++)
			this.matrix[row][j] = valores[j];
		
	}
	
	public void setColumn(int column, double[] valores) {
		
		if(valores.length != this.row)
			throw new UnsupportedOperationException();
		
		for(int i = 0; i < this.row; i++)
			this.matrix[i][column] = valores[i];
		
	}
	
	public double getValue(int row, int column) {
		
		if(row > this.row || column > this.column)
			throw new IllegalArgumentException();
		
		return this.matrix[row-1][column-1];
	}
	
	public double[][] getMatrix() {
		return this.matrix;
	}

	public void setValue(int row, int column, double value) {
		
		if(row > this.row || column > this.column)
			throw new IllegalArgumentException();
		
		this.matrix[row-1][column-1] = value;
	}
	
	/*
	 * Hashcode and equals
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + Arrays.deepHashCode(matrix);
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}
	
	/*
	 * toString
	 */
	
	@Override
	public String toString() {
		String matrix = "Matrix (" + this.row + "x" + this.column + ")" + System.lineSeparator();
		
		for(int i = 0; i < this.row; i++) {
			for(int j = 0; j < this.column; j++) {
				matrix += String.format(Locale.US, "%.2f", this.matrix[i][j]) + (j < this.column - 1 ? " " : System.lineSeparator());
			}
		}
		
		return matrix;
	}
	
}