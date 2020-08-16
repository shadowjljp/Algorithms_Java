package graph;

import java.util.Arrays;

public class NumberOfConnectedComponent323 {
	public int countComponents(int n, int[][] edges) {
		 int count = n;
	        // array to store parent
	        init(n, edges);
	        for(int[] edge : edges) {
	            int root1 = find(edge[0]);
	            int root2 = find(edge[1]);
	            if(root1 != root2) {
	                union(root1, root2);
	                count--;
	            }
	        }
	        return count;
	    }
	     
	    int[] map;
	    private void init(int n, int[][] edges) {
	        map = new int[n];
	        for(int[] edge : edges) {
	            map[edge[0]] = edge[0];
	            map[edge[1]] = edge[1];
	        }
	    }
	     
	    private int find(int child) {
	        while(map[child] != child) child = map[child];
	        return child;
	    }
	     
	    private void union(int child, int parent) {
	        map[child] = parent;
	    }
	
	public static void main(String[] args) {
		NumberOfConnectedComponent323 re= new NumberOfConnectedComponent323();
		//int[][] edges= new int[][] {{0, 1}, {1, 2}, {3, 4}};
//		int[][] edges= new int[][] {{0, 1}, {1, 2},{2,3}, {3, 4}};
		int[][] edges= new int[][] {{0, 1}, {1, 2}, {3, 4},{2,3}};
		System.out.println(re.countComponents(5, edges));
	}

}
