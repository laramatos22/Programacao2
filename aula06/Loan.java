import static java.lang.System.*;

public class Loan {
	
	static double juro;
	static int P;
	
	public static void main (String[] args) {
		if (args.length != 4)
		{
			out.println("USO: java -ea Loan n M T P");
		}
		
		try //verifica se todos os argumentos sao válidos
		{
			for(String a : args) {
				Integer.parseInt(a);
			}
		}
		catch (Exception e)
		{
			out.println("USO: java -ea Loan n M T P");
			exit(1);
		}
		
		int n = Integer.parseInt(args[0]);  //divida ao fim de n meses
		int M = Integer.parseInt(args[1]);  //empréstimo de M euros
		int T = Integer.parseInt(args[2]);  //taxa de juro de T%
		P = Integer.parseInt(args[3]);      //prestação de P euros ao fim de cada mês
		
		double div = (double)M;
		juro = 1 + (double)T/100;
		
		//iterativo
		for (int i = 1; i <= n; i++)  //começa no primeiro mês e vai até n meses
		{
			div = div*juro - P; //na divida retira-se as prestações já pagas e div = à dívida ainda nao paga
		}
		out.printf("(iterativo) d(%d) %.5f\n", n, div);
		
		//recursivo
		div = divida(M, n);
		out.printf("(recursivo) d(%d) = %.5f\n", n, div);
		
	}
	
	public static double divida (int M, int n) {
		if (n == 0) //caso base (ainda nao pagou nada, deve todas as prestações)
		{
			return M;
		}
		return divida (M, n-1)*juro - P;  //conforme vai pagando, retira-se um mês de prestação da dívida
	}
	
	static {
		boolean ea = false;
		assert ea = true;
		if (!ea)
		{
			err.println("USO: java -ea Loan n M T P");
			exit(1);
		}
	}
}

