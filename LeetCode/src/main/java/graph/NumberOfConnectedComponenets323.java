package graph;

import java.util.*;

public class NumberOfConnectedComponenets323 {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map  = new HashMap<>();
        init(map,edges);
        int count=0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i,map,visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        List<Integer> neighbors = map.get(i);
        visited.add(i);
        for(int neighbor : neighbors){
            if(!visited.contains(neighbor))
            dfs(neighbor,map,visited);
        }
    }

    private void init(Map<Integer, List<Integer>> map, int[][] edges) {
        for(int[] edge : edges){
            map.putIfAbsent(edge[0],new LinkedList<>());
            map.putIfAbsent(edge[1],new LinkedList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponenets323 res = new NumberOfConnectedComponenets323();
        int n=5;
        int[][] edges = new int[][] {{0,1},{1,2},{3,4}};
        System.out.println(res.countComponents(n,edges));
    }
}
