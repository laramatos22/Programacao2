/*Calculadora com as quatro operações aritméticas básicas que funcione com
a notação pós-fixa (Reverse Polish Notation). Nesta notação os operandos são colocados
antes do operador. Assim 2 + 3 passa a ser expresso por 2 3 +. Esta notação dispensa a
utilização de parênteses e tem um implementação muito simples assente na utilização de
uma pilha de números reais. Sempre que aparece um operando (número) ele é carregado
para a pilha. Sempre que aparece um operador, são retirados os dois últimos números da
pilha e o resultado da operação é colocado na pilha. Se a pilha não tiver o número de
operandos necessário, então há um erro sintático na expressão.
O programa deve ler os operandos e os operadores do standard input, separados por
espaços.*/

import java.util.Scanner;
import p2utils.*;

public class RPNCalculator {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Stack<Double> stack = new Stack<Doubel>();
		double result = 0;
		while (sc.hasNext())
		{
			if (sc.hasNextDouble())
			{
				stack.push(sc.nextDouble());
			} else
			{
				String operand = sc.next();
				if (!operand.equals("*") && !operand.equals("/") && !operand.equals("+") && !operand.equals("-"))
				{
					out.println("ERROR: invalid operand!");
					exit(0);
				}
				if (stack.isEmpty())
				{
					out.println("ERROR: two operands missing!");
					exit(2);
				}
				
				double a = stack.top();
				stack.pop();
				assert !stack.isEmpty(): "ERROR: onde operand missing!";
				double b = stack.top();
				stack.pop();
				if (operand.equals("*"))
				{
					result = b * a;
				}
				else if (operand.equals("/"))
				{
					result = b / a;
				}
				else if (operand.equals("+"))
				{
					result = b + a;
				}
				else if (operand.equals("-"))
				{
					result = b - a;
				}
				stack.push(result);
			}
			
			out.printf("Stack: %s \n", stack.reverseToString());
			
		}
		
	}
}
