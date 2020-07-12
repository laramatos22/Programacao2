import java.io.*;
import static java.lang.System.*;

public class ListDir {
	
	public static void main (String[] args) {
	
		File folder = null;
		
		try
		{
			folder = openFolder(args); //opens the specified folder
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			out.println("Invalid number of arguments. Exiting program.");
			exit(1);
		}
		catch (NullPointerException e)
		{
			out.println("Invalid arguments.");
			exit(1);
		}
		File[] files = folder.listFiles(); //creates an array of type File (represents the folder)
		out.println();
		for (File file : files) //will iterate through every file in the specified directory
		{
			out.print(file.getName()+"               ");
			if (file.isDirectory())
			{
				out.print("DIR");
			}
			if (file.canRead())
			{
				if (if.isDirectory())
				{
					out.print(",");
				}
				out.print("READ");
			}
			if (file.canWrite())
			{
				if (file.isDirectory() || file.canRead())
				{
					out.print(",");
				}
				out.print("WRITE");
			}
			out.println(")");
		}
	}
	
	static File openFolder(String[] args) {
		File folder = null;
		if(args.length == 1) folder = new File (args[0]); //considers a specified directory
		else if(args.length == 0) folder = new File("."); //considers the current directory
		if (!folder.exists()) //check if the path given is a valid path to a directory
		{
			out.println("Invalid folder path. Exiting program");
			exit(1);
		}
		return folder;
	}
}

