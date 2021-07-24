package graph;

import java.util.*;

public class AlienDictionary269 {
    public String AlienOrder(String[] words){
        int[] indegree = new int[26];
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(words,graph,indegree);
        return bfs(graph,indegree);
    }

    private String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character key : graph.keySet()){
            if(indegree[key - 'a']==0){
                queue.add(key);
            }
        }
        while(!queue.isEmpty()){
             char c = queue.poll();
             sb.append(c);
             Set<Character> characters = graph.get(c);
             for(char ch:characters){
                 indegree[ch -'a']--;
                 if(indegree[ch - 'a'] ==0){
                     queue.add(ch);
                 }
             }

        }
        return  sb.length() == graph.size() ? sb.toString() : "";
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegree) {
        for(String word : words) {
            for (Character c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
            for(int i=1;i<words.length;i++){
                String first = words[i-1];
                String second = words[i];
                int len = Math.min(first.length(),second.length());
                for(int j=0;j< len;j++){
                    if(first.charAt(j) != second.charAt(j)){
                        char out = first.charAt(j);
                        char in = second.charAt(j);
                        if(!graph.get(out).contains(in)){
                            graph.get(out).add(in);
                            indegree[in - 'a']++;
                        }
                        break;
                    }
                    if(j==len-1 && first.length() > second.length()){
                        graph.clear();
                        return;

                    }

                }
            }


    }


    public static void main(String[] args) {
        AlienDictionary269 re = new AlienDictionary269();
//        String[] words = {"abc", "ab"};
        String[] words = { "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        System.out.println(re.AlienOrder(words));
    }
}
