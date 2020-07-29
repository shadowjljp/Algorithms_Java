package dp;

public class InterleavingString {
	 public boolean isInterleave(String s1, String s2, String s3) {
		 int n1 = s1.length();
	        int n2 = s2.length();
	        int n3 = s3.length();
	        return helper(s1,0,s2,0,s3,0);
	 }
	private boolean helper(String s1, int i, String s2, int j, String s3, int k) {
			if(k==s3.length()) return true;
			char c1 =s1.charAt(i);
			char c2 = s2.charAt(j);
			char c3 = s3.charAt(k);
			if(c3==c1 && c3==c2) {
				boolean a = helper(s1,  i+1,  s2,  j,  s3, k+1);
				boolean b= helper(s1,  i,  s2,  j+1,  s3, k+1); 
				return  a|| b;
			}else if(c3==c1) {
				return helper(s1,  i+1,  s2,  j,  s3, k+1);
			}else if(c3==c2) {
				return helper(s1,  i,  s2,  j+1,  s3, k+1); 
			}else {
				return false;
			}

	}
	public static void main(String[] args) {
		InterleavingString re = new InterleavingString();
		String s1="aabcc";
		String s2 ="dbbca";
		String s3 ="aadbbcbcac";
//		String s1="";
//		String s2 ="db";
//		String s3 ="db";
		System.out.println(re.isInterleave(s1, s2, s3));
		
	}

}
