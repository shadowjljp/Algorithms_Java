package trie;

import java.util.ArrayList;
import java.util.List;

public class Word_seartchII {
	 class TrieNode{
	        TrieNode[] child = new TrieNode[26];
	        String word;
	    }
	    public List<String> findWords(char[][] board, String[] words) {
	        TrieNode root = new TrieNode();
	        List<String> res = new ArrayList<>();
	        addNode(root,words);
	        StringBuilder sb = new StringBuilder();
	         for (int i = 0; i < board.length; i++) {
	           for (int j = 0; j < board[0].length; j++) {
	                helper(board,root, res,i,j);
	            }
	        }
	        return res;
	    }
	    public void helper(char[][] board,TrieNode node,List<String> res,int r,int c){
	        char ch = board[r][c];
	        if(ch=='#' ||node.child[ch-'a']==null) return;
	        node =node.child[ch-'a'];
	        if(node.word !=null){
	            res.add(node.word);
	            node.word=null;
	        }
	        
	        
	        
	        board[r][c]='#';
	        
	        if(r>0) helper(board,node,res,r-1,c);
	        if(r<board.length-1) helper(board,node,res,r+1,c);
	        if(c>0) helper(board,node,res,r,c-1);
	        if(c<board[0].length-1) helper(board,node,res,r,c+1);
	        board[r][c]=ch;    
	        
	    }
	    public void addNode(TrieNode root,String[] words){
	        for(String s:words){
	            TrieNode tn =root;
	            for(char c:s.toCharArray()){
	               if(tn.child[c-'a']==null){
	                   tn.child[c-'a']=new TrieNode();
	               }
	                tn=tn.child[c-'a'];
	            }
	            tn.word=s;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word_seartchII re =new Word_seartchII();
		System.out.println(re.findWords(new char[][]{{'a'}}, new String[] {"a"}));
	}

}
