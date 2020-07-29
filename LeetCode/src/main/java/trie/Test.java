package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	 class TrieNode{
	        TrieNode[] child = new TrieNode[26];
	        List<Integer> parlin = new ArrayList<>();
	        Integer pos =-1;
	    }
	    public List<List<Integer>> palindromePairs(String[] words) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        TrieNode node = new TrieNode();
	        for(int i=0;i<words.length;i++){
	            addNode(node,i,words[i]);
	        }
	        for(int i=0;i<words.length;i++){
	            search(node,i,words[i],res);
	        }
	        return res;
	        
	    }
	    public void addNode(TrieNode node ,int pos,String word){
	        for(int i=word.length()-1;i>=0;i--){
	            char c = word.charAt(i);
	            if(parlin(word,0,i)){
	                node.parlin.add(pos);
	            }
	            if(node.child[c-'a']==null){
	                node.child[c-'a']=new TrieNode();
	            }
	            node =node.child[c-'a'];
	        }
	        node.pos=pos;
	        node.parlin.add(pos);
	    }
	    public void search(TrieNode node,int pos,String word,List<List<Integer>> res){
	        for(int i=0;i<word.length()&&node !=null;i++){
	            if(node.pos !=-1 && pos!=node.pos && parlin(word,i,word.length()-1)){
	                res.add(Arrays.asList(new Integer[] {pos,node.pos}));
	            }
	            char c = word.charAt(i);
	          //  if(node.child[c-'a']==null) return;
	            node = node.child[c-'a'];
	            
	        }
	        if(node !=null && node.parlin.size()>0){
	            for(Integer j: node.parlin){
	                if(j!=pos)
	                res.add(Arrays.asList(new Integer[] {pos,j}));
	            }
	        }
	    }
	    public boolean parlin(String s,int i,int j){
	        while(j>i){
	            if(s.charAt(i)!=s.charAt(j)){
	                return false;
	            }
	            j--;i++;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		Test re= new Test();
	//	String[] words = {"abcd","dcba","lls","s","sssll"};
		String[] words = {"","behaci","aicidh","cdfeicf","fedihch","hebhci","bccfga","fbgdd","f","bc"};
		System.out.println(re.palindromePairs(words));
	}

}
