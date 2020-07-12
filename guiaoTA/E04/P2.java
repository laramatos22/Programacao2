//Implemente uma função recursiva – invertDigits – que recebendo (pelo menos 2 ) um
//String como argumento, devolve um novo String em que as sequências de dı́gitos lá
//contidas são invertidas mantendo a ordem dos restantes caracteres.

import static java.lang.System.*;
import java.util.*;

public class P2
{
  public static void main(String[] args)
  {
	  Scanner read = new Scanner (System.in);
	  
	  //Get String(s)
	  String str;
	  
	  //As strings têm q estar nos argumentos da linha de comandos
	  if (args.length<1)
	  {
		  System.out.println("Inserir as Strings para inverter: ");
		  str = read.nextLine();
		  System.out.printf("\n '%s' -> '%s'", str, invertDigits(str));
	  } else
	  {
		  //Se for pela consola
		  for (String i : args)
		  {
			  System.out.println(i + " -> " + invertDigits(i));
		  }
	  }
	  
	  //OUTRA RESOLUÇÃO
	  for(String s : args) {
		  out.printf("%s -> %s\n", s, invertString(s, "", 0));
	  }
  }
  
  public static String invertDigits(String argsStr) {
	  //end case: when the substring of the string it's being inverted only has 1 char
	  if (argsStr.length() == 1)
	  {
		  return argsStr;
	  }
	  //return last char of the string and calls the function again for the rest of the said string
	  return argsStr.charAt(argsStr.length() -1) + invertDigits(argsStr.substring(0, argsStr.length()-1));
  }
  
  //OUTRA RESOLUÇÃO
  static String invertString (String s, String numbers, int i) {
	  //Se a string for vazia retorna nada
	  if (i > s.length() - 1)
	  {
		  return "";
	  }
	  //usa o primeiro char da frase
	  char c = charAt(i);
	  //se o char for um numero
	  if (Character.isDigit(c))
	  {
		  //à parte numeros da String adiciona-se o novo c
		  numbers = c + numbers;
		  //se nao houver mais nenhum caracter ou mais nenhum numero
		  if (i == s.length()-1 || !Character.isDigit(s.charArt(i+1)))
		  {
			  //devolde os numeros invertidos e a inversao da string
			  return numbers + invertString(s, "", i+1);
		  }
		  //inverte a string de letras
		  return invertString(s, numbers, i+1);
	  }
	  //devolve a primeira char e nverte os seguinte no caso deste nao ser um numero
	  else return c + invertString(s, "", i+1);
  }

}

