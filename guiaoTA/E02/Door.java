
public class Door {

  // Declare necessary fields here...
  private int id1, id2;    //IDs of the rooms connected by the door
  private double width, height;

  /** Constructs a new Door between two rooms.
   * @param r1 Identifier of a room.
   * @param r2 Identifiier of another room.  It cannot be the same as r1!
   * @param w  Door width (in meters).  Must be positive.
   * @param h  Door height (in meters).  Must be positive.
   */
   
   //construtor que recebe como argumentos os identificadores das duas divisões 
   //ligadas pela porta bem como a largura e altura da porta;
  public Door(int r1, int r2, double w, double h) {
		this.id1 = r1;
		this.id2 = r2;
		this.width = w;
		this.height = h;
  }
  
  //Getters
  public double area() {
	  return (this.width * this.height);
  }
  
  public int id1() {return this.id1;}
  
  public int id2() {return this.id2;}

}

