import java.util.*;
import java.io.*;

public class ex17 {
	
	static Scanner rd = new Scanner(System.in);
	static File fin;
	static File fout; 
	
	public static void main (String[] args) throws IOException {
		fin = new File("texto.txt");
		fout = new File("newTexto.txt");
		verif();
		copyFile();
	}
	
	public static void verif()
	{
		if (!fin.exists())
		{
			System.out.println("ERRO: ficheiro " + fin.getName() + " não existe");
			System.exit(2);
		}
		if (!fin.canRead())
		{
			System.out.println("ERRO: ficheiro " + fin.getName() + " não pode ser lido");
			System.exit(3);
		}
		if (fout.exists())
		{
			System.out.println("ERRO: ficheiro " + fout.getName() + "já existe");
			System.exit(4);
		}
	}
	public static void copyFile() throws java.io.IOException
	{
		Scanner scf  = new Scanner(fin);
		PrintWriter pw = new PrintWriter(fout);
		
		while (scf.hasNextLine())
		{
			pw.println(scf.nextLine());
		}
		scf.close();
		pw.close();
	}		
		
		
}
