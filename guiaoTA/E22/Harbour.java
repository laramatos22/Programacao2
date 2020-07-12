
import static java.lang.System.*;
import pt.ua.p2utils.*;

public class Harbour {

  private final Dock[] docks;
  private final int maxStack;
  
  private final HashTable<Integer> destinations;


  public Harbour(int nOfDocks,int maxStack) {

    docks = new Dock[nOfDocks];
    for (int dockId=0; dockId<nOfDocks; dockId++) {
      docks[dockId] = new Dock(maxStack);
    }
    this.maxStack = maxStack;
    destinations = new HashTable<>(100);
  }        

  public boolean stackEmpty(int dockId) {
    return docks[dockId].stackEmpty();
  }

  public boolean stackFull(int dockId) {
    return docks[dockId].stackFull();
  }

  public boolean accessExtensionEmpty(int dockId) {
    return docks[dockId].accessExtensionEmpty();
  }

  public void displayDocks() {
    for (int dockId=0; dockId<docks.length; dockId++) {
      out.println(dockId+": "+docks[dockId]);
    }
  }

  public void enterContainer(int dockId,Container c) {
    docks[dockId].enterContainer(c); // implement in the Dock class
    //...
    int count = 0;
    
	if (destinations.contains(c.destination))
	{
		count = destinations.get(c.destination);
	}
	
	destinations.set(c.destination, count+1);

  }

  public void moveFromAccessToStack(int dockId) {
    docks[dockId].moveFromAccessToStack(); // implement in the Dock class
  }

  // the container on top of the stack in the given dock
  // is removed because it will be shipped
  public Container shipContainer(int dockId) {
    Container c = docks[dockId].shipContainer(); //implement in the Dock class
    //...
    
    int count = destinations.get(c.destination);
    count--;
    
    if (count == 0)
	{
		destinations.remove(c.destination);
	} else
	{
		destinations.set(c.destination, count);
	}

    return c;
  }

  /**count() - Devolve o número total de contentores em todas as docas.
  // total number of containers*/
  public int count() {
    //...
    
    int count = 0;
    
    for (int i = 0; i < docks.length; i++)
	{
		count += docks[i].count();
	}
	
	return count;

  }

  /**countToDestination(dest) - Dado o nome de uma cidade, devolve o número de con-
tentores destinados a essa cidade. De preferência, deverá usar uma estrutura do pacote
pt.ua.p2utils que facilite a obtenção dessa informação. Poderá acrescentar código
em outros métodos por forma a manter a informação actualizada.
  // number of containers for a given destination*/
  public int countToDestination(String destin) {
    //...
    
    return destinations.get(destin);

  }

  /**currentDestinations() - Devolve um vector com os nomes das cidades de destino de
todos os contentores existentes no porto.
  // array containing destinations of existing containers*/
  public String[] currentDestinations() {
    //...
    
    return destinations.keys();

  }

  // given a dock, picks the first container
  // in the queue and inserts in the stack of the same dock
  public void insertFirstInStack(int dockId) {
    docks[dockId].insertFirstInStack(); // implement in the Dock class
  }
}

