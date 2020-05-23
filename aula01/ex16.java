import java.util.*;

public class ex16 {
	
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		
		int secret = (int)(100.0*Math.random()) + 1;
		int n; //numero escrito pelo teclado para adivinhar o numero do "jogo"
		int cont = 1;
		
		System.out.print("Introduza um valor: ");
		n = sc.nextInt();
		
		while (n != secret)
		{
			if (n < secret)
			{
				System.out.printf("Demasiado baixo");
				System.out.print("\nNovo valor:");
				n = sc.nextInt();
				cont++;
			} else if (n > secret)
			{
				System.out.printf("Demasiado alto");
				System.out.print("\nNovo Valor:");
				n = sc.nextInt();
				cont++;
			}
		}
		
		while (n == secret) 
		{
			break;
		}
		
		System.out.printf("Parabéns! Acertou no numero!\n");
		System.out.printf("Pontuação do jogador: " + cont);
		
	}
}
