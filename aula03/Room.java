public class Room {
	private String div;
	private Point infEsq;
	private Point supDir;
	
	public Room(String divisao, Point cie, Point csd) {
		this.div = divisao;
		this.infEsq = cie;
		this.supDir = csd;
	}
	
	public String roomType() {
		return div;
	}
	
	public Point bottomLeft() {
		return infEsq;
	}
	
	public Point topRight() {
		return supDir;
	}
	
	public Point geomCenter() {
		return new Point((infEsq.x() + supDir.x())/2.0, (infEsq.y() + supDir.y())/2.0);
	}
	
	public double area() {
		return ((supDir.x() - infEsq.x()) * (supDir.y() - infEsq.y()));
	}
	
}
