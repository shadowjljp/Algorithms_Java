package graph;

import java.util.*;

public class Leetcode1136 {
    public int minimumSemesters(int N, int[][] relations) {
        int[] indegree = new int[N+1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int taken =0;
        int semester =0;
        for(int[] relation:relations){
            indegree[relation[1]]++;
            //build graph
            graph.putIfAbsent(relation[0],new ArrayList<>());
            graph.get(relation[0]).add(relation[1]);

        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            semester++;
            while(size > 0) {
                size--;
                int curr = queue.poll();
                taken++;
                List<Integer> neighbors = graph.get(curr);
                if(neighbors ==null || neighbors.size()==0) break;
                for (int neighbor : neighbors) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.add(neighbor);

                    }
                }
            }
        }
        return taken == N ? semester : -1;
    }
    public static void main(String[] args) {
        Leetcode1136 re = new Leetcode1136();
        int N=3;
        int[][] connections = new int[][]{{3,1},{2,3},{1,2}}; // -1
        //int[][] connections = new int[][]{{1,3},{2,3}};  //2
        System.out.println(re.minimumSemesters(N,connections));

    }
}
