package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode186_reverseStringII {
	public void reverseWords(char[] s) {
		/*
		if(s.length ==0) return ;
		reverse(s,0,s.length-1);
		int left =0;
		for(int i=0;i<=s.length;i++) {
			if( i==s.length || s[i]==' ' ) {
				reverse(s,left,i-1);
				left=i+1;
			}
		}
	}
	public void reverse(char[] s,int l,int r) {
		while(l<r) {
			char temp =s[l];
			s[l]=s[r];
			s[r] =temp;
			l++;
			r--;
		}*/
		String st = new String(s);
		String[] str = st.split(" +");
		List<String> list = Arrays.asList(str);
		Collections.reverse(list);
	
		
		s= list.toString().toCharArray();
		for(char c:s) {
			System.out.print(c);
		}
	}
	
		
	public static void main(String[] args) {
		LeetCode186_reverseStringII re = new LeetCode186_reverseStringII();
		char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		re.reverseWords(s);
		for(char r:s) {
			System.out.print(r);
		}
		
	}

}
