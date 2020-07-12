import java.util.*;
import static java.lang.System.*;

public class MDC {
	
	public static void main (String[] args) {
		
		assert args.length == 2 : "Argumentos em falta. Usage: java - ea MDC <a> <b>";
		int a = 0;
		int b = 0;
		
		try
		{
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}
		
		assert a > 0 && b > 0 : "a e b têm que ser números positivos";
		
		System.out.println("MDC(" + a + "," + b + ") = " + calcMDC(a,b));
		
	}
	
	public static int calcMDC(int a, int b) {
		if (b == 0)
		{
			return a;
		}
		return calcMDC (b, a%b);
	}
}

