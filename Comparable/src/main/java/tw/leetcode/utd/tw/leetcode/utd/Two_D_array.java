package tw.leetcode.utd.tw.leetcode.utd;

public class Two_D_array {
	
	   public int[][] insert(int[][] intervals, int[] newInterval) {
	        int i=0; //starter
	        int j=i;//end
	        
	        while(intervals[i][1]<newInterval[0]){
	            i++;
	        }
	        j=i;
	        while(intervals[j][0]< newInterval[1]){
	            intervals= del(intervals,newInterval,i,j);
	            j++;
	        }
	        
	        return intervals;
	        
	    }
	    
	    public int[][] del(int[][] intervals,int[] newInterval,int i,int j){
	        int[][] tempIntervals = new int[intervals.length][2];
	        for(int k=0;k<intervals.length;k++){
	            
	                if(k==i ){
	                tempIntervals[k] = new int[]{Math.min(intervals[k][0],newInterval[0]),Math.max(intervals[k][1],newInterval[1])};
	                continue;
	                }
	            
	            
	            tempIntervals[k] = intervals[k];
	            }
	            
	                
	        
	        return tempIntervals;
	    }

	public static void main(String[] args) {
		Two_D_array re = new Two_D_array();
		int[][] a = {{1,3},{6,9}};
		int[] b = {2,5};
		a= re.insert(a, b);
		for(int[] c:a) {
			for(int d :c)
			System.out.println(d);
		}
		

	}

}
