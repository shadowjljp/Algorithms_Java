package dp;

public class PaintHouseII {
	 public int minCostII(int[][] costs) {
		 if(costs.length==0) return 0;
		 int min1 =-1;
		 int min2 =-1;
		 for(int i=0;i<costs.length;i++) {
			 int first = min1;
			 int second = min2;
			 min1=-1;
			 min2=-1;
			 for(int j=0;j<costs[0].length;j++) {
				 if(j==first) {
					 costs[i][j]+=second<0 ? 0: costs[i-1][second];
				 }else {
					 costs[i][j]+= first<0 ? 0: costs[i-1][first];
				 }
				 if(min1<0 || costs[i][j]<costs[i][min1]) {
					 min2 = first;
					 min1=j;
				 }else if(min2<0 || costs[i][j]<costs[i][min2]){
					 min2 =j;
				 }
			 }
		 }
		 return costs[costs.length-1][min1];
		 
	 }
	public static void main(String[] args) {
		PaintHouseII re = new PaintHouseII();
		int[][] costs= {{1,5,3},{2,9,4}};
		System.out.println(re.minCostII(costs));
	}

}
