//~ Pretende-se implementar um programa para o jogo “Advinha o número”. Neste jogo, o
//~ programa escolhe aleatoriamente um número secreto num determinado intervalo [min, max]
//~ e o objectivo é adivinhar esse número com o mı́nimo de tentativas. Por cada tentativa feita,
//~ o jogo deve indicar se acertou (e terminar), ou se é menor ou maior do que o número secreto.
//~ Implemente o comportamento essencial do jogo na classe GuessGame respeitando a se-
//~ guinte interface pública. Sempre que possı́vel, use instruções assert para tornar explı́citos
//~ os contratos dos métodos, particularmente as suas pré-condições.

import static java.lang.System.*;

public class GuessGame {

  private int secretNumber; // to hold the secret
  //...
  //~ Um construtor com dois argumentos (min e max) que inicializa o jogo com um número
//~ aleatório no intervalo [min,max] (que não poderá ser vazio). Pode utilizar o método
//~ Math.random() ou a classe Random para gerar o número aleatório.
  private int min, max, attempts, n;

  public GuessGame(int min1, int max1) {
    //...
    assert (min1 != max1);
    assert (min1 < max1);
    this.min = min1;
    this.max = max1;
    this.attempts = 0;
    this.secretNumber = (int)(Math.random()*max1)-min1+1;
  }

  //~ Dois métodos inteiros – min() e max() – que indiquem os limites do intervalo definido
  //~ para o objecto.
  public int min() {
    //...
    return min;
  }

  public int max() {
    //...
    return max;
  }
  
  //~ Um método booleano – validAttempt – que indique se um número inteiro está dentro
  //~ do intervalo definido.
  public boolean validAttempt(int n) {
    //...
    boolean expressao = n>=min;
    expressao = expressao && n<=max; 
    return expressao;
  }
  
  //Um método booleano – finished() – que indique se o segredo já foi descoberto.
  public boolean finished() {
    //...
    return n == secretNumber;
  }
  
  //~ Dois métodos booleanos – attemptIsHigher() e attemptIsLower() – que indiquem
  //~ se a última tentativa foi, respectivamente, acima ou abaixo do número secreto.
  public boolean attemptIsHigher() {
    //...
    return n > secretNumber;
  }

  public boolean attemptIsLower() {
    //...
    return n < secretNumber;
  }
  
  //~ Um método – play – que registe uma nova tentativa para adivinhar o número secreto.
//~ Este método só deverá aceitar tentativas que estejam dentro do intervalo definido e
//~ só enquanto o jogo não tiver terminado ou seja, enquanto o segredo não tiver sido
//~ descoberto.
  public void play(int n2) {
    //...
    n = n2;
    assert validAttempt(n);
    if (attemptIsLower())
	{
		System.out.println("O numero secreto é maior");
	} else if (attemptIsHigher())
	{
		System.out.println("O numero secreto é menor");
	}
	attempts++;
  }
  
  //~ Um método inteiro – numAttempts() – que indique o número de tentativas (jogadas)
  //~ já realizadas.
  public int numAttempts() {
    //...
    return attempts;
  }

  /**
   * Simple tests of the GuessGame class.
   * This method tests the functionality of the GuessGame class.
   * It should be used by the programmer to test and debug the class.
   * It is not meant to be called in client programs.
   *
   * To run from the command line, use:
   *   java -ea GuessGame
   */
  public static void main(String[] args) {
    requireEA();
    out.println("Starting tests.");
    GuessGame game = new GuessGame(1, 10);
    // initial tests:
    assert !game.finished() : "game should not be finished yet";
    assert game.min() == 1;
    assert game.max() == 10;
    assert game.numAttempts() == 0 : "there should be no attempts yet";
    for(int i = -10; i <= 20; i++) {
      assert game.validAttempt(i) == (i >= 1 && i <= 10);
    }
    // trying all wrong answers:
    int nplay = 0; // how may times play was called
    for(int n = 1; n <= 10; n++) {
      if (n != game.secretNumber) {
        game.play(n); // make a wrong guess
        nplay++;
        assert game.numAttempts() == nplay;
        assert !game.finished() : "game should not be finished yet";
        assert (n < game.secretNumber) == game.attemptIsLower();
        assert (n > game.secretNumber) == game.attemptIsHigher();
      }
    }
    // make the right guess:
    game.play(game.secretNumber);
    nplay++;
    assert game.finished() : "game should be finished now";
    assert game.numAttempts() == nplay;
    out.println("No error detected!");
  }

  /** Check if program is being run with -ea, exit if not. */
  static void requireEA() {
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) {
      err.println("This program must be run with -ea!");
      exit(1);
    }
  }

}

