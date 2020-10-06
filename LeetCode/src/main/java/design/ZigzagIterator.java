package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
	Queue<Integer> queue;
	public ZigzagIterator(List<Integer> v1,List<Integer> v2) {
		queue = new LinkedList<>();
		int i=0;
		while(i<v1.size()  && i<v2.size()) {
			queue.offer(v1.get(i));
			queue.offer(v2.get(i));
			i++;
		}
		while(i<v1.size()) {
			queue.offer(v1.get(i++));
		}
		while(i<v2.size()) {
			queue.offer(v2.get(i++));
		}
	}
	
	public int next() {
		return queue.poll();
	}
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	public static void main(String[] args) {
		 List<Integer> v1 = new ArrayList<Integer>();
		    List<Integer> v2 = new ArrayList<Integer>();
		    v1.add(1);
		    v1.add(2);
		    v2.add(3);
		    v2.add(4);
		    v2.add(5);
		    v2.add(6);
		    ZigzagIterator i = new ZigzagIterator(v1, v2);
		    while(i.hasNext()) {
		        System.out.println(i.next());
		    }

	}

}
