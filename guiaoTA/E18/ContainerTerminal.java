/*ContainerTerminal que trata da gestão de um array de pilhas que formam o terminal.
Nesta classe já encontra um construtor bem como algumas funções auxiliares que lhe
poderão ser úteis.*/

//NMEC: 95228
//NOME: Lara Catarina da Silva Matos
import static java.lang.System.*;

public class ContainerTerminal {
  ContainerStack[] sa;    // the stacks of containers
  int num;  // number of parallel stacks of containers
  int max;  // maximum height of each stack of containers
  int numcontainers;  // number of containers on the terminal
  
  public ContainerTerminal(int num, int max) {
    sa = new ContainerStack[num];
    for (int k = 0; k < num; k++) {
      sa[k] = new ContainerStack(max);
    }
    this.num = num;
    this.max = max;
    numcontainers = 0;
  }
  
  /**
   * Is the terminal full?
   * A full terminal must still have enough free space to enable
   * retrieving any given container.
   */
  public boolean isFull() {
    return numcontainers >= num*max - max;
  }
  
  /**
   * Checks if a container of a certain type exists
   */
  public boolean containerTypeExists(String type) {
    return findStackContaining(type) >= 0;
  }

  
  /**
   * Find first stack with free space, other than the stackToAvoid.
   * @return the index of the found stack
   */
  private int findOtherStack(int stackToAvoid) {
    assert !isFull();
    int k = 0;
    while (k==stackToAvoid || sa[k].isFull()) {
      k++;
    }
    return k;
  }
  
  /**
   * Find a stack that includes a container with a given type of cargo
   * @return the index of the found stack, or -1 if no such cargo exists.
   */
  private int findStackContaining(String type) {
    int k = 0;
    while (k < num) {
      if (sa[k].search(type) >= 0) return k;
      k++;
    }
    return -1;
  }
  
  public void print() {
    out.printf("Terminal numcontainers=%d isFull=%s\n",
                      numcontainers, isFull());
    for (int k = 0; k < num; k++) {
      out.printf("%2d: %s\n", k, sa[k].toString());
    }
  }

  // Log: historical log of retrieved containers: it's a linked list
  HistoryNode log;

  private void logContainerInfo(Container c) {
    HistoryNode n = new HistoryNode();
    //n.type = c.type();
    n.numops = c.numops();
    n.next = log;
    log = n;
  }

  
  
  //...
  
  /*Crie uma função store(container) na classe ContainerTerminal que permita ar-
mazenar um novo contentor. Para isso, deverá encontrar a primeira pilha que não
esteja cheia e empilhar aı́. Naturalmente, só pode funcionar se o terminal não estiver
lotado. Introduza as asserções (pré-condições, pós-condições ou outras) que entenda
adequadas neste método.*/
  public void store(Container c) {
	  assert !isFull();
	  for (int i = 0; i < num; i++)
	  {
		  if (!sa[i].isFull())
		  {
			  sa[i].push(c);
			  break;
		  }
	  }
	  numcontainers++;
  }
  
  /*Crie uma função retrieve(type) na classe ContainerTerminal que procura um
contentor com carga de um certo tipo, e se encontrar, retira-o e devolve-o. Para
retirar o contentor desejado, pode ser necessário retirar os contentores que estejam
por cima e rearmazená-los noutras pilhas, um de cada vez. Se não houver nenhum
contentor do tipo certo no terminal, deve devolver a referência null. Faça uso das
funções de pesquisa já fornecidas na classe. A função retrieve também deve invocar
logContainerInfo, passando o contentor que retirou, de forma a atualizar um registo
histórico dos contentores retirados.*/
  public Container retrieve (String type) {
	  Container c = null;
	  int index = findStackContaining(type);
	  ContainerStack stack = sa[index];
	  if (index != -1) //Procurar uma pilha com o mesmo type de conteúdo dos contentores
	  {
		  int numAbove = stack.search(type);
		  //If it needs to move containers to other stacks
		  if (numAbove > 0)
		  {
			  //Move each container to another stack
			  for (int i = 1; i <= numAbove; i++)
			  {
				  Container container = stack.pop();
				  
				  //Looks for an available stack to move the container
				  for(int j = index; j < num; j++) {
					  ContainerStack temp = sa[findOtherStack(j)];
					  if (!temp.isFull())
					  {
						  temp.push(container);
						  break;
					  }
				  }
			  }
			  
		  }
		  //Retrives the container
		  c = stack.top();
		  stack.pop();
		  logContainerInfo(c);
		  numcontainers--;
	  }
	  return c;
  }
  
  /*Acresente um método averageOpsPerContainer() que percorra o registo histórico
e devolva o número médio de operações de empilhamento por contentor. Este reg-
isto está implementado como uma lista ligada em que os nós são instâncias da
classe HistoryNode, já fornecida. O método logContainerInfo(...), já referido,
acrescenta informação a esta estrutura. Para cotação total, a implementação de
averageOpsPerContainer() deverá ser recursiva.*/
	public double averageOpsPerContainer() {
		return (double)(averageOpsPerContainer(log))/(double)HistoryNode.numberRetrieved;
	}
		
		private double averageOpsPerContainer(HistoryNode n) {
			if(n == null) return 0;
			return n.numops + averageOpsPerContainer(n.next);
		}

}

