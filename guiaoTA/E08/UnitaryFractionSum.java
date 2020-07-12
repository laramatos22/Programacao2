/*Crie um programa que dado um número racional pertencente ao intervalo aberto entre
zero e um, e expresso como uma fração (N/D), escreva essa fração como uma soma de
fracções unitárias com denominadores distintos. Uma fração unitária é uma fração em
que o numerador é igual a um. O programa a desenvolver deve fazer uso de um algoritmo
recursivo.*/

import static java.lang.System.*;

public class UnitaryFractionSum
{
	public static void main (String[] args) {
		if (args.length != 2)
		{
			out.println("Usage: java -ea UnitaryFactionSum <Num> <Den>");
			exit(1);
		}
		try
		{
			int num = Integer.parseInt(args[0]);
			int den = Integer.parseInt(args[1]);
			out.printf("%s/%d = %s\n", num, den, fractions(num, den));
		}
		catch (NumberFormatException e)
		{
			out.printf("ERROR: one of the arguments (%s, %s) is not an integer number!\n", args[0], args[1]);
			exit(1);
		}
	}
	
	static String fractions (int num, int den) {
		//Calculo da unitary fraction
		//Exemplo: Math.ceil(125.8) = 126.0
		int d = (int)Math.ceil((float)den/(float)num);
		
		//Calcular a diferença entre frações
		num = num*d-den;
		den = den*d;
		if (num%den == 0)
		{
			return "1"+d;
		} else
		{
			return "1/"+d+" + "+fractions(num, den);
		}
	}
}

