package string;

public class LeetCode246_Strobogrammatic_Number {
	 public boolean isStrobogrammatic(String num) {
		 int i=0,j=num.length()-1;
		 while(j>i) {
			 if(num.charAt(i)==num.charAt(j)) {
				 if(num.charAt(i) !='1' && num.charAt(i) !='0' && num.charAt(i) !='8') {
					 return false;
				 }
			 }else {
				 if(num.charAt(i) =='6' && num.charAt(j) !='9'|| num.charAt(i) =='9' && num.charAt(j) !='6') {
					 return false;
				 }
			 }
			 j--;
			 i++;
		 }
		 return true;
	 }
	public static void main(String[] args) {
		LeetCode246_Strobogrammatic_Number re = new LeetCode246_Strobogrammatic_Number();
		System.out.println(re.isStrobogrammatic("88"));
	}

}
