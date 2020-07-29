package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode247_Strobogrammatic_Number_II {
	
	//recursion
//	public List<String> findStrobogrammatic(int n) {
//		return helper(n,n);
//		
//	}
	public List<String> helper(int n,int m){
		if(n==0) return new ArrayList<String>(Arrays.asList(""));
		if(n==1) return new ArrayList<String>(Arrays.asList("0","1","8"));
		
		List<String> list = helper(n-2,n);
		List<String> res = new ArrayList<>();
		
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			if(n != m) res.add("0"+s+"0");
			res.add("1"+s+"1");
			res.add("8"+s+"8");
			res.add("6"+s+"9");
			res.add("9"+s+"6");
		}
		return res;
		
	}
	//Iterative
	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<>();
		if((n&1) ==1) {
			res.add("1");
			res.add("8");
			res.add("0");
		}
		int i= (n&1)==0 ? 2:3;
		for(;i<=n;i+=2) {
			ArrayList<String> temp = new ArrayList<>();
			for(String s : res) {
				if(i !=n) temp.add("0"+s+"0");
				temp.add("1"+s+"1");
				temp.add("8"+s+"8");
				temp.add("9"+s+"6");
				temp.add("6"+s+"9");
			}
			res = temp;
		}
		return res;
		
	}
	public static void main(String[] args) {
		LeetCode247_Strobogrammatic_Number_II re = new LeetCode247_Strobogrammatic_Number_II();
		List<String> list = re.findStrobogrammatic(5);
		int count =1;
		for(String s: list) {
			System.out.println("count = "+count +" s= "+ s);
			count++;
		}
		
	}

}
