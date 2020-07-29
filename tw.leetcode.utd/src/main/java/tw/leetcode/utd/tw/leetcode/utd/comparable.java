package tw.leetcode.utd.tw.leetcode.utd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class comparable {
    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        for(int[] cur : people){
        System.out.println("h"+cur[0]+"p"+cur[1]);
        }
        List<int[]> res = new LinkedList<>();
        
        for(int[] cur : people){
        	 System.out.println("h"+cur[0]+"p"+cur[1]+"cc");
            res.add(cur[1],cur); 
            System.out.println("------------------------------");
            for(int[] res1 : res){
                System.out.println("res= "+res1[0]+"p"+res1[1]);
                }
            System.out.println("=============================");
        }
       
        
        return res.toArray(new int[people.length][]);
    }
	public static void main(String[] args) {
		comparable c =new comparable();
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] re =c.reconstructQueue(people);
		System.out.println("=============================");
		 for(int[] cur : re){
		      System.out.println("h"+cur[0]+"p"+cur[1]);
		        }
		 double x = 255.0;
	System.out.println(Math.pow(x, 1/2.2));
	int t =  0b11111111111111111110100100000000;
	t= (t>>8);
	System.out.println("answer");
	System.out.println(t);
	
	}

}
