package string;

public class LongestCommonPrefix_14 {

	   public String longestCommonPrefix(String[] strs) {
		    if (strs.length == 0) return "";
		    String prefix = strs[0];
		    for (int i = 1; i < strs.length; i++)
		        while (strs[i].indexOf(prefix) != 0) {
		            prefix = prefix.substring(0, prefix.length() - 1);
		            if (prefix.isEmpty()) return "";
		        }        
		    return prefix;
		}
	public static void main(String[] args) {
		String gfg = new String("Welcome"); 
		  System.out.println(gfg.indexOf(""));
		  System.out.println(gfg.substring(0,1));
		  LongestCommonPrefix_14 L = new LongestCommonPrefix_14();
		  String[] strs= {"flower","flow","flight"};
		  L.longestCommonPrefix(strs);
	}
}
