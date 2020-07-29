package string;

import java.util.ArrayList;
import java.util.List;

public class LeetCode293_FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list =  new ArrayList<>();
		for(int i=0;i<s.length()-1;i++) {
			 if(s.charAt(i)=='+' && s.charAt(i+1)=='+') {
				 list.add(s.substring(0,i)+"--"+s.substring(i+2));
			 }
			
		}
		return list;
	}
	public static void main(String[] args) {
		LeetCode293_FlipGame re = new LeetCode293_FlipGame();
		String s = "++++";
		List<String> list = re.generatePossibleNextMoves(s);
		for(String st :list) {
			System.out.print(st);
			System.out.println();
		}
	}

}
