package design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAveragefromDataStream {
	int size=0;
	double sum=0.0;
	Queue<Integer> queue;
	public MovingAveragefromDataStream(int size) {
		this.size=size;
		queue =new LinkedList<>();
	}
	public double next(int val) {
		if(queue.size()<size) {
			sum+=val;
			queue.offer(val);
		}else {
			queue.offer(val);
			sum-=queue.poll();
			sum+=val;
		}
		return (sum/ queue.size());
	}
	public static void main(String[] args) {
		MovingAveragefromDataStream re = new MovingAveragefromDataStream(3);
		System.out.println(re.next(1));
		System.out.println(re.next(10));
		System.out.println(re.next(3));
		System.out.println(re.next(5));
		
	}
}
