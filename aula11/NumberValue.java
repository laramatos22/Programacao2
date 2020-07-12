import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;
import p2utils.*;

public class NumberValue {
	
	public static void main (String[] args) throws IOException {
		
		KeyValueList list = new KeyValueList<>();
		
		Scanner scfile = new Scanner(new File("numbers.txt"));
		
		while (scfile.hasNextLine())
		{
			String line = scfile.nextLine();
			int num = Integer.parseInt(line.split(" - ")[0]);
			String numExtenso = line.split(" - ")[1];
			list.set(numExtenso, num);
		}
		scfile.close();
		
		Scanner input = new Scanner(System.in);
		
		do
		{
			String numbers = input.nextLine();
			String [] array = numbers.split(" ");
			double result = 0;
			int intermediate = 0;
			for (int i = 0; i < array.length; i++)
			{
				out.print(array[i] + " ");
				if (list.contains(array[i]))
				{
					int count = (int)list.get(array[i]);
					
					if (intermediate == 0 || count < intermediate)
					{
						result += intermediate;
						intermediate = count;
					} else
					{
						intermediate *= count;
					}
				}
			}
			result += intermediate;
			out.printf("Result -> " + result + "\n");
			
		} while (true);
	}
}

