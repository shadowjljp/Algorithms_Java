package pq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	Map<String,PriorityQueue<String>> map;
	LinkedList<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        res = new LinkedList<>();
        for(List<String> ticket: tickets){
            map.putIfAbsent(ticket.get(0),new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }
    public void dfs(String destination){
        PriorityQueue<String> arrivals = map.get(destination);
        while(arrivals !=null && !arrivals.isEmpty()){
        	String des = arrivals.poll();
            dfs(des);
        }
        res.addFirst(destination);
    }

	public static void main(String[] args) {
		ReconstructItinerary re = new ReconstructItinerary();
		List<List<String>> tickets = new ArrayList<>();
		List<String> c= new ArrayList<>();
		c.add("JFK");
		c.add("KUL");
		tickets.add(c);
		c= new ArrayList<>();
		c.add("JFK");
		c.add("NET");
		tickets.add(c);
		c= new ArrayList<>();
		c.add("NET");
		c.add("JFK");
		tickets.add(c);
//		c= new ArrayList<>();
//		c.add("ATL");
//		c.add("JFK");
//		tickets.add(c);
//		c= new ArrayList<>();
//		c.add("ATL");
//		c.add("SFO");
//		tickets.add(c);
		re.findItinerary(tickets);
	}
}

