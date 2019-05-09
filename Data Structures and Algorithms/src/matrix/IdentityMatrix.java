package matrix;

public class IdentityMatrix extends SquareMatrix {

	public IdentityMatrix(int size) {
		super(size);
		
		for(int i = 1; i <= this.getRowSize(); i++) {
			this.setValue(i, i, 1);
		}
	}
	
	@Override
	public Matrix prod(Matrix b) {
		return b;
	}
	
	@Override
	public boolean isDiagonalMatrix() {
		return true;
	}
	
	@Override
	public boolean isSuperiorTriangleMatrix() {
		return true;
	}
	
	@Override
	public boolean isInferiorTriangleMatrix() {
		return true;
	}

}
