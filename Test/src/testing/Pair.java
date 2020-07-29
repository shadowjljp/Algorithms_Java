package testing;

public class Pair<T> {
		private String word1;
		private String word2;
		
		public String getWord1() {
			return word1;
		}
		public void setWord1(String word1) {
			this.word1 = word1;
		}
		public String getWord2() {
			return word2;
		}
		public void setWord2(String word2) {
			this.word2 = word2;
		}
		
	public static void main(String[] args) {
		Pair<String> pair = new Pair<>();
		pair.setWord1("CS");
		pair.setWord2("UTD");
		String result1 = pair.getWord1();
		String result2 = pair.getWord2();
		System.out.println("result1 = "+result1+"\nresult2 = "+result2);
	}

}
