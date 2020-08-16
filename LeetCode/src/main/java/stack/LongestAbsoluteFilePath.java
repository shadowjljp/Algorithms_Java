package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {
	 public int lengthLongestPath(String input) {
	       Deque<Integer> stack = new ArrayDeque<>();
	        stack.push(0); // "dummy" length
	        int maxLen = 0;
	        for(String s:input.split("\n")){
	            int lev = s.lastIndexOf("\t")+1; // number of "\t"
	            System.out.println(lev);
	            while(lev+1<stack.size()) stack.pop(); // find parent
	            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
	            stack.push(len);
	            // check if it is file
	            if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
	        }
	        return maxLen;  
	    }
	public static void main(String[] args) {
		LongestAbsoluteFilePath re=  new LongestAbsoluteFilePath();
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(re.lengthLongestPath(input));
	}

}
