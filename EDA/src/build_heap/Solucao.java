package build_heap;

import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] nodes = sc.nextLine().split(" ");
		int[] intNodes = new int[nodes.length];
		
		for(int i = 0; i < nodes.length; i++) intNodes[i] = Integer.parseInt(nodes[i]);
		
		intNodes = build_heap(intNodes);
		
		System.out.println(Arrays.toString(intNodes));
		sc.close();
		
	}

	private static int[] build_heap(int[] intNodes) {
		
		for (int i = intNodes.length; i > -1; i--) {
			
			intNodes = heapify(i/2, intNodes);
			
		}
		
		return intNodes;
		
	}

	private static int[] heapify(int i, int[] intNodes) {
		
		int maxValue = intNodes[i];
		
		if(2*i + 1 < intNodes.length)
			maxValue = Math.max(maxValue, intNodes[2*i + 1]);
		
		if(2*i + 2 < intNodes.length)
			maxValue = Math.max(maxValue, intNodes[2*i + 2]);
		
		if (2*i + 1 < intNodes.length && maxValue == intNodes[2*i + 1]) {
			
			int aux = intNodes[2*i + 1];
			intNodes[2*i + 1] = intNodes[i];
			intNodes[i] = aux;
			return heapify(2*i + 1, intNodes);
			
		} else if (2*i + 2 < intNodes.length && maxValue == intNodes[2*i + 2]) {
			
			int aux = intNodes[2*i + 2];
			intNodes[2*i + 2] = intNodes[i];
			intNodes[i] = aux;
			return heapify(2*i + 2, intNodes);
			
		}
		
		return intNodes;
		
	}
	
}
