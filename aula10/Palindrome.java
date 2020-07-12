//EXERCICIO 10.1
/*Faça um programa Palindrome que detecte se uma sequência de letras e dı́gitos é um
palı́ndromo (ou seja, se a sequência lida do inı́cio para o fim é igual à sequência lida do
fim para o inı́cio). O programa deve ignorar todos os caracteres que não sejam letras ou
dı́gitos, assim como ignorar a diferença entre maiúsculas e minúsculas. Por exemplo as
frases: "somos" e "O galo nada no lago" são palı́ndromos. Utilize uma pilha e uma fila
para resolver este problema.*/

import java.util.Scanner;
import static java.lang.System.*;

import p2utils.Queue;
import p2utils.Stack;

public class Palindrome {
	
	public static void main (String[] args) {
		
		if (args.length != 1)
		{
			System.out.println("Usage: java -ea Palindrome <text>");
			System.exit(1);
		}
		
		Queue <Character> queue = new Queue<Character>(); //criação de uma fila
		Stack <Character> stack = new Stack<Character>(); //criação de uma pilha
		
		for (int i = 0; i < args[0].length(); i++)
		{
			char d = args[0].charAt(i);
			char c = Character.toLowerCase(d); //colocar todos os algarismos em letra minúscula
			
			if (c != ' ') //caso o caracter seja diferente de um espaço
			{
				stack.push(c); //inserir o caracter c no inicio da pilha (no topo)
				queue.in(c);  //inserir o elemento no fim da fila
			}
		}
		
		String result = "";
		do
		{
			//Comparação entre a devolução do caracter que está no topo da lista
			//com o caracter que está no inicio da fila
			if (stack.top().compareTo(queue.peek()) != 0)
			{
				//caso o caracter seja diferente, nao há palindrome
				result = "not"; 
			}
			stack.pop(); //remove o elemento do topo da pilha
			queue.out(); //retira o elmeento do inicio da fila
		} while (!stack.isEmpty()); //enquanto a pilha contém elementos
		
		out.printf("Test \"%s\" is %s a palindorme\n", args[0], result);
		
		//OUTRA ALTERNATIVA
		
		String frase = "";
		if (args.length == 1)
		{
			frase = args[0];
		} else
		{
			if (args.length == 0 || args[0] != "\"")
			{
				err.println("Usage: java -ea Palindrome \"test\"");
				exit(1);
			} else
			{
				for (int i = 0; i < args.length; i++)
				{
					frase = frase + args[i];
				}
			}
		}
		if (isPalindromo(frase))
		{
			out.println("\"" + frase + "\" é palindromo");
		} else
		{
			out.println("\"" + frase + "\" não é palindromo");
		}
	}
	
	public static boolean isPalindromo(String frase) {
		boolean b = true;
		Queue <Character> fila = new Queue<>();
		Stack <Character> pilha = new Stack<>();
		
		for (int i = 0; i < frase.length(); i++)
		{
			fila.in(frase.charAt(i));
			pilha.push(frase.charAt(i));
		}
		
		while (!fila.isEmpty() || !pilha.isEmpty())
		{
			if (!fila.peek().equals(pilha.top()))
			{
				b = false;
			}
			fila.out();
			pilha.pop();
		}
		return b;
	}
	
}
