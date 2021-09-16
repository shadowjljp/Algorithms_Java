package array;

import java.util.*;

public class Leetcode332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;

    }
    public static void main(String[] args){
        Leetcode332 re = new Leetcode332();
        List<List<String>> tickets = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("JFK");
        list.add("KUL");
        tickets.add(list);
        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("NRT");
        tickets.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("NRT");
        list2.add("JFK");
        tickets.add(list2);
        System.out.println(re.findItinerary(tickets));
    }
}
