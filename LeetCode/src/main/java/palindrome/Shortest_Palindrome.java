package palindrome;

public class Shortest_Palindrome {
	   public String shortestPalindrome(String s) {
		   int j = 0;
		    for (int i = s.length() - 1; i >= 0; i--) {
		        if (s.charAt(i) == s.charAt(j)) { j += 1; }
		    }
		    if (j == s.length()) { return s; }
		    String suffix = s.substring(j);
		    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	    }
	public static void main(String[] args) {
		Shortest_Palindrome re= new Shortest_Palindrome();
		System.out.println(re.shortestPalindrome("aacaa"));
		
			char c='!';
			if(c>='0'&&c-'0'<10)
			System.out.println("success");
		
		
	}

}
