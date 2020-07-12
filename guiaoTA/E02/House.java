//HABITAÇÕES

import static java.lang.System.*;

public class House {
	
  private String houseType;
  private int extensionSize;
  private Room [] rooms;  //divisões de uma casa
  private int size;
  private Door [] doors;
  private int numDoors;

  //CONSTRUTORES
  public House(String houseType,int maxSize,int extensionSize) {
    this.houseType = houseType;
    this.extensionSize = extensionSize;
    rooms = new Room[maxSize];
    size = 0;    //size e numDoors inicializam-se no construtor
    doors = new Door[maxSize];
    numDoors = 0;
  }

  public House(String houseType) {
    this(houseType,8,4);
  } 

  public int size() {
    return size;
  }

  public int maxSize() {
    return rooms.length;
  }

  public Room room(int i) {
    return rooms[i];
  }

  public void addRoom(Room r) {
    if (size == rooms.length) extendHouse();
    rooms[size] = r;
    size++;
  }
	
  //extende a capacidade do vetos
  private void extendHouse() {
    Room [] newRooms = new Room[rooms.length+extensionSize];
    arraycopy(rooms, 0, newRooms, 0, rooms.length);
    //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    /*Parameters:
    - src: this is the source array
    - srcPos: this is the starting position in the source array
    - dest: this is the destination array
    - destPos: this is the starting position in the destination data
    - length: this is the number of array elements to be copied*/  
    rooms = newRooms;
  } 

  

  public void addDoor(Door d) {
    doors[numDoors] = d;
    numDoors++;
  }

  public int numDoors() {
    return numDoors;
  }

  public int maxNumDoors() {
    return doors.length;
  }

  // RESPOSTAS...
  
  /*Crie um método roomClosestToRoomType(roomType) na classe House que, dado
  um tipo de divisão, devolve o identificador da divisão mais próxima de uma qualquer
  divisão do tipo dado. Considere distâncias em linha recta entre os centros geométricos
  das divisões.*/
  //Procura o quarto mais proximo
  public int roomClosetToRoomType(String roomType) {
	  double distMin = 0;
	  int roomNum = -1;
	  
	  for (int i = 0; i < this.size; i++)
	  {
		  //search for the rooms with name roomType
		  if (this.rooms[i].roomType().equals(roomType))
		  {
			  //search for others(j != i) rooms, gets the distance
			  for (int j = 0; j < this.size; j++)
			  {
				  if (j != i)
				  {
					  double distance = this.rooms[i].geomCenter().distTo(this.rooms[j].geomCenter());
					  if ((roomNum == -1) || (distance < distMin))
					  {
						  distMin = distance;
						  roomNum = j;
					  }
				  }
		      }
		  }
	  }
	  return roomNum;
	  //return distMin;
  }
  
  //Crie um método maxDoorsInAnyRoom() na classe House que devolve o máximo
  //número de portas numa qualquer divisão da habitação.
  public int maxDoorsInAnyRoom () {
	  int[] doors_roomid = new int [numDoors];
	  
	  //gets number of doors per room
	  for (int i = 0; i < numDoors; i++)
	  {
		  doors_roomid[doors[i].id1()]++;
		  doors_roomid[doors[i].id2()]++;
	  }
	  
	  //finds the max value of the array doors_roomid
	  int max=0;
	  for (int i = 0; i < numDoors; i++)
	  {
		  if (doors_roomid[i] > max)
		  {
			  max = doors_roomid[i];
		  }
	  }
	  return max;
	  
	  
	  //~ int[] numberDoors = new int[size];
	  //~ for (int i = 0; i < numDoors; i++)
	  //~ {
		  //~ for (int j = 0; j < size; j++)
		  //~ {
			  //~ if (doors[i].room1() == j)
			  //~ {
				  //~ numberDoors[j]++;
			  //~ }
			  //~ if (doors[i].room2() == j)
			  //~ {
				  //~ numberDoors[j]++;
			  //~ }
		  //~ }
		  
	  //~ }
	  //~ int maxDoors = 0;
	  //~ for (int i : numberDoors) {
		  //~ if (i > maxDoors)
		  //~ {
			  //~ maxDoors = i;
		  //~ }
	  //~ }
	  //~ return maxDoors;
  }

}

