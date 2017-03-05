package pckg1;

public class Node {
	//x and y coordinates of node
	private int id;
	private double x;
	private double y;
	
	Node(int id, double x, double y){
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public double getY() {
		return y;
	}
	
	public int getID() {
		return this.id;
	}
	
	public double getX() {
		return this.x;
	}
	
}
