package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode271_Encode_and_Decode_Strings {
	 public String encode(List<String> strs) {
		 StringBuilder sb = new StringBuilder();
		 for(String s : strs) {
			 sb.append(s.length()).append("#").append(s);
		 }
		 return sb.toString();
	 }
	 public List<String> decode(String s) {
		 List<String> list = new LinkedList<>();
		 int start =0;
		 int end =0;
		 while(end<s.length()) {
			 if(s.charAt(end)=='#') {
			 int len = Integer.valueOf(s.substring(start,end));
				 list.add(s.substring(end+1,end+1+len));
				 start = end+1+len;
				 end =start;
			 }
				 end++;
		 }
		 return list;
	 }
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Leetcode271_Encode_and_Decode_Strings re = new Leetcode271_Encode_and_Decode_Strings();
		list.add("get");list.add("some"); list.add("egg");
		String str = re.encode(list);
		list = re.decode(str);
		for(String s: list) {
			System.out.println(s);
		}
	
	}

}
