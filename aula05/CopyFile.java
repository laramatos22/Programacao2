import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class CopyFile {
	
	final static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) throws IOException {
	
		if (args.length!=2)
		{
			out.println("Usage: java -ea CopyFile <source-file> <destination-file>");
			exit(1);
		}
		
		File fin = new File(args[0]);
		File fout = new File(args[1]);
		
		if (!fin.exists())
		{
			System.err.print("ERRO: ficheiro de entrada " + fin);
			exit(10);
		}
		
		if (fin.isDirectory())
		{
			err.println("ERRO: o ficheiro input " + args[0] + " é um diretório!!");
			exit(11);
		}
		
		if (!fin.canRead())
		{
			err.println("ERRO: não tem permissão para ler o ficheiro " + args[0] + " !!");
			exit(12);
		}
		
		//checking diretório de output
		String parentDir = fout.getParent();
		if (parentDir == null)
		{
			parentDir = ".";
		}
		File parent = new File (parentDir);
		
		if (!parent.exists())
		{
			err.println("ERRO: diretório output " + parentDir + "não existe!!");
		}
		
		copyFile(fin, fout);
	}
	
	public static void copyFile(File fin, File fout) {
		assert fin != null && fout != null;
		
		try
		{
			Scanner scf = new Scanner(fin);
			PrintWriter pwf = new PrintWriter(fout);
			while (scf.hasNextLine())
			{
				pwf.println(scf.nextLine());
			}
			pwf.close();
			scf.close();
		}
		catch (IOException e)
		{
			err.println("ERRO: cópia nao efetuada");
			exit(2);
		} 
	}
}

