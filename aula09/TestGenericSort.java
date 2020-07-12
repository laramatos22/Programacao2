// This program should use the generic mergeSort method in p2utils.Sorting
// to sort its string arguments.

//...
import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;

import static p2utils.Sorting.*;

public class TestGenericSort {
	
	static final Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
		//1º array com as palavras inseridas em argumentos
		String[] nomes = args;
		
		//clone para uma cópia do array inicial
		String[] ordem = nomes.clone();
		
		//Sort do 1º array
		mergeSort(nomes, 0, nomes.length);
		
		//Imprimir resultado
		System.out.println(Arrays.toString(nomes));
		
		//Os arrays têm q ser iguais no final do programa
		Arrays.sort(ordem);
		assert Arrays.equals(nomes, ordem);
	}
	
}

