import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class ListRec {
	
	public static void main (String[] args) {
		
		assert args.length == 1 : "Falta de argumentos! Usage: java -ea ListRec <directory>";
		
		File file = new File (args[0]);
		
		printDirConteudo (file);
	}
	
	
	public static void printDirConteudo (File f) {
		
		if (f.isDirectory())
		{
			File[] list = f.listFiles();
			
			for (int i = 0; i < list.length; i++)
			{
							
				printDirConteudo(list[i]);
			}
			
		}
		System.out.println(f.getPath());
	}
	
}

