import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;

public class SortInts
{
	public static SortedListInt intList;
	
//SortInts que leia números inteiros de um
//ou mais ficheiros e, no final, imprima todos os números lidos por ordem. Os nomes de
//ficheiros serão passados como argumentos ao programa. O ficheiro poderá conter outras
//palavras: as que não representem inteiros devem ser ignoradas.

  public static void main(String[] args) throws IOException {
    //...
	//~ String[] names = new String[args.length];
	//~ File[] file = new File[args.length];
	//~ SortedListInt values = new SortedList();
	//~ for (int i = 0; i < args.length; i++)
	//~ {
		//~ names[i] = args[i];
		//~ file[i] = new File(names[i]);
	//~ }
	
	//~ //inserção começa
	//~ for (int i = 0; i < file.length; i++)
	//~ {
		//~ Scanner read = new Scanner(file[i]);
		//~ while (read.hasNextLine())
		//~ {
			//~ values.insert(read.nextInt());
		//~ }
		//~ read.close();
	//~ }
	
	//~ if (values.isSorted())
	//~ {
		//~ values.sort();
	//~ } else
	//~ {
		//~ values.sort();
		//~ values.print();
	//~ }
	
	assert args.length >0 : "Usage: java SortInts file.txt file1.txt ...";
	File[] files = new File[args.length];
	intList = new SortedListInt();
	
	int i=0;
	//leitura de um array de ints do file
	for (File f: files)
	{
		f = new File(args[i]);
		scanFile(f);
		i++;
		if (!f.canRead())
		{
			continue;
		}
		if (!f.exists())
		{
			continue;
		}
		if (!f.isDirectory())
		{
			continue;
		}
	}
	
	assert files.length > 0 : "Error: No files found";
	
	printList(intList);
	
  }
  
  public static void scanFile(File f) {
	  try
	  {
		  Scanner fc = new Scanner(f);
		  String n="";
		  
		  while (fc.hasNext())
		  {
			  n = fc.next();
			  try
			  {
				  int n1 = Integer.parseInt(n);
				  intList.insert(n1);
			  }
			  catch (NumberFormatException e)
			  {
				  continue;
			  }
		  }
		  fc.close();
		} 
	catch (FileNotFoundException e)
	{
		err.println(e);
	}
  }
  
  public static void printList (SortedListInt l) {
	  if (l.size() > 0)
	  {
		  System.out.println(l.first());
		  l.removeFirst();
		  printList(l);
	  } else
	  {
		  return;
	  }
  }

}


