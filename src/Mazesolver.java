import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Mazesolver {

	/**
	 * Stores the map
	 */
	static char lis[][];
	
	/**
	 * dimensions of the map
	 */
	static int height, width;
	
	static Node source;
	static Node target;
	
	static List<Node> nodeList = new ArrayList<Node>();

	/**
	 * 
	 * @param node
	 * @return list of neighboring nodes of node 
	 */
	private static List<Node> getNeighbors(Node node){
		List<Node> neighbors = new ArrayList<Node>();
		for(Node n : nodeList){
			if(n.isCoordinate(node.x - 1,node.y)||
				n.isCoordinate(node.x + 1, node.y)||
				n.isCoordinate(node.x, node.y - 1)||
				n.isCoordinate(node.x, node.y + 1)){
				neighbors.add(n);
			}
		}
		return neighbors;
	}
	
	private static void initializeNodeList(){
		for(int i=0; i<height;i++){
			for(int j =0; j<width;j++ ){
				Node newNode = new Node(j,i);
				if (lis[i][j] == '1'){
					continue;
				}
				if (lis[i][j]=='2'){
					newNode.setvalue(0);
					source = newNode;	
				}
				if (lis[i][j] == '3'){
					target = newNode;
				}
				nodeList.add(newNode);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("map_0.txt"));
		ArrayList <String> strlist = new ArrayList<String>();
		String line;
		while ((line = br.readLine()) != null) {
		   // process the line.
			strlist.add(line);
		}
		
		height = strlist.size();
		width = strlist.get(0).length();

		lis = new char[strlist.size()][strlist.get(0).length()];
		for(int i=0; i<strlist.size();i++){
			for(int j =0; j<strlist.get(0).length();j++ ){
				lis[i][j]=strlist.get(i).charAt(j);
			}
		}
		br.close();
		
		initializeNodeList();
		
		// Dijkstra's Algorithm here
		// TODO
		
	}
	
}
