//Construa uma função recursiva – countPairs – que recebendo (pelo menos 3 ) um String
//como argumento, devolve o número de vezes que dois caracteres iguais estão em posições
//consecutivas nesse texto.

import static java.lang.System.*;

public class P2
{
  public static void main(String[] args)
  {
	  if (args.length == 0)
	  {
		  out.println("Usage: java -ea P2 <text> ...");
		  exit(1);
	  }
	  
	  for (int i = 0; i < args.length; i++)
	  {
		  System.out.println("'"+args[i]+"'"+" contains "+ countPairs(args[i]) + " pairs of cunsetutive equal characters");
	  }  
	  
	  /*assert args.length > 0: "Usage: java P2 <arg1> ... <argsN>";
	  for(String a : args) //No for each não existe indice. A String 'a' toma o valor de todos os argumentos
		Sustem.out.printf("\"%s\" contains %d pairs of consecutive equal characters\n", a, countPairs(a, 0)); */
  }
  
  public static int countPairs(String s) {
	  int count = 0; //contador
	  for (int i = 0; i < s.length()-1; i++)
	  {
		if (s.charAt(i) == s.charAt(i+1))
		{
			count++;
		}  
	  }
	  return count;
  }
  
  /*static int countPairs(String str, int i) {
	  if(i >= str.length()-1) return 0;
	  if(str.charAt(i) == str.charAt(i+1)) return 1 + countPairs(str, i+1);
	  else return 0 + countPairs(str, i+1);
  } */
  
  /*
  //verifica se ha char repetidos analisando o proprio e o proximo
  //percorre a String de forma recursiva
  public static int countPairs (String s, int i) {
	  if (i >= s.length() - 1)
	  {
		  return 0;
	  }
	  if (s.charAt(i) == s.charAt(i+1))
	  {
		  return 1 + countPairs(s, i+1);
	  }
	  else
	  {
		  return 0 + countPairs(s, i+1);
	  }
  }*/

}

