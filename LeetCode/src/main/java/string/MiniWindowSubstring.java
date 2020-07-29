package string;

import java.util.HashMap;

public class MiniWindowSubstring {
	 public String minWindow(String s, String t) {
	        if(s.length() ==0 || t.length() ==0){
	            return "";
	        }
	        
	        HashMap<Character,Integer> dictT = new HashMap<>();
	        for(int i=0;i<t.length();i++){
	            int count = dictT.getOrDefault(t.charAt(i),0);
	            count++;
	            dictT.put(t.charAt(i),count);
	        }
	        
	        //how many unique character we need to have in window
	        int goal = dictT.size();
	        
	        //store windows unique character
	        HashMap<Character,Integer> windows = new HashMap<>();
	        
	        //two index
	        int l=0,r=0;
	        
	        //number of character satisfied so far.
	        int score =0;
	        
	        //length,start,end
	        int[] a = {-1,0,0};
	        
	        while(r<s.length()){
	            char c = s.charAt(r);
	            int temp = windows.getOrDefault(c, 0);
	            temp++;
	            windows.put(c, temp);
	            if(dictT.containsKey(c)&&dictT.get(c).intValue() == windows.get(c).intValue()){
	                score++;
	            }
	            while(score == goal && l <=r){
	                c = s.charAt(l);
	                if(a[0]==-1 || r-l+1<a[0]) {
	                	 a[0]=r-l+1;
	 	                a[1] = l;
	 	                a[2]=r;
	                }
	               temp = windows.get(c);
	               temp--;
	               windows.put(c,temp);
	                //miss character in windows
	                if(dictT.containsKey(c)&&dictT.get(c).intValue() >  windows.get(c).intValue()){
	                    score--;
	                }
	            l++;
	            }
	            r++;
	        }
	        return a[0]>-1 ? s.substring(a[1],a[2]+1) : "";
	    }
	public static void main(String[] args) {
		MiniWindowSubstring m = new MiniWindowSubstring();
		System.out.println(m.minWindow("aaaaaaaaaaaabbbbbcdd", 
				"abcdd")); 
	}

}
