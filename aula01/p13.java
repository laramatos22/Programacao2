import static java.lang.System.*;
import java.util.Scanner;

public class p13 {
  public static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    int n;
    while (true) {
      out.print("N? ");
      n = in.nextInt();
      if (n > 0) break;
      err.println("ERROR: invalid number!");
    }

    String verb = isPrime(n)? "is" : "is not";
    out.printf("Number %d %s prime\n", n, verb);
  }

  public static boolean isPrime(int n) {
    // Complete a função para verificar se n é primo...
    
    boolean primo;
	
	if (n%2 == 0 || n%3 == 0 || n%4 == 0 || n%5 == 0 || n%7==0)
		{
			if (n==2 || n==3 || n==5 || n==7)
			{
				primo = true;
			} else
			{
				primo = false;
			}
		} else
		{
			primo = true;
		}
	return primo;
  }
}

