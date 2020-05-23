import java.util.*;

public class ex21Complex {
	
	final static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		
		//Complex21 a = new Complexo21(5.0, 6.0);
		
		int real, im;
		
		if (args.length < 2)
		{
			System.out.print("Real: ");
			real = sc.nextInt();
			System.out.print("\nImaginário: ");
			im = sc.nextInt();
		} else
		{
			real = Integer.parseInt(args[0]);
			im = Integer.parseInt(args[1]);
		}
		
		//Usar métodos de 'a'
		System.out.println("(" + real + " + " + im + "i)");
		System.out.println("Parte real = " + real);
		System.out.println("Parte imaginária = " + im);
		System.out.println("Módulo = " + Math.sqrt (real * real + im * im));
		System.out.println("Fase = %2.2f\n", Math.atan2(im, real));
		
	}
}

