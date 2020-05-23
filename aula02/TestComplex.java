import static java.lang.System.*;

public class TestComplex {
  static int b;
  static int c;
  
  public static void main(String[] args) {
	b = Integer.parseInt(args[0]);
	c = Integer.parseInt(args[1]);
	Complex num = new Complex(b, c);
	 
    Complex a = new Complex(5.0, 6.0);

    // Vamos usar métodos do objeto a
    out.println("(" + a.real() + " + " + a.imag() + "i)");
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento =  %2.2f\n", a.arg());
    
    
    // metodos para o objeto num
    out.println("(" + num.real() + " + " + num.imag() + "i)");
    out.println("  parte real = " + num.real());
    out.println("  parte imaginaria = " + num.imag());
    out.println("  modulo = " + num.abs());
    out.printf("  argumento =  %2.2f\n", num.arg());
  }

}
