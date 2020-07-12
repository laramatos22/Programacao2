import java.io.*;
import java.util.*;

public class CutColumn {
	
	public static void main (String[] args) {
		//get file
		File fin = null;
		
		//get column number
		int col = 0;
		
		//through args
		if (args.length >= 2)
		{
			fin = new File (args[0]);
			try
			{
				col = Integer.parseInt(args[1]);
			}
			catch (NumberFormatException e) //protect against argument that can't be parsable to integer values
			{
				System.err.printf("Usage: java -ea  CutColumn <input file> <column number>");
				System.exit(1);
			}
		}
		
		//or console
		else
		{
			Scanner read = new Scanner (System.in);
			System.out.printf("\nInput file: ");
			String path = read.nextLine();
			fin = new File (path);
			System.out.printf("\nColumn number: ");
			col = read.nextInt();
		}
		
		//verifies file
		verifyFile(fin);
		printCols (fin, col);
		
	}
	
	/**Verifies if the given file exists, is or not a directory, is or not a file and can be read
	*@param f - File to be verified
	*/
	public static void verifyFile (File f) {
		
		//mus exist
		if (!f.exists())
		{
			System.err.printf("ERRO: Input file %s does not exist", f.getName());
			System.exit(1);
		}
		
		//must be a normal file
		if (f.isDirectory())
		{
			System.out.printf("ERRO: Input file %s is a directory", f.getName());
			System.exit(1);
		}
		
		if (!f.isFile())
		{
			System.err.printf("ERRO: Input file %s is not a valid file", f.getName());
			System.exit(1);
		}
		
		//must be readabe
		if (!f.canRead())
		{
			System.err.printf("ERRO: Input file %s can't be read", f.getName());
			System.exit(1);
		}
	} 
	
	/** Printd the contents in the column col for all the lines of the given file
	 * @param f - file to be read
	 * @param col - Number of the column wanted
	 */
	public static void printCols (File f, int col) {
		 //Scanner
		 Scanner in = null;
		 try
		 {
			 in = new Scanner(f);
		 }
		 catch (FileNotFoundException e)
		 {
			 System.err.printf("Input file not accessible. Check if exist and/or are readabe");
			 System.exit(1);
		 }
		 
		 try
		 {
			 //for each line
			 while (in.hasNextLine())
			 {
				 processLine(in.nextLine(), col);
			 }
		 }
		 catch (NoSuchElementException e)
		 {
			 System.err.printf("The input file doesn't have more lines");
			 System.exit(1);
		 }
	}
	
	/**Prints the content in the column col of the given line
	 * @param line - line to be read
	 * @param col - number of the column wanted
	 */
	public static void processLine (String line, int col) {
		 String[] words = line.split(" ", col+1); //there's no need to split the whole string
		 
		 //if the said element exists, prints it (and thar only happens if the line has
		 //at least col elements, ie lines.length >= col)
		 if (words.length >= col)
		 {
			 System.out.println(words[col-1]);
		 } else
		 {
			 System.out.println(" ");
		 }
	}
	
}

