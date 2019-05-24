package is_heap;

import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] nodes = sc.nextLine().split(" ");
		int[] intNodes = new int[nodes.length];
		
		for(int i = 0; i < nodes.length; i++) intNodes[i] = Integer.parseInt(nodes[i]);
		
		System.out.println(isHeap(intNodes));
		sc.close();
		
	}

	private static boolean isHeap(int[] intNodes) {
		
		boolean isHeap = true;
		
		for (int i = intNodes.length; i > -1; i--) {
			
			isHeap = isHeap && heapVerify(i/2, intNodes);
			
		}
		
		return isHeap;
		
	}

	private static boolean heapVerify(int i, int[] intNodes) {
		
		int maxValue = intNodes[i];
		
		if(2*i + 1 < intNodes.length)
			maxValue = Math.max(maxValue, intNodes[2*i + 1]);
		
		if(2*i + 2 < intNodes.length)
			maxValue = Math.max(maxValue, intNodes[2*i + 2]);
		
		if (maxValue == intNodes[i])
			return true;
		
		return false;
		
	}
	
}
