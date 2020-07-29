package trie;
class TrieNode{
    TrieNode[] child = new TrieNode[26];
    int value;
    TrieNode(int i){
        value=i;
    }
   
}
public class Map_Sum_Pairs {
	  TrieNode root;
	    /** Initialize your data structure here. */
	    public Map_Sum_Pairs() {
	        root=new TrieNode(0);
	    }
	    
	    public void insert(String key, int val) {
	        TrieNode tn =root;
	        for(int i=0;i<key.length();i++){
	            char c = key.charAt(i);
	            if(tn.child[c-'a']==null){
	                tn.child[c-'a']=new TrieNode(0);
	            }
	            tn = tn.child[c-'a'];
	        }
	        tn.value=val;
	    }
	    
	    public int sum(String prefix) {
	        TrieNode tn =root;
	        for(int i=0;i<prefix.length();i++){
	            char c = prefix.charAt(i);
	            if(tn.child[c-'a']==null){
	               return 0;
	            }
	            tn = tn.child[c-'a'];
	        }
	        return helper(tn);
	    }
	      int res=0;
	    public int helper(TrieNode root){
	    	if(root ==null) return 0;
	     
	        for(int i=0;i<26;i++){
	            if(root.child[i]!=null){
	                res += helper(root.child[i]);
	            }
	        }
	        return res+root.value;
	    }
	public static void main(String[] args) {
		Map_Sum_Pairs re = new Map_Sum_Pairs();
		re.insert("apple", 3);
		re.insert("app", 2);
		
		System.out.println(re.sum("ap"));
	}

}
