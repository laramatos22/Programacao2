import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class FindFile {
	
	public static void main (String[] args) {
			
		assert args.length == 2: "Argumentos em falta. Usage: java -ea FindFile <FileName>";
		String path = args[1];
		File dir = new File(path);
		findFileInDirectory(dir, args[0]);
		
	}
	
	public static void findFileInDirectory (File f, String pattern) {
		
		if (f.isFile() && f.getName().indexOf(pattern) != -1)
		{
			System.out.println(f.getPath());
		}
		if (f.isDirectory())
		{
			File[] dir = f.listFiles();
			for (File file : dir)
			{
				findFileInDirectory(file, pattern);
			}
			
		} else if (f.isDirectory())
		{
			System.out.printf("ERRO: o diretorio %s nao existe!\n", f.getName());
		}
		
	}
}


