//Implemente uma função recursiva factors que recebendo um número inteiro como argu-
//mento devolve uma String com o produto dos seus factores.

import static java.lang.System.*;
import java.util.*;

public class Factors {

  public static void main(String[] args) {
    for(int i = 0; i < args.length; i++)
      out.println(args[i]+" = "+factors(Integer.parseInt(args[i])));
      
    //OUTRA RESOLUÇÃO em comentário
    /*
    if (args.lentgh == 0)
	{
		System.out.println("Invalid number of arguments");
		System.exit(1);
	}
	//Verificação desnecessária, porque percorre 2 vezes o array. 
	//No entanto torna o programa robusto
	//Garante que todos os argumentos são válidos antes de correr
	
	try
	{
		for(String a : args) {
			int n = Integer.parseInt(a);
		}
	}
	catch (Exception e)
	{
		System.out.println("Usage: java Factors <number>");
		System.exit(1);
	}
	
	for(String a : args) {
		int n = Integer.parseInt(a);
		System.out.printf("%d = %s\n", n, factors());
	}*/
    
  }
  
  public static String factors(int n) {
	  if (n==1)
	  {
		  return "1";
	  }
	  if (isPrime(n))
	  {
		  return n;
	  } else
	  {
		  int primo = primeDiv(n);
		  if (n%primo == 0)
		  {
			  return (primo + "*" + factors(n/primo));
		  }
	  }
	  return ;
  }
  
  //se n for primo return true
  public static boolean isPrime (int n) {
	  if (n == 2)
	  {
		  return true;
	  } else if (n > 2)
	  {
		  for (int i = 2; i < n; i++)
		  {
			  if (n/i == 0)
			  {
				  return false;
			  }
			  if (n%i != 0)
			  {
				  return true;
			  }
		  }
	  }
	  return false;
  }
  
  //retorna o nº primo da divisao de q por M
  public static int primeDiv (int M) {
	  for (int x = 2; x <= (M/2); x++)
	  {
		  if (x == 2 && M%x == 0) return x;
		  if (x>2)
		  {
			  for (int i = 2; i < x; i++)
			  {
				  if(x%i == 0) return -1;
				  if (i==x-1 && M%x== 0) return x;
			  }
		  }
	  }
	  return -1;
  }
  
  /*
  static String factors (int n) {
	  assert n>=0;
	  if(n == 0) return "0";
	  if(n == 1) return "1";
	  for (int i = 2; i < n/2; i++) 
	  //Para tornar o algortimo mais eficaz. Não é necessário verificar os valores a partir de n/2
	  {
		  if (n%i == 0)
		  {
			  return String.valueOf(i) + " * " + factors(n/i);
		  }
	  }
	  
  }*/
  
  /*
  public static String factors (int number) {
	  assert number >= 0;
	  //se o numero for 1 ou 0 basta devolver o numero, daí começarmos o cilco em 2
	  for (int i = 2; i < number; i++)
	  {
		  if (number%i == 0) //verifica se é um fator do numero
		  {
			  //se sim devolve o valor de i em string
			  //e recursivamente fatoriza o resto do numero
			  return String.valueOf(i) + " * " + factors(number/i);
		  }
	  }
	  //devolve o numero em string
	  return String.valueOf(number);
  }*/

}

