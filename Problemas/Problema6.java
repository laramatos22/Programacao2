/*  Aula 6 - Recursividade
 *  NMEC: 95228 		NOME: Lara Catarina da Silva Matos
 *  
 *  Descubra o que faz a função F, implementada de forma iterativa. 
 *  Determine o caso base para o problema e a relação de recursividade
 *  de forma a implementar a função H de forma recursiva.
 */
public class Problema6 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -ea Problema6  <n>");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);

        System.out.printf("F(%d) = %f\n", n, F(n));
        System.out.printf("H(%d) = %f\n", n, H(n));
    }

    // O que faz a função F? 
    // Resposta: Somatório de 1/i, com i de 2 a n (n = valor introduzido pelo utilizador)
    public static double F(int n) {
        assert n >= 1;
        double r = 1.0;
        for (int i = 2; i <= n; i++) {
            r += 1.0/i;
        }
        return r;
    }

    // Implementação recursiva da função: sum(i=2)^n
    // caso base: ? n=1 (só passa uma vez na função)
    // relação de recursividade: simples, o resultado é apenas uma só chamada recursiva
    public static double H(int n) {
       assert n>=1;
       double result = 1.0;
       if (n>1)
	   {
		   result = 1.0/n + H(n-1);
	   }
       return result;
    }

}
