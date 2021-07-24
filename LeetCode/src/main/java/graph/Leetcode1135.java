package graph;

import java.util.Arrays;

public class Leetcode1135 {
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections,(a,b) -> a[2]-b[2]);
        int res=0;
        int group = N;
        UF uf = new UF(N);
        for(int[] conn : connections){
            int root1 = uf.find(conn[0]);
            int root2 = uf.find(conn[1]);
            if(root1 != root2){
                group--;
                res+=conn[2];
                uf.union(root1,root2);
            }
            if(group == 1){
                return res;
            }
        }
        return -1;
    }
    class UF{
        int[] rank;
        int[] parent;
        int n;
        public UF(int N){
            rank = new int[N+1];
            parent = new int[N+1];
            n=N;
            init();
        }
        private void init(){
            for(int i=0;i<n+1;i++){
                rank[i]=1;
                parent[i]=i;
            }
        }

        public int find(int i) {
            if(i == parent[i]) return i;
            return find(parent[i]);
        }

        public void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            if(rank[root1]>rank[root2]){
                parent[root2] = root1;
                rank[root1]+=rank[root2];
            }else{
                parent[root1] = root2;
                rank[root2] += rank[root1];
            }
        }
    }

    public static void main(String[] args) {
        Leetcode1135 re = new Leetcode1135();
        int N=4;
        //int[][] connections = new int[][]{{1,2,5},{1,3,6},{2,3,1}}; //6
        int[][] connections = new int[][]{{1,2,3},{3,4,4}};  //-1
        System.out.println(re.minimumCost(N,connections));

    }
}
