package trie;

import java.util.HashMap;
import java.util.Map;

public class Implementation {
	   boolean isWord;
	    Map<String,Boolean> map;
	    /** Initialize your data structure here. */
	    public Implementation() {
	        isWord=false;
	         map = new HashMap<>();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        if(map.containsKey(word)){
	             map.put(word,true);
	             return;
	        }
	        for(int i=1;i<word.length()+1;i++){
	            String s =word.substring(0,i);
	            if(!map.containsKey(s)){
	                while(i<=word.length()){
	                   if(i==word.length()){
	                    map.put(word,true);
	                    return; 
	                   }
	                    
	                    map.put(word.substring(0,i),false);
	                    i++;
	                  
	                }
	            }
	        }
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        return map.get(word)==null ? false : map.get(word);
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        return map.containsKey(prefix);    }

	public static void main(String[] args) {
		Implementation re = new Implementation();
		String word= "abc";
		re.insert(word);
		re.insert("app");
		re.insert("apple");
		re.insert("add");
		System.out.println(re.search("app"));
	}

}
