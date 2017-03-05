package pckg1;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Reader r = new Reader("C:\\\\Users\\admin\\Desktop\\rl5915.tsp.txt");
		
		Node currentNode = r.getNodes().get(0); //starting point
		ArrayList<Node> taken = new ArrayList<>(); //holds the nodes that have already been used to avoid repetition 
	    Node firstNode = r.getNodes().get(0);
	    
	    int nodesSize = r.getNodes().size();
		while(taken.size()<nodesSize){
			taken.add(currentNode);			
			r.removeNode(currentNode);
			double currentLowest = -1;
			Node nextNode = null;
			for(Node n : r.getNodes()){
				double distance = distanceCalc(currentNode, n);
				if((currentLowest == -1 || distance < currentLowest)){
					currentLowest = distance;
					nextNode = n;
				}
			}
			if(nextNode != null){				
				currentNode = nextNode;	

			}else{
				taken.add(firstNode);
			}
		}
		System.out.println(taken.size());
		Visualiser vis = new Visualiser(1000,1000);
		
		for(int i = 1;i<taken.size();i++){
			vis.addLine(taken.get(i-1), taken.get(i));
			vis.addLine(taken.get(i), taken.get(i-1));
		}
		
		JOptionPane.showMessageDialog(null, vis);

		
	}
	
	public static double distanceCalc(Node n1, Node n2){
		return Point2D.distance(n1.getX(), n1.getY(), n2.getX(), n2.getY());
	}

}
