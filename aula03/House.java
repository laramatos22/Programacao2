public class House {
	
	private String div;
	private int numDiv = 0;
	private int divAdd;
	private Room[] rooms;
	private RoomTypeCount[] typeCount = new RoomTypeCount[1]; 
	
	public House (String houseType) {
		//this(div, 8, 4);
		//array inicial do construtor para guardar até 8 divisões e 4 adicionais
		this.houseType = div;
		divAdd = 4;
		rooms = new Room[8];
	}
	
	public House (String div, int numDiv, int divAdd) {
		this.div = div;
		this.divAdd = divAdd;
		rooms = new Room [numDiv];
		//array incial de divisões com 8 posições incialmente
	}
	
	public void addRoom (Room rooms) {
		//adiciona divisao ao array rooms
		if(div == rooms.length) extendHouse(); //aumenta o tamanho do array caso todas as divisões estejam ocupadas
		rooms[div] = room;
		div++;
		//adiciona tipo de divisao ao array typeCount
		if (hasType(room.roomType())) incrementType(room.roomType()); //se existir divisao do tipo roomType, incrementa a quantidade
		else addRoomType(room.roomType()); //se não existir nenhuma divisão desse tipo, então cria um tipo novo
	}
	
	public int size () {
		return numDiv;
	}
	
	public int maxSize() {
		return rooms.length;
	}
	
	public Room room (int index) {
		return rooms[index];
	}
	
	public double area() {
		int totalArea = 0;
		for (int i = 0; i < div; i++)
		{
			totalArea += rooms[i].area();
		}
		return totalArea;
		
	}
	
	public getRoomTypeCount () {
		
	}
	
	public int averageRoomDistance() { 
		
	}
}
