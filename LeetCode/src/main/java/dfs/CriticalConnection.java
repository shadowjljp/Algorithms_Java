package dfs;

import java.util.*;

public class CriticalConnection {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //build graph:
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(List<Integer> list : connections){
            List<Integer> cur = map.getOrDefault(list.get(0),new ArrayList<Integer>());
            cur.add(list.get(1));
            map.put(list.get(0),cur);
            cur = map.getOrDefault(list.get(1),new ArrayList<Integer>());
            cur.add(list.get(0));
            map.put(list.get(1),cur);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(List<Integer> list: connections){
            Map<Integer,List<Integer>> graph = new HashMap<>(map);
            int count = graphCount(list,graph);
            if(count > 1){
                res.add(list);
            }
        }
        return res;
    }
    private int graphCount(List<Integer> list,Map<Integer,List<Integer>> map){
        //remove edge
        List<Integer> cur = map.get(list.get(0));
        cur.remove((Integer)list.get(1));
        map.put(list.get(0),cur);
        cur = map.get(list.get(1));
        cur.remove((Integer)list.get(0));
        map.put(list.get(1),cur);
        //dfs
        Set<Integer> visited = new HashSet<Integer>();
        return dfs(map,list.get(0),visited) + dfs(map,list.get(1),visited);
    }
    private int dfs(Map<Integer,List<Integer>> map,int start,Set<Integer> visited){
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        if(visited.contains(start)) return 0;
        visited.add(start);
        while(!stack.isEmpty()){
            int key = stack.pop();
            List<Integer> value = map.get(key);
            for(Integer v: value){
                if(!visited.contains(v)){
                    visited.add(v);
                    stack.add(v);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        CriticalConnection re = new CriticalConnection();
        int n =4;
        List<List<Integer>> connections = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        connections.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        connections.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(0);
        connections.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        connections.add(list3);
        re.criticalConnections(4,connections);
    }
}
