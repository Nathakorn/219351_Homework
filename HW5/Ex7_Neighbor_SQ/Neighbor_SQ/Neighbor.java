package Neighbor_SQ;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Neighbor {
	
	public static Map<Integer, Node> allNodes; 
	
	public static Node getNode(int value) {
		Integer key = new Integer(value);
		if (allNodes.containsKey(key)) {
			return allNodes.get(key);
		} else {
			Node newNode = new Node(value);
			allNodes.put(key, newNode);
			return newNode;
		}
	}
	
	public static void main(String[] args) throws IOException {
		allNodes = new HashMap<Integer, Node>(); 
		BufferedReader br = new BufferedReader(new FileReader("/Users/nathakorn/Desktop/HW5/web-Google.txt"));
		PrintWriter out = new PrintWriter("/Users/nathakorn/Desktop/HW5/Ex7_Neighbor_SQ/out.txt", "UTF-8");
	    
	    String line;
	    while((line = br.readLine()) != null){
	        String[] values = line.split("\t");
	        int from = Integer.parseInt(values[0]);
	        int to = Integer.parseInt(values[1]);
	        Node node = getNode(from);
	        node.addChild(getNode(to));
	    }
	    br.close();
	    for (Integer key : allNodes.keySet()) {
	    		Node node = allNodes.get(key);
	    		out.print(key + ": ");
	    		for (Node n: node.children) {
	    			out.print(n.value + ", ");
	    			for (Node nn: n.children) {
		    			out.print(nn.value + ", ");
		    		}
	    		}
	    		out.println();
	    }
	    out.close();
	}
}

