// ex11.java
//~ Crie uma calculadora simples que leia (do dispositivo de entrada) operações matemáticas
//~ como
//~ 12.3 + 7.2
//~ e escreva o resultado respectivo (19.5 neste exemplo).
//~ As operações serão sempre do género <número> <operador> <número>, com as três
//~ partes separadas por espaços ou em linhas diferentes. Implemente as quatro operações
//~ básicas usando os operadores +, -, * e /. Note que o operador é uma palavra (string) que
//~ contém apenas um sı́mbolo. Se for introduzido um operador inválido, deve escrever uma
//~ mensagem apropriada para o dispositivo de saı́da de erros (System.err).

import java.util.*;

public class ex11 {
	
	static Scanner calc = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		//String leitura;
		double a = calc.nextDouble();
		String op = calc.next();
		double b = calc.nextDouble();
		
		switch (op)
		{
			case "+":
					System.out.println(a + b);
				break;
			
			case "-":
					System.out.println(a - b);
				break;
				
			case "*":
					System.out.println(a * b);
				break;
			
			case "/":
					System.out.println(a / b);
				break;
				
			default:
					System.err.println("O operador nao é válido");
		}
		
	}
}
