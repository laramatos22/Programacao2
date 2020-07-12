/*Class Container: que representa um contentor, caraterizado pelo tipo de carga que contém (”ar-
roz”, ”bananas”, etc) e por um identificador único que lhe é atribuı́do automatica-
mente na criação. O contentor também inclui um contador do número de operações
(movimentações) a que foi sujeito.*/

public class Container {
  public final int id;  //unique identifier for the container, set automatically
  public final String type;  // type of cargo in container

  private static int lastID = 0;
  private int numops;  // number of times this container has been pushed
  
  public Container(String type) {
    lastID++;
    id = lastID;
    this.type = type;
    numops = 0;
  }
  
  // Check if this container contains a certain type of cargo
  public boolean contains(String type) {
    return this.type.equals(type);
  }
  
  // A string representation of this container
  public String toString() {
    return String.format("(%d,%s)", id, type);
  }
  
  public void incrementOps() { numops++; }
  
  public int numops() { return numops; }
}

