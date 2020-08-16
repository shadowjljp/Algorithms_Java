package topological;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class AlienDictionary {
	 public String alienOrder(String[] words) {
		Map<Character,Set<Character>> graph = new HashMap<>();
		int[] indegree = new int[26];
		//build graph
		buildGraph(graph,words,indegree);
		return helper(graph,indegree);
	 }
	
	private String helper(Map<Character, Set<Character>> graph, int[] indegree) {
		StringBuilder sb = new StringBuilder();
		Queue<Character> queue = new LinkedList<>();
		//get the indegree ==0;
		for(char c : graph.keySet()) {
			if(indegree[c-'a']==0) {
				sb.append(c);
				queue.offer(c);
			}
		}
		int totalSize=graph.size();
		while(!queue.isEmpty()) {
			char cur = queue.poll();
			if(graph.get(cur)==null || graph.get(cur).size()==0) continue;
			for(char neigh : graph.get(cur)) {
				indegree[neigh-'a']--;
				if(indegree[neigh-'a']==0) {
					queue.offer(neigh);
					sb.append(neigh);
				}
			}
		}
		return sb.length()==totalSize ? sb.toString() : "";
	}

	private void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] indegree) {
		for(String word:words) {
			for(char c : word.toCharArray()) {
				graph.putIfAbsent(c, new HashSet<>());
			}
		}
		for(int i=1;i<words.length;i++) {
			String first = words[i-1];
			String second = words[i];
			int len = Math.min(first.length(), second.length());
			for(int j=0;j<len;j++) {
				if(first.charAt(j)!=second.charAt(j)) {
					//Check if we have not add these relationship in the graph
					if(!graph.get(first.charAt(j)).contains(second.charAt(j))) {
						graph.get(first.charAt(j)).add(second.charAt(j));
						indegree[second.charAt(j)-'a']++;
					}
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		AlienDictionary re = new AlienDictionary();
		String[] words = {"wrt", "wrf",
				  "er",
				  "ett",
				  "rftt"};
		System.out.println("ans: "+re.alienOrder(words));
	}

}
