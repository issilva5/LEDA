package inverte_frase;

import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String out = "";
		String texto = "";
		
		for (int i = 0; i < line.length(); i++) {
			
			if (line.charAt(i) == ' ') {
				out = texto + " " + out;
				texto = "";
			} else {
				
				texto += line.charAt(i);
				
			}
			
		}
		
		out = texto + " " + out;
		System.out.println(out);
		sc.close();
		
	}
	
}
