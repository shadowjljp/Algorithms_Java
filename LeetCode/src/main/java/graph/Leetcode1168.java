package graph;

import java.util.PriorityQueue;

public class Leetcode1168 {
    class DSU{
        int[] size;
        int[] root;
        public DSU(int n){
            size = new int[n+1];
            root = new int[n+1];
            for(int i=0;i<=n;i++){
                size[i]=1;
                root[i] = i;
            }
        }
        public int find(int n){
            if(root[n] != n){
                root[n] = find(root[n]);
            }
            return root[n];
        }
        public boolean union(int n1,int n2){
            int root1 = find(n1);
            int root2 = find(n2);
            if(root1 == root2) return false;
            if(size[root1] > size[root2]){
                root[root2] = root1;
                size[root1] += size[root2];
            }else{
                root[root1] = root2;
                size[root2] += size[root1];
            }
            return true;
        }

    }
    public int minCostToSupplyWater(int n,int[] wells,int[][] pipes){
        DSU dsu = new DSU(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->(a[2] - b[2]));
        for(int i=0;i<wells.length;i++){
            pq.add(new int[]{0,i+1,wells[i]});
        }
        for(int[] pip:pipes){
            pq.add(pip);
        }
        int res=0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(dsu.union(cur[0],cur[1])){
                res+=cur[2];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Leetcode1168 re = new Leetcode1168();
        int N=3;
        int[] wells = new int[]{1,2,2};
        int[][] connections = new int[][]{{1,2,1},{2,3,1}}; // -1
        //int[][] connections = new int[][]{{1,3},{2,3}};  //2
        System.out.println(re.minCostToSupplyWater(N,wells,connections));

    }
}
