package recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generate_Parentheses {
 	
	public List<String> generateParenthesis(int n) {
//      List<String> list = new ArrayList<String>();
//      backtrack(list, "", 0, 0, n);
//      return list;
		List< List<String>> res = new ArrayList<>();
		res.add(Collections.singletonList(""));
		for(int i=1;i<=n;i++) {
			 List<String> list = new ArrayList<>();
			for(int j=0;j<i;j++) {
				for(final String first:res.get(j)) {
					for(final String second:res.get(i-j-1)) {
						list.add("("+first+")"+second);
					}
				}
				
			}
			res.add(list);
		}
		return res.get(res.size()-1);
  }
    
//    public void backtrack(List<String> list, String str, int open, int close, int max){
//        
//        if(str.length() == max*2){
//            list.add(str);
//            return;
//        }
//        
//        if(open < max)
//            backtrack(list, str+"(", open+1, close, max);
//        if(close < open)
//            backtrack(list, str+")", open, close+1, max);
//    }
	public static void main(String[] args) {
		Generate_Parentheses re = new Generate_Parentheses();
		re.generateParenthesis(3);
	}

}
