import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class CityTraveler
{
  //...
    
    //Criar uma hashTable
    static HashTable<LinkedList<String>> info = new HashTable<>(20);
    
	public static void main(String[] args) throws IOException {
		
		if (args.length == 0)
		{
			System.err.println("Usage: java -ea CityTraveler <file1> <file2> ...");
			System.exit(1);
		}
		
		for(String city : args) {
			Scanner read = new Scanner(new File(city));
			while (read.hasNextLine())
			{
				String person = read.nextLine();
				
				//Caso a hashTable nao contenha o nome da pessoa
				if (!info.contains(person))
				{
					//Criação de uma lista
					LinkedList<String> list = new LinkedList<String>();
					
					//inserir elemento (valor) no final da lista
					list.addLast(city);
					
					//Atualização ou inserção de um novo par (chave, valor) na hashTable
					//key - person, valor - list q contem a lista das cidades q foram visitadas por cada pessoa
					info.set(person, list);
				}
				//Caso já tenha o nome da pessoa na hashTable
				else
				{
					//Criação de uma linked list que devolve o nome das cidades 
					//associadas ao nome da pessoa da hashTable
					LinkedList<String> list = info.get(person);	
					
					//inserir elemento (valor - cidade) no final da lista
					list.addLast(city);
					
					//Atualização ou inserção de um novo par (chave, valor) na hashTable
					//key - person, valor - list q contem a lista das cidades q foram visitadas por cada pessoa
					info.set(person, list);
				}
			}
		}
		//impressão de resultados
		printInfo();
	}
	
	static void printInfo() {
		//devolver um vetor com todas as chaves existentes
		String[] keys = info.keys();
		for(String name : keys) {
			out.printf("%-15s : %s\n", name, info.get(name).toString(""," ", ""));
		}
	}

}

