import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class PhoneCalls
{
  //...
	//Dicionario em q o valor está num dicionario
	static HashTable<KeyValueList> calls = new HashTable<>(1000);
	
	static HashTable<String> hash = new HashTable<>(1000);
	
	public static void main(String[] args) throws IOException {
		for(String arg : args) {
			//.nms - informações de numero e nome
			if (arg.contains(".nms"))
			{
				//Scanner para leitura dos ficheiros terminados em .nms
				Scanner read = new Scanner(new File(arg));
				while (read.hasNextLine())
				{
					//Separação da linha com o espaço
					String[] line = read.nextLine().split(" ");
					
					//line[0] - numero
					//line[1] - 1º nome da pessoa + espaço + line[2] - apelido da pessoa
					//hash.set() - inserir novo par (numero, nome) à hashTable hash
					hash.set(line[0], line[1] + " " + line[2]);
				}
			}
			else if (arg.contains(".cls"))
			{
				//Scanner para leitura dos ficheiros terminados em .cls
				Scanner scf = new Scanner (new File (arg));
				while (scf.hasNextLine())
				{
					//Separação da linha com o espaço
					String[] line = scf.nextLine().split(" ");
					//numero do remetente
					String remetente = line[0];
					//numero do recetor
					String recetor = line[1];
					
					//Se a hash contém a key (numero) da linha 0
					if(hash.contains(line[0])) 
						//remetente é o valor (nome) desse numero com o uso da função get() para
						//devolver o valor associado à key
						remetente = hash.get(line[0]);
					
					//Se a hash contém a key (numero) da linha 1
					if(hash.contains(line[1]))
						//recetor é o valor (nome) desse numero com o uso da função get() para
						//devolver o valor associado à key
						recetor = hash.get(line[1]);
					
					//Se na KeyValueList contem o nome da pessoa que tem o numero
					//Se na KeyValueList calls da HashTable contém a linha 0
					if (calls.contains(line[0]))
					{
						//Criação da KeyValueList chamadas que devolve o valor (nome) da calls
						KeyValueList<String> chamadas = calls.get(line[0]);
						//inserção do par (numero, valor) na KeyValueList chamadas
						chamadas.set(line[2], line[1]);
						//Inserção do valor das chamadas na HashTable calls
						calls.set(line[0], chamadas);
					} else //caso nao tem o numero associado ao nome
					{
						//Criação da KeyValueList chamadas
						KeyValueList<String> chamadas = new KeyValueList<>();
						//inserção do par (numero, valor) na KeyValueList chamadas
						chamadas.set(line[2], line[1]);
						//Inserção do valor das chamadas na HashTable calls
						calls.set(line[0], chamadas);
					}
					//Print
					System.out.printf("%s to %s (%s seconds)\n",remetente,recetor, line[2]);
				}
			}
		}
	}

}

