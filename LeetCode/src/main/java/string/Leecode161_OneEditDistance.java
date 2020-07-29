package string;

public class Leecode161_OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if(s.length()<t.length()-1 || s.length()>t.length()+1) return false;
		
		//Handle the replacement part;
				int diff=0;
				boolean replacement = true;
				for(int i=0;i<s.length() && i<t.length();i++) {
					if(s.charAt(i) != (t.charAt(i))) {
						diff++;
					}
					if(diff==2) replacement= false;
				}
		
		int[] arr = new int[256];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)]++;
			
		}
		for(int i=0;i<t.length();i++) {
			arr[t.charAt(i)]--;
			
		}
		 diff =0;
		 boolean rest = true;
		for(int a :arr) {
			if(a !=0) {
				diff++;
			}
			if(diff==2) rest= false;
		}
		
		return (rest || replacement);
	}
	
	public static void main(String[] args) {
		Leecode161_OneEditDistance re = new Leecode161_OneEditDistance();
		String s = "cab";
		String t ="ad";
		System.out.println(re.isOneEditDistance(s, t));
	}

}
