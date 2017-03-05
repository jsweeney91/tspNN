package pckg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	private String fName;
	public static double maxX; // holds the highest x coordinate for scaling
	public static double maxY; // as above
	private ArrayList<Node> nodes = new ArrayList<>();
	
	Reader(String fName){
		this.fName = fName;
		readFile();
	}
	
	public ArrayList<Node> readFile(){			
		BufferedReader br = null;
		FileReader fr = null;
		boolean reading = false;
		try{
			String line;
			br = new BufferedReader(new FileReader(this.fName));
			while((line = br.readLine())!=null){
				
			
				//marks the "end of file"
				if(line.startsWith("EOF")){
					reading = false;
				}
				
				if(reading){
					String[] linesplit = line.trim().split(" ");
					int id = Integer.valueOf(linesplit[0]);
				
					double x = Double.valueOf(linesplit[1]);
					double y = Double.valueOf(linesplit[2]);
					
					if(x>maxX){
						maxX = x;
					}
					if(y>maxY){
						maxY = y;
					}
					
					this.nodes.add(new Node(id,x,y));
				}
				
				//node coordinates start after this phrase in the .tsp files
				if(line.startsWith("NODE_COORD_SECTION")){
					reading = true;
				}
				
				
			}
		}catch(IOException e){
			System.out.println(e);
			return null;
		}
		return nodes;
		
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public void removeNode(Node n){
		this.nodes.remove(n);
	}

	
	
}
