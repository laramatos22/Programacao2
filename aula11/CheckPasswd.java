import java.util.*;
import java.io.*;

import p2utils.*;

public class CheckPasswd {

	public static void main (String[] args) throws IOException {
		
		KeyValueList<String> kl = new KeyValueList<String>();
		Scanner sf = new Scanner (new File ("senhas.txt"));
		
		//Enqto o ficheiro tiver usernames e passwords
		while (sf.hasNextLine())
		{
			String line = sf.nextLine();
			//o que está à esquerda do espaço é o username
			String user = line.split(" ")[0];
			//o que está à direita do espaço é a password
			String password = line.split(" ")[1];
			//Outra Alternativa
			//~ String[] array = line.split(" ");
			//~ String user = array[0];
			//~ String password = array[1];
			//set(): criação de um par (key, value) como (username, password)
			kl.set(user, password);
			//kl.set(sf.next(), sf.next());
		}
		//Close sf
		sf.close();
		
		//Open again sf
		sf = new Scanner (System.in);
		do{
			try{
				//Pedido de username e password
				System.out.print("Username: ");
				String usernameInput = sf.next();
				System.out.print("Password: ");
				String passwordInput = sf.next();
				
				//get(): devolve o valor associado à chave dada
				//Neste caso, devolve a password associada ao username
				if (kl.get(usernameInput).equals(passwordInput))
				{
					System.out.println("Autenticação válida!");
				} else
				{
					System.out.println("Autenticação inválida!");
				}
			}
			catch (Exception e)
			{
				System.out.println("Autenticação inválida");
				System.exit(1);
			}
		
			System.out.print("Username: ");
			String usernameInput = sf.next();
			System.out.print("Password: ");
			String passwordInput = sf.next();
		
			//get(): devolve o valor associado à chave dada
			//Neste caso, devolve a password associada ao username
			if (kl.get(usernameInput).equals(passwordInput))
			{
				System.out.println("Autenticação válida!");
			} else
			{
				System.out.println("Autenticação inválida!");
			}
			
	} while(true);
	}

}
 
