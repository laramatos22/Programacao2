/*O ficheiro numbers.txt contém uma lista de números e respetivas traduções por extenso
em lı́ngua inglesa. Fazendo uso de um dicionário, escreva um programa TranslateNumbers
que traduza num texto, todas as ocorrências de números por extenso pelo respectivo valor
numérico, mantendo as restantes palavras.*/

import java.util.*;
import java.io.*;
import p2utils.*;

public class TranslateNumbers {
	
	public static void main (String[] args) throws IOException {
		
		//Scanner de leitura do ficheiro numbers.txt
		Scanner scf = new Scanner (new File("numbers.txt"));
		
		//Criação de uma KeyValueList dictionary
		KeyValueList dictionary = new KeyValueList();
		
		while (scf.hasNextLine())
		{
			String line = scf.nextLine();
			if (line.length() > 0)
			{
				//Criação de um array de strings
				String[] parts = line.split(" - ");
				
				//A parte direita é o número por extenso com letras minúsculas
				String keys = parts[1].toLowerCase();
				
				//A parte esquerda é o valor em numérico
				int value = Integer.parseInt(parts[0]);
				
				//criação de um par (key, element), neste caso, (numero, extenso)
				dictionary.set(keys, value);
			}
		}
		//Close sfc
		scf.close();
		
		//Open again scf
		Scanner sc = new Scanner(System.in);
		do
		{
			//Criação de um input
			String input = sc.nextLine();
			
			//Criação de um array com todos os argumentos do input
			String[] array = input.split(" ");
			
			//Percorrer todos os argumentos i do input
			for (int i = 0; i < array.length; i++)
			{
				//se na KeyValueList dictionary conter uma chave i do array
				if (dictionary.contains(array[i]))
				{
					//Print do valor correpondente a essa chave através da função get
					System.out.printf(" " + dictionary.get(array[i]));
				} else //senão
				{
					//Print apenas da chave i do array
					System.out.printf(" " + array[i]);
				}
			}
			
		} while (true); //works until ctrl-d / ctrl-c /ctrl-z
		
	}
}

