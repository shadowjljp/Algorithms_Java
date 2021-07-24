package graph;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Leetcode509 {
    public boolean leadsToDestination(int n,int[][] edges, int source, int destination){
        if(edges.length==0) return true;
        List<Integer>[] graph = new List[n];
        int[] colors = new int[n];
        buildGraph(graph,edges);
        return dfs(graph,colors,source,destination);
    }

    private boolean dfs(List<Integer>[] graph, int[] colors, int source, int destination) {
        if( graph[source]==null || graph[source].size()==0 ) return source==destination;
        colors[source]=1;
        for(int next : graph[source]){
            if(colors[next]==1) return false;
            if(colors[next]==0 && !dfs(graph,colors,next,destination)) return false;
        }
        colors[source]=2;
        return true;

    }

    private void buildGraph(List<Integer>[] graph, int[][] edges) {
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            if(graph[from]==null){
                graph[from]=new ArrayList<>();
            }
            graph[from].add(to);
        }
    }
    public static void main(String[] args) {
        Leetcode509 re=  new Leetcode509();
        int n =4;
        int[][] edges = new int[][]{{0,1},{0,2},{1,3},{2,3}};
        int destination = 3;
        int source = 0;
        System.out.println(re.leadsToDestination(n,edges,source,destination));
    }
}

