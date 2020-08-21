package design;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
	Queue<Integer> queue;
	public DesignHitCounter() {
		queue = new LinkedList<>();
	}
	public void hit(int timestamp) {
		queue.offer(timestamp);
	}
	public int getHits(int timestamp) {
		checkTime(timestamp);
		return queue.size();
	}
	public void checkTime(int timestamp) {
		while(!queue.isEmpty() && timestamp-queue.peek()>=300) {
			queue.poll();
		}
	}
	public static void main(String[] args) {
		DesignHitCounter re = new DesignHitCounter();
		re.hit(1);
		re.hit(2);
		re.hit(3);
		
		re.getHits(4);
		re.hit(300);
		System.out.println(re.getHits(300));
		System.out.println(re.getHits(301));
	}

}
