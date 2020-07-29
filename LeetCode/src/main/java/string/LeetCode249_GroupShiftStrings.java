package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode249_GroupShiftStrings {
	public List<List<String>> groupStrings(String[] strings) {
		
		Map<String,List<String>> map = new HashMap<>();
		for(String s : strings) {
			int[] count = new int[s.length()];
			for(int j=0;j<s.length()-1;j++) {
				count[j] =s.charAt(j+1)-s.charAt(j) <0 ? s.charAt(j+1)-s.charAt(j)+26 : s.charAt(j+1)-s.charAt(j);
			}
			String keystr = Arrays.toString(count);
			List<String> list = map.getOrDefault(keystr,new ArrayList<String>());
			list.add(s);
			map.put(keystr,list);
		}
		return new ArrayList<>(map.values());
	}
	
	public static void main(String[] args) {
		LeetCode249_GroupShiftStrings re = new LeetCode249_GroupShiftStrings();
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> list = re.groupStrings(strings);
		for(List<String> lists :list) {
			for(String s :lists) {
				System.out.print(s+ " , ");
				
			}
			System.out.println("\n");
		}
	}

}
