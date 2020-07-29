package array;

import java.util.ArrayList;
import java.util.HashMap;


public class WordDistance { //WordDistance ii two words can not be the same.
	HashMap<String,ArrayList<Integer>> location = new HashMap<>();
	
	// prepare constructor and map the location of the words into array as value and word itself as key.
	WordDistance(String[] word){
		for(int i=0;i<word.length;i++) {
			ArrayList<Integer> position = location.getOrDefault(word[i], new ArrayList<Integer>());
			position.add(i);
			this.location.put(word[i],position);
		}
	}
	
	public int shortest(String word1,String word2) {
		//pointer
		int l = 0,r =0;
		int mini_distance = Integer.MAX_VALUE;
		ArrayList<Integer> v1 = location.get(word1);
		ArrayList<Integer> v2 = location.get(word2);
		
		//WordDistance iii if word1 and word2 are the same.
		if(word1.equals(word2)) {
			int mini = Integer.MAX_VALUE;
			for(int i=0;i<v1.size()-1;i++) {
				int temp = v1.get(i+1)-v1.get(i);
				if(temp<mini) {
					mini=temp;
				}
			}
			return mini;
		}  
		// WordDistance iii ends here
		while(l<v1.size() && r<v2.size()) {
			mini_distance = Math.min(Math.abs(v1.get(l)-v2.get(r)), mini_distance);
			if(v1.get(l)<v2.get(r)) {
				l++;
			}else if(v1.get(l)>v2.get(r)) {
				r++;
			}
		}
		
				
		return mini_distance;
		
	}
	public static void main(String[] args) {
		String[] words = {"apple","orange","banana","apple","orange","pineapple"};
		WordDistance word = new WordDistance(words);
		System.out.println(word.shortest("apple", "apple"));
		
		}
}
