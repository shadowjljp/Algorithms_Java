package mini;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Krustals {
	/*Edge class*/
	class Edge implements Comparable<Edge>{
		int source, destination,weight;
		
		public Edge(int source,int destination,int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		/*for priorityQueue to know which edge is smaller*/
		@Override
		public int compareTo(Edge compareEdge) {
			return this.weight-compareEdge.weight;
		}
		
		@Override
		public String toString() {
			return "edge : "+map.get(source)+" , "+map.get(destination)+", weight: "+weight;
		}
	}
	
	
	
	//get key from value
	
	/*use priorityQueue to store, It only has 11 size initially and size*2 when needed so it can not be use in for loop for accurate measurement*/
	PriorityQueue<Edge> queue = new PriorityQueue<>();
	List<String> list = new ArrayList<>();
	/*maps number to vertices*/
	Map<Integer,String> map = new HashMap<>();
	//store result
	List<Edge> result = new ArrayList<>();
	//get number from vertice name
	public <Integer,String> Set<Integer> getKeysByValues(Map<Integer,String> map, String value) {
	    return map.entrySet()
	              .stream()
	              .filter(entry -> Objects.equals(entry.getValue(), value))
	              .map(Map.Entry::getKey)
	              .collect(Collectors.toSet());
	}
	public int getKeysByValue(Map<Integer,String> map, String value) {
		int[] temp =getKeysByValues(map,value).stream().mapToInt(Number::intValue).toArray();
		return temp[0]; 
				
		
	}
	/*vertices count*/
	int count =0;
	
	/*read the csv file and store edges,vertices*/
	public void readfile(String Filepath) {
		File file = new File(Filepath);
		try {
			Scanner sc = new Scanner(file);
			Scanner sc1 = new Scanner(file);
			while(sc.hasNext()) {
				count++;
				String[] temp = sc.nextLine().split(",");
				//get all the vertices from csv
				list.add(temp[0]);
				
			}
			sc.close();
		
		//map vertices with number
		for(int i =0;i<count;i++) {
			map.put(i,(String)list.get(i));
		}
	//	System.out.println("map "+map.entrySet());
		//store edges to queue
		while(sc1.hasNext()) {
			String[] temp = sc1.nextLine().split(",");
			for(int i =0;(2*i+2)<temp.length;i++) {
			queue.add(new Edge((Integer)getKeysByValue(map,temp[0]),(Integer)getKeysByValue(map,temp[2*i+1]),(Integer.parseInt(temp[2*i+2]))));
			}
			
		}
		sc1.close();
		
	//	System.out.println("value to key "+getKeysByValue(map,"Dallas"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void miniSpanTree() {
		/*use DisjSets find to check if there is a circle formed*/
		DisjSets disjset = new DisjSets(count+1);
        int subsetSize;
        /* While there are more than two subsets in the queue, keep looping. */
        do {
        	subsetSize=0;
        	for(int i =0;i<count;i++) {
        		if(disjset.find(i) !=disjset.find(i+1)) {
        			subsetSize++;
        		}
        	}
        	Edge currentEdge = queue.poll();
        int root1 = disjset.find(currentEdge.source);
        int root2 = disjset.find(currentEdge.destination);
        if(root1 != root2) {
        	//add to result and union
        	result.add(currentEdge);
        	disjset.union(root1, root2);
        }
        	
        	
        }while(subsetSize>1);
    	/*You should output each edge of your minimum spanning tree as the names of the two
        cities and the distance between them.  You should also print the sum of all of the
        distances in the tree.*/
        int totalDistance=0;
      
        for(Edge e:result) {
        	totalDistance=totalDistance+e.weight;
        	System.out.println(e.toString());
        }
		System.out.println("Total distance is "+totalDistance);
	}
	public static void main(String[] args) {
		String Filepath = "src/mini/assn9_data.csv";
		Krustals kru = new Krustals();
		kru.readfile(Filepath);
		kru.miniSpanTree();
	}
	
	
	
	

}
