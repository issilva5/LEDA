package chechar_arvore;

import java.util.ArrayList;
import java.util.Scanner;

public class Solucao {

	private static int[] comp;
	private static ArrayList<Integer>[] ladj;
	
	public static void main(String[] args) {
		
		int n, m;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		ladj = new ArrayList[n];
		comp = new int[n];
		for (int i = 0; i < n; i++) { 
            ladj[i] = new ArrayList<Integer>();
            comp[i] = -1;
        }
		
		for (int i = 0; i < m; i++) {
			
			String[] edge = sc.nextLine().split(" ");
			int vertex1 = Integer.parseInt(edge[0]);
			int vertex2 = Integer.parseInt(edge[1]);
			
			ladj[vertex1].add(vertex2);
			ladj[vertex2].add(vertex1);
			
		}
		
		if (n != m + 1) {
			
			System.out.println("False");
			return;
			
		}
		
		int compVar = 0;
		
		boolean aux = false;
		
		for (int i = 0; i < n && !aux; i++) {

			if (comp[i] == -1) {
				
				compVar++;
				comp[i] = compVar;
				aux = dfs(i, -1);
				
			}
			
		}
		
		if (aux || compVar > 1) {
			
			System.out.println("False");
			
		} else {
			
			System.out.println("True");
			
		}
		
	}

	private static boolean dfs(int i, int pai) {
		
		for (int j = 0; j < ladj[i].size(); j++) {
			
			if (comp[ladj[i].get(j)] == -1) {
				
				comp[ladj[i].get(j)] = comp[i];
				dfs(ladj[i].get(j), i);
				
			} else {
				
				if (ladj[i].get(j) != pai) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
}
