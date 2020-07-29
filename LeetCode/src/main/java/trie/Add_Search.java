package trie;

public class Add_Search {
	 class TrieNode{
	        boolean isWord=false;
	        TrieNode[] child = new TrieNode[26];
	    }
	   
	    /** Initialize your data structure here. */
	        TrieNode root;
	    public Add_Search() {
	        root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        TrieNode tn =root;
	        for(char c:word.toCharArray()){
	            if(tn.child[c-'a']==null){
	               tn.child[c-'a']=new TrieNode(); 
	            }
	            tn = tn.child[c-'a'];
	        }
	        tn.isWord=true;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	    	char[] w =word.toCharArray();
	    	boolean re =match(w,0,root);
	         return re;
	    
	    }
	   private boolean match(char[] chs, int k, TrieNode node) {
	        if (k == chs.length) {
	            return node.isWord;
	        }
	        if (chs[k] == '.') {
	            for (int i = 0; i < node.child.length; i++) {
	                if (node.child[i] != null && match(chs, k + 1, node.child[i])) {
	                    return true;
	                }
	            }
	        } else {
	            return node.child[chs[k] - 'a'] != null && match(chs, k + 1, node.child[chs[k] - 'a']);
	        }
	        return false;
	    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_Search re = new Add_Search();
				re.addWord("bad");
				re.addWord("dad");
				re.addWord("mad");
				System.out.println(re.search(".ad"));
				System.out.println(re.search("b.."));
				System.out.println(re.search(".adz"));
	}

}
