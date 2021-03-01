package number;

import java.util.ArrayList;
import java.util.List;

public class NumberJP {
	public List<Integer> number(int input1,int input2){
		List<Integer> res = new ArrayList<>();
		//find the length of number
/*		int start=0,end=0;
		while(input1!=0) {
			input1 /=10;
			start++;
		}
		while(input2!=0) {
			input2/=10;
			end++;
		}*/
		
		for(int i=input1;i<=input2;i++) {
			String s = i+"";
			boolean[] check = new boolean[10];
			boolean[] scroll = new boolean[s.length()];
		
			List<Integer> arr = new ArrayList<>();
			List<Integer> newArr = new ArrayList<>();
			for(int j=0;j<s.length();j++) {
				//check repeat
				
				if(check[s.charAt(j)-'0']==true) break;
				check[s.charAt(j)-'0']=true;	
				arr.add(j,s.charAt(j)-'0');
			}
			if(arr.size() !=s.length()) {
				continue;
			}
			for(int j=0;j<arr.size();j++) {
				newArr.add(-1);
			}
			//scroll
			int index=0;
			int k=0;
			for(k=0;k<s.length();k++) {
				if(scroll[index]==true) {
					break;
				}
				if(index !=0) scroll[index]=true;
				int newP = arr.get(index)+index;
				newP= newP%arr.size();
				if(index==newP ) break;
				if(scroll[newP]==true  ) break;
				newArr.set(newP,arr.get(index));
				index=newP;
			}
		
			
			if(k == s.length()) {
				String temp = "";
				for(int w:arr) {
					temp +=w+"";
				}
				//System.out.println(temp);
				res.add(Integer.parseInt(temp));
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		NumberJP re = new NumberJP();
		
		
//		System.out.println(1%1);
		List<Integer> res = re.number(1000,2000);
		
		for(Integer r:res)
		System.out.println(r);
	}

}
