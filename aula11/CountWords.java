import static java.lang.System.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import p2utils.KeyValueList;

public class CountWords
{

  public static void main(String[] args) {
    KeyValueList<Integer> counts = new KeyValueList<>();

    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
      File fin = new File(args[a]);
      // Using a try-with-resources:
      try (Scanner scf = new Scanner(fin)) {
        while (scf.hasNextLine()) { // Processa cada linha
          String line = scf.nextLine();
          // Divide a linha em "palavras", considerando como separador
          // qualquer sequência de 1 ou mais carateres não alfabéticos:
          String[] palavras = line.split("[^\\p{IsAlphabetic}]+");
          // (Sobre expressões regulares usadas no split: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)

          for (int i = 0; i < palavras.length; i++) { // Processa cada palavra
            // Completar...
			String word = palavras[i].toLowerCase();
			
			//se a palavra existir no dicionario, contar as vezes q ela aparece
			if (counts.contains(word))
			{
				counts.set(word, counts.get(word) + 1);
				//Se só aparece uma vez, contar apenas essa vez
			} else
			{
				counts.set(word, 1);
			}
          }
        }
      }
      catch (Exception e) {
        err.println("ERRO: " + e.getMessage());
      }
    }
    out.println(counts.toString("Results:\n", ";\n", "\nEnd"));
    out.println(counts.toString()); // mesma lista, outro formato
    mostFrequent(counts);
  }

	/*Complete a função mostFrequent para descobrir a palavra mais frequente e indicar
a sua frequência relativa.*/
  // Find and print the key with most occurrences
  // and its relative frequency.
  static void mostFrequent(KeyValueList<Integer> counts) {
    // Completar...
    int sum = 0; //total de palavras introduzidas
    int max = 0; //maximo de vezes de cada palavra
    String maxIndex = ""; //palavra aparecida mais vezes
    
    String[] keys = counts.keys();
    
    for(String key : keys) {
		int i = counts.get(key);
		if (i > max)
		{
			max = i;
			maxIndex = key;
		}
		sum += i;
	}
	
	System.out.printf("Palavra mais usada: %s\n Frequencia relativa: %f\n", maxIndex, 100.0*max/sum);
  }
}

