import static java.lang.System.*;
import java.util.*;

public class reverseString {
	
	public static void main (String[] args) {
		for (int i = 0; i < args.length; i++)
		{
			System.out.println(invertString(args[i]));
			//OU System.out.println(reverseString(args[0]));
			System.out.println("\n");
		}
	}
	
	public static String invertString(String str) {
		if (str.length() <= 1)
		{
			return str;
		}
		return str.charAt(str.length() - 1) + invertString(str.substring(0, str.length() - 1));
	}
	
	// OU
	
	//~ public static String reverseString(String s) {
		//~ if (s.isEmpty())
		//~ {
			//~ return s;
		//~ }
		//~ return reverseString(s.substring(1)) + s.charAt(0);
	//~ }
}

