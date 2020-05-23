/*
 * ex14.java
 * Na terra do Alberto Alexandre (localmente conhecido por Aubeto Auexande), o dialecto
local é semelhante ao português com duas excepções:
• Não dizem os Rs
• Trocam os Ls por Us
Implemente um tradutor de português para o dialecto do Alberto. Por exemplo “lar doce
lar” deve ser traduzido para “ua doce ua”. A tradução deve ser feita linha a linha, até que
surja uma linha vazia.
 */

import java.util.*;

public class ex14 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		//~ do
		//~ {
			//~ String frase = sc.nextLine();
			//~ char fr[] = new char [frase.length()];
			//~ for (int i = 0; i < frase.length(); i++)
			//~ {
				//~ fr[i] = frase.charAt(i);
				//~ if (fr[i] == 'l')
				//~ {
					//~ fr[i] = 'u';
				//~ }
				
				//~ if (fr[i] == 'L')
				//~ {
					//~ fr[i] = 'U';
				//~ }
				
				//~ if (fr[i] != 'r')
				//~ {
					//~ System.out.print(fr[i]);
				//~ }
			//~ }
			
		//~ } while (frase != "");
		
		String frase;
		
		do
		{
			System.out.print("Introduza uma frase: ");
			frase = sc.nextLine();
			String frase1 = dialetos(frase);
			System.out.printf(frase1 + "\n");
		} while (frase.length() != 0);
		
	}
		
		public static String dialetos (String frase) {
			
			String traducao = "";
			char fr[] = new char [frase.length()];
			char c, cl='l', cu='u';
		
			for (int i = 0; i < frase.length(); i++)
			{
				fr[i] = frase.charAt(i);
				if (fr[i] == 'l')
				{
					fr[i] = 'u';
				}
				
				if (fr[i] == 'L')
				{
					fr[i] = 'U';
				}
				
				if (fr[i] != 'r')
				{
					System.out.print(fr[i]);
				}
			}
			return traducao;
		
	}
}

