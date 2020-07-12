import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;
    
public class JogaJogoDoGalo {
	
  private static Scanner sin = new Scanner(in);
  
  public static void main(String[] args) {
    char jogador1 = 'X';
    char jogador2 = 'O';
    
    JogoDoGalo jogo;
    
    do
	{
		jogo = new JogoDoGalo(jogador1, jogador2);
		out.printf("Jogo #%d\n", jogo.numJogos);
		jogo.mostraTabuleiro();
		
		while (!jogo.terminado())
		{
			  out.print("(lin col): ");
			  int lin = sin.nextInt();
			  int col = sin.nextInt();
			  
			  if (jogo.jogadaValida(lin, col))
			  {
				  jogo.jogada(lin, col);
				  jogo.mostraTabuleiro();
			  } else
			  {
				  out.println("ERRO: jogada inválida!");
			  }
		}
		out.println();
		
		if (jogo.ultimoJogadorGanhou())
		{
			jogo.numJogos++;
			
			if (jogo.ultimoJogador() == jogador1)
			{
				jogo.vitoriasX++;
				out.print(jogo.vitoriasX);
			}
			else
			{
				jogo.vitoriasY++;
				out.print(jogo.vitoriasY);
			}
			
			out.println("Jogador " + jogo.ultimoJogador() + "ganhou!\n");
			jogo.printScores();
			
			if (jogo.vitoriasX == 3 || jogo.vitoriasY == 3)
			{
				break;
			}
		}
		
		else
		{
			jogo.numJogos++;
			jogo.empates++;
			out.println("Jogo empatado!\n");
			jogo.printScores();
		}
		
	} while (jogo.numJogos != 10);
	
}

