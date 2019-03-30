package matrix;

public class Main {
	
	public static void main(String[] args) {
		
		double[] v = new double[]{15, 20,
								  1, 2};
		
		SquareMatrix t = new SquareMatrix(2, v);
		
		System.out.println(t.toString());
		
		System.out.println(new IdentityMatrix(7).determinant());
		
	}
	
}
