package interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
	public void minMeetingRooms(int[][] intervals) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a-b);
		Arrays.sort(intervals,(int[]a,int[]b) -> a[0]-b[0]);
		
		for(int [] interval :intervals) {
			System.out.println(interval[0]);
			for(int i:interval) {
				queue.add(i);
				
			}
			
		}
	//	while(!queue.isEmpty()) {
			//System.out.println("ans "+queue.poll());
	//	}
		
	}
	
	
	public static void main(String[] args) {
		Test m = new Test();
		int[][] intervals = { { 0, 30 },{5,10 },{15,20}};
		//int[][] intervals = { { 2,4 },{7,10 }};
		
			m.minMeetingRooms(intervals);
	
	}

}
