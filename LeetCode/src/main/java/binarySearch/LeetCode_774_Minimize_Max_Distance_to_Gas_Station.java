package binarySearch;

public class LeetCode_774_Minimize_Max_Distance_to_Gas_Station {
	public double gasStation(int[] stations,int k) {
		double l=0;
		int n =stations.length-1;
		double r=stations[n]-stations[0];
		while(r-l>Math.pow(10, -6)) {
			double m = l+(r-l)/2;
			if(possible(stations,k,m)) {
				r=m;
			}else {
				l=m;
			}
		}
		return l;
	}
	private boolean possible(int[] stations, int k, double m) {
		int numberStations=0;
		for(int i=0;i<stations.length-1;i++) {
			numberStations += Math.floor((stations[i+1]-stations[i])/m);
		}
		
		return numberStations<=k;
	}
	public static void main(String[] args) {
		LeetCode_774_Minimize_Max_Distance_to_Gas_Station re = new LeetCode_774_Minimize_Max_Distance_to_Gas_Station();
		
		int[] stations= {1,2,3,4,5,6,7,8,9,10};
		int k=9;
		
		System.out.println(re.gasStation(stations, k));
		
	}

}
