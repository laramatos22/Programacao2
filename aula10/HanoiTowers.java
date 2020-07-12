import static java.lang.System.*;
import java.util.Scanner;
import p2utils.Stack;

public class HanoiTowers
{
  // ...
  //Numero de movimentos
  private int numOfMoves = 0;
  //A classe deve incluir três campos do tipo pilha, um para cada torre.
  //Criação de 3 pilhas
  private Stack<Integer> TA;
  private Stack<Integer> TB;
  private Stack<Integer> TC;
  private int n;
  
  //Construtores
  //O construtor deve iniciar a primeira torre com n discos e manter as outras duas vazias.
  public HanoiTowers (int n) {
	  TA = new Stack<Integer>();
	  TB = new Stack<Integer>();
	  TC = new Stack<Integer>();
	  this.n = n;
	  for (int i = n; i >= 1; i--)
	  {
		  putDisk(TA, n);
	  }
  }
  
  public void putDisk (Stack<Integer> origem, int disk) {
	  //push: inserir (empilhar) um disco disk no topo da pilha
	  origem.push(disk);
  }
  
  //Imprimir movimentos
  /*Um método, a ser chamado após cada movimento, que mostre o estado atual do
  problema, incluindo os conteúdos das três torres.*/
  public void printInfo() {
	  //Imprimir os elementos nas stacks correspondentes
	  out.printf("Depois de %d movimentos:\n", numOfMoves);
	  out.println("TA: " + TA.reverseToString());
	  out.println("TB: " + TB.reverseToString());
	  out.println("TC: " + TC.reverseToString());
  }
  
  //inicio
  //O método solve deve aplicar um algoritmo idêntico ao discutido na aula de 
  //recursividade para resolver o problema.
  public void solve() {
	  assert numOfMoves == 0;
	  moveDiscs(n, TA, TC, TB);
  }
  
  /*Um método moveDisk(a, b) que simule a operação fundamental de mover um disco
  de uma torre para outra, modificando as pilhas correspondentes.*/
  public void moveDiscs(int n, Stack<Integer> origem, Stack<Integer> destino, Stack<Integer> meio) {
	  assert n>=0;
	  
	  if (n>0)
	  {
		  //Moves
		  moveDiscs(n-1, origem, meio, destino);
		  
		  //Mover um disco de uma stack para outra
		  moveOneDisc(origem, destino);
		  printInfo();
		  
		  //Mover again
		  moveDiscs(n-1, meio, destino, origem);
	  }
  }
  
  //Mover um disco apenas
  private void moveOneDisc(Stack<Integer> origem, Stack<Integer> destino) {
	  numOfMoves++;
	  //Primeiro: origem.top() - devolve o elemento do topo da pilha de origem
	  //Segundo: destino.push() - insere o elemento q estava na pilha de origem na pilha de destino
	  destino.push(origem.top());
	  //Remove por completo o elemento q estava na pilha de origem
	  origem.pop();
  }
  
  //@return do numero de movimentos
  public int numberOfMoves() {return numOfMoves;}
  
  

}
