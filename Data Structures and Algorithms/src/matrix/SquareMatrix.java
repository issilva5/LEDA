package matrix;

public class SquareMatrix extends Matrix {
	
	public SquareMatrix(int size, double[] valores) {
		super(size, size, valores);
	}
	
	public SquareMatrix(int size, double[][] valores) {
		super(size, size, valores);
	}
	
	public SquareMatrix(int size) {
		super(size, size);
	}
	
	public SquareMatrix(SquareMatrix matrix) {
		super(matrix.getRowSize(), matrix.getRowSize(), matrix.getMatrix());
	}
	
	public boolean isDiagonalMatrix() {
		boolean isDiagonal = true;
		
		for(int i = 0; i < this.getRowSize(); i++) {
			for(int j = 0; j < this.getColumnSize(); j++) {
				if(this.getValue(i, j) != 0 && i != j) {
					isDiagonal = false;
					break;
				}
			}
		}
		
		return isDiagonal;
	}
	
	public boolean isSuperiorTriangleMatrix() {
		boolean isSuperiorTriangle = true;
		
		for(int i = 0; i < this.getRowSize(); i++) {
			for(int j = 0; j < this.getColumnSize(); j++) {
				if(this.getValue(i, j) != 0 && i > j) {
					isSuperiorTriangle = false;
					break;
				}
			}
		}
		
		return isSuperiorTriangle;
	}
	
	public boolean isInferiorTriangleMatrix() {
		boolean isInferiorTriangle = true;
		
		for(int i = 0; i < this.getRowSize(); i++) {
			for(int j = 0; j < this.getColumnSize(); j++) {
				if(this.getValue(i, j) != 0 && i < j) {
					isInferiorTriangle = false;
					break;
				}
			}
		}
		
		return isInferiorTriangle;
	}
	
	public double determinant() {
		
		double determinant = 0;
		
		if(this.row == 1) {
			
			determinant += this.matrix[0][0];
			
		} else {
			
			for(int j = 0; j < this.column; j++) {
				
				determinant += this.matrix[0][j] * Math.pow(-1, 2 + j) *
						       this.findSubmatrixToDeterminant(0, j).determinant();
				
			}
			
		}
		
		return determinant;
		
	}
	
	@Override
	public SquareMatrix findSubmatrix(int[] rows, int[] columns) {
		SquareMatrix submatrix = new SquareMatrix(rows.length);
		
		for(int i = 0; i < rows.length; i++) {
			for(int j = 0; j < columns.length; j++) {
				submatrix.matrix[i][j] = this.matrix[rows[i]-1][columns[j]-1];
			}
		}
		
		return submatrix;
	}
	
	public SquareMatrix findSubmatrixToDeterminant(int row, int column) {
		
		int[] rows = new int[this.row-1];
		int[] columns = new int[this.column-1];
		
		for(int i = 0, k = 0; i < this.row; i++) {
			if(i != row) {
				rows[k] = i + 1;
				k++;
			}
		}
		
		for(int i = 0, k = 0; i < this.column; i++) {
			if(i != column) {
				columns[k] = i + 1;
				k++;
			}
		}
		
		return this.findSubmatrix(rows, columns);
		
	}

}
