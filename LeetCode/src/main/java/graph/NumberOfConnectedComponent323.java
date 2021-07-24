package graph;

import java.util.Arrays;

public class NumberOfConnectedComponent323 {
	public int countComponents(int n, int[][] edges) {
		 int count = n;
		 int[] rank = new int[n];
		 int[] par = new int[n];
		 for(int i=0;i<n;i++){
		 	par[i]=i;
		 	rank[i]=1;
		 }
		 for(int[] edge: edges){
		 	int root1 = find(edge[0],par);
		 	int root2 = find(edge[1],par);
		 	if(root1 !=root2){
		 		union(root1,root2,rank,par);
		 		count--;
			}
		 }
		 return count;
	    }
	     

	     
	    private int find(int child,int[] par) {
			while(child != par[child]){
				child = par[child];
			}
			return child;
	    }
	     
	    private void union(int root1,int root2,int[] rank,int[] par){
			if(rank[root1]>rank[root2]){
				par[root2] = root1;
				rank[root1] +=rank[root2];
			}else{
				par[root1] = root2;
				rank[root2] +=rank[root1];
			}
	    }
	
	public static void main(String[] args) {
		NumberOfConnectedComponent323 re= new NumberOfConnectedComponent323();
		//int[][] edges= new int[][] {{0, 1}, {1, 2}, {3, 4}};
//		int[][] edges= new int[][] {{0, 1}, {1, 2},{2,3}, {3, 4}};
		int[][] edges= new int[][] {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(re.countComponents(5, edges));
	}

}
