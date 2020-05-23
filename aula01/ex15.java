import java.util.*;

public class ex15 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		double num, soma = 0, media;
		int count = -1;
		
		do
		{
			System.out.print("Número: ");
			num = sc.nextDouble();
			soma += num;
			count++;
		} while (num > 0);
			
		media = soma / count;
		
		System.out.printf("Soma = " + soma + "\n");
		System.out.printf("Média = " + media);
		
	}
}

