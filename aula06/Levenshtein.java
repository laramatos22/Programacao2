import static java.lang.System.*;

public class Levenshtein
{
  public static void main(String[] args) {
    if (args.length != 2) {
      out.println("Uso: java -ea Levenshtein <palavra1> <palavra2>");
      exit(1);
    }

    int d = distancia(args[0], args[1]);
    out.printf("\"%s\" <-> \"%s\" = %d\n", args[0], args[1], d);
  }
  
  public static int distancia (String a, String b) {
	  int[] op = new int[b.length() + 1];
	  for (int j = 0; j < op.length; j++)
	  {
		  op[j] = j;
	  }
	  for (int i = 1; i <= a.length(); i++)
	  {
		  op[0] = i;
		  int novo = i - 1;
		  for (int j = 1; j <= b.length(); j++)
		  {
			  int opj = Math.min(1 + Math.min(op[j], op[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? novo : novo + 1);
			  novo = op[j];
			  op[j] = opj;
		  }
		  
	  }
	  return op[b.length()];	  
	   
  }
  
  static {
	  boolean ea = false;
	  assert ea = true; //assert with a side-effect
	  if (!ea)
	  {
		  err.println("Uso: java -ea Levenshtein <palavra1> <palavra2>");
		  exit(1);
	  }
  }

}
