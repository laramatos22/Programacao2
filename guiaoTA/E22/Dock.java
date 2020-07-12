
import pt.ua.p2utils.*;

public class Dock {

  private final Stack<Container> containerStack;
  private final Queue<Container> accessExtension;
  private final int maxStack; // maximum number of containers in a stack

  public Dock(int maxStack) {
    accessExtension = new Queue<>();
    containerStack = new Stack<>();
    this.maxStack = maxStack; // controla-se o size fora da pilha
  }

  public boolean stackEmpty() {
    return containerStack.isEmpty();
  }

  public boolean stackFull() {
    return containerStack.size()==maxStack;
  }

  public boolean accessExtensionEmpty() {
    return accessExtension.isEmpty();
  }

  public int count() {
    return containerStack.size()+accessExtension.size();
  }

  public String toString() {
    return "In stack:" + containerStack.toString() + 
      " / In access: " + accessExtension.toString();
  }
  
  /**enterContainer(c) - Regista a entrada de um contentor na fila do ramal de acesso.
  // a new container arrives and must be added to the queue*/
  public void enterContainer(Container c) {
    //...
    assert c != null;
    
    accessExtension.in(c);
    

  }
  /**shipContainer() - Regista a saı́da de um contentor. O contentor que sai é o que está
  no topo da pilha. A função devolve o contentor retirado.
  // top container in stack is removed (it will be shipped)*/
  public Container shipContainer() {
    //...
	assert !stackEmpty();
	
	Container c = containerStack.top();
	containerStack.pop();
	return c;	
	
  }
	
  /**moveFromAccessToStack() - Transfere da fila para a pilha, por ordem de chegada,
todos os contentores disponı́veis que couberem na pilha. A pilha não pode ter mais do
que maxStack contentores.
  // Moves containers from the accessExtension to the dock stack*/
  public void moveFromAccessToStack() {
    //...
    assert !stackFull() && !accessExtensionEmpty();
    
    while (!stackFull() && !accessExtensionEmpty())
	{
		Container c = accessExtension.peek();
		containerStack.push(c);
		accessExtension.out();
	}
    

  }

  /**insertFirstInStack() - Transfere o primeiro contentor da fila para a pilha. Neste
caso, a pilha tem que estar sempre ordenada por distância ao destino (distância maior
no topo), por isso poderá ser necessário remover temporiamente alguns contentores para
uma pilha auxiliar.
  // pick the first container from the queue
  // and insert it in the stack in such way the stack
  // is sorted by distance to destination
  // (largest distance at the top)*/
  public void insertFirstInStack() {
    assert !stackFull() && !accessExtensionEmpty();
    //...
	
	//Criação da pilha temporária
	Stack<Container> temp = new Stack<>();
	
	//contentores da fila q sao pretirados
	Container cFila = accessExtension.peek();
	
	//retirado o contentor da fila
	accessExtension.out();
	
	Container cPilha = null;
	
	while (!stackEmpty() && cFila.distance <= cPilha.distance)
	{
		cPilha = containerStack.top();
		
		temp.push(cPilha);
		
		containerStack.pop();
		
	}
	
	//volta a ir buscar mais um contentor à fila
	containerStack.push(cFila);
	
	while (!temp.isEmpty())
	{
		Container cTemp = temp.top();
		
		containerStack.push(cTemp);
		
		temp.pop();
		
	}
	
  }
}

