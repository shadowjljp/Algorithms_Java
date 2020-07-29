package string;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_withAt_Most_Two_Distinct {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character,Integer> map = new HashMap<>();
		int max=0;
		int left=0;
		int i=0;
		while(i<s.length()) {
				map.put(s.charAt(i++),i);
			
			if(map.size()>2) {
				int leftMost = s.length();
				for(int value:map.values()) {
					leftMost = Math.min(leftMost, value);
				}
				map.remove(s.charAt(leftMost));
				left = leftMost+1;
				
			}
		}
		max= Math.max(max, i-left);
		return max;
		
	}
	public static void main(String[] args) {
		Longest_Substring_withAt_Most_Two_Distinct re = new Longest_Substring_withAt_Most_Two_Distinct();
		String s = "aabbcce";
		System.out.println(re.lengthOfLongestSubstringTwoDistinct(s));
				
	}

}
