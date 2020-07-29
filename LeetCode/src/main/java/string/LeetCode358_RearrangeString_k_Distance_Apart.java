package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode358_RearrangeString_k_Distance_Apart {
	public String rearrangeString(String s, int k) {
//		StringBuilder sb = new StringBuilder();
//		int[] count = new int[26];
//		int[] position = new int[26];
//		for(int i=0;i<s.length();i++) {
//			count[s.charAt(i)-'a']++;
//		}
//		
//		for(int i=0;i<s.length();i++) {
//			int po = findMax(count,position,i);
//			if(po==-1) return "";
//			sb.append((char)('a'+po));
//			count[po]--;
//			position[po]=i+k;
//		}
//		return sb.toString();
		//Using map and heap
		Map<Character,Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
		}
		pq.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		LinkedList<Map.Entry<Character,Integer>> list = new LinkedList<>();
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> m = pq.poll();
			sb.append(m.getKey  ());
			m.setValue(m.getValue()-1);
			list.add(m);
			if(list.size()<k) {
				continue;
			}
			Map.Entry<Character, Integer> head = list.poll();
			if(head.getValue()>0)
			pq.add(head);
			
		}
		return sb.length() == s.length() ? sb.toString() : "";
		
	}
	
//	public int findMax(int[] count,int[] position,int intK) {
//		int po=-1;
//		int max = Integer.MIN_VALUE;
//		for(int i=0;i<count.length;i++) {
//			if(count[i]>0 && count[i]>max && intK>=position[i]) {
//				max = count[i];
//				po=i;
//			}
//		}
//		return po;
//	}
	public static void main(String[] args) {
		LeetCode358_RearrangeString_k_Distance_Apart re = new LeetCode358_RearrangeString_k_Distance_Apart();
		String s ="aabbcc"; int k = 3;
		System.out.println(re.rearrangeString(s, k));
	}

}
