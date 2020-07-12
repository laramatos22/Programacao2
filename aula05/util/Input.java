// 93418 - Beatriz Agante Almeida
// 95228 - Lara Catarina Silva Matos

package util;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

/** This class contains methods for robust interactive input. */
public class Input {
  private static Scanner input = new Scanner(System.in);

  /** Get a double value from a line read from standard input.
   * Should repeat until a valid double value is actually read.
   * @param prompt the message to prompt for input.
   * @return the value read from input.
   */
  public static double getDouble(String prompt) {
    double r = 0;
    
    boolean ler = false;
    while (!ler)
	{
		try
		{
			err.print(prompt);
			String line = input.nextLine();
			r = Double.parseDouble(line.trim());
			ler = true;
			
		}
		catch (NumberFormatException e)
		{
			System.out.println("Introduzir um valor válido");
		}
	}
    
    return r;
  }

  /** Get a double value within a given range, from standard input.
   * Should repeat until a valid double value is actually read.
   *
   * @param prompt the message to prompt for input.
   * @param min minimum value allowed.
   * @param max maximum value allowed.
   * Precondition: min<=max
   * @return the value read from input.
   * Postcondition: result in in [min, max].
   */
  public static double getDouble(String prompt, double min, double max) {
    // Add an assertion to test the precondition...
    double r = 0;
    assert (min <= max): "O valor mínimo não pode ser maior do que o valor máximo";  
    while (true) 
    {
		  try
		  {
			  err.print(prompt);
			  String line = input.nextLine();
			  r = Double.parseDouble(line.trim());
			  if (min <= r && r <= max) break;
			  err.printf("Value must be in range [%f, %f]\n", min, max);
		  }
		  catch (NumberFormatException e)
		  {
			  err.printf("Formato inválido\n");
		  } 
    }
    assert min <= r && r <= max : "Postcondition"; 
    return r;
  }

}
