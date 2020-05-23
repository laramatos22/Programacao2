/*
 Escreva um programa que determine a nota final N F de um aluno de Programação 2 na
época normal. O programa deverá pedir as notas dos vários momentos de avaliação e
calcular e apresentar as notas das componentes e a nota final. A fórmula de cálculo está
no guião da unidade curricular.
*/

import java.util.*;

public class ex12 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		double atp1, ap1, atp2, ap2;
		double ctp, cp;
		double nf;
		
		System.out.print("ATP1: ");
		atp1 = sc.nextDouble();
		System.out.print("AP1: ");
		ap1 = sc.nextDouble();
		System.out.print("ATP2: ");
		atp2 = sc.nextDouble();
		System.out.print("AP2: ");
		ap2 = sc.nextDouble();
		
		ctp = (atp1 + atp2) / 2;
		cp = (ap1 + ap2) / 2;
		
		nf = (0.3 * ctp) + (0.7 * cp);
		
		if (ctp < 6.5 || cp < 6.5)
		{
			System.out.println("Aluno reprovado!");
		} else
		{
			System.out.println("Aluno aprovado!");
		}
		
	}
}
