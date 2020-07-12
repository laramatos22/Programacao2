import static java.lang.System.*;

public class Fibonacci {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("USO: java -ea Fibonacci N [N ...]");
      exit(1);
    }

    // Alguns testes:
    assert fibonacci(0) == 0;
    assert fibonacci(1) == 1;
    assert fibonacci(2) == 1;
    assert fibonacci(5) == 5;

    for(int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      long time = nanoTime();  // System.nanoTime() gives the time in ns.
      int f = fibonacci(n);
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
      
      time = nanoTime();
      f = fibonacciB(n);
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
    }
  }
  
  //ALINEA A
  public static int fibonacci(int n) {
    assert n >= 0;
    if (n == 0)
	{
		return 0;
	} else if (n == 1)
	{
		return 1;
	} else
	{
		return (fibonacci(n-1) + fibonacci(n-2));
	}
  }
  
  //ALINEA B
  private static int[] fib = new int[50];
  
  public static int fibonacciB (int n) {
	  assert n>=0;
	  assert n < fib.length;
	  
	  if (n<=1)
	  {
		  fib[n] = n;
	  } else if (fib[n] == 0)
	  {
		  fib[n] = fibonacciB(n-2) + fibonacciB(n-1);
	  }
	  return fib[n];
  }

}
