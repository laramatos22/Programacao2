//Crie um programa que, dado um número inteiro positivo como argumento, escreva todos
//os divisores do número que não o próprio nem o número 1, e, recursivamente, faça o mesmo
//para todos esses divisores.

import static java.lang.System.*;

public class AllDivisors
{
	public static void main (String[] args) {
		if (args.length != 1)
		{
			out.println("Usage: java AllDivisors <number>\n");
			exit(1);
		} else {
		int n = Integer.parseInt(args[0]);
		printDiv(n, 0);
	}
	}
	
	//indentar = afastar (texto) em relação à margem
	static void printDiv (int n, int indentation) {
		for (int ind = 0; ind < indentation; ind++) //indenta (afastar) os numeros
		{
			out.print("   ");
		}
		//imprime o numero que se encontra na função
		out.println(n);
		
		for (int i = n/2; i > 1; i++)
		{
			//se for divisor recursivamente aplica a função outra vez
			if (n%i == 0)
			{
				printDiv(i, indentation+1);
			}
		}
		
	}
}

