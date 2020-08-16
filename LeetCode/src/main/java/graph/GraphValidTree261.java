package graph;

import java.util.Arrays;

public class GraphValidTree261 {
	public boolean validTree(int n, int[][] edges) {
		int[]	parent = new int[n];
		Arrays.fill(parent, -1);
		for(int[] edge :edges) {
			int x = find(parent,edge[0]);
			int y = find(parent,edge[1]);
			if(x==y) return false;
			union(parent,x,y);
		}
		return true;
		
	}
	private void union(int[] parent, int x, int y) {
		int xRoot = find(parent,x);
		int yRoot = find(parent,y);
		parent[xRoot] = yRoot;
		
	}
	private int find(int[] parent, int i) {
		if(parent[i]==-1) {
			return i;
		}
		return find(parent, parent[i]);
	}
	public static void main (String[] args){
		GraphValidTree261 re = new GraphValidTree261();
		int[][] edges = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
	//	int[][] edges = new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.println(re.validTree(5, edges));
		
	}
}
