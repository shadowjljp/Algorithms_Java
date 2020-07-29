package string;

public class LeetCode294_FlipGame2 {
	public boolean canWin(String s) {
		char[] c = s.toCharArray();
		for(int i=0;i<c.length-1;i++) {
			if(c[i]=='+' && c[i+1]=='+') {
				c[i]='-';
				c[i+1]='-';
				boolean win = canWin(new String(c));
				
				if(!win) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		LeetCode294_FlipGame2 re = new LeetCode294_FlipGame2();
		String s = "++++";
		boolean b= re.canWin(s);
		System.out.println(b);
}

}
	