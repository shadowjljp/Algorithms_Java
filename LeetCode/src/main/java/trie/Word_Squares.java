package trie;

import java.util.ArrayList;
import java.util.List;


public class Word_Squares {
	class TrieNode {
       boolean isWord;
       TrieNode[] child = new TrieNode[26];
    }
	
    public List<List<String>> wordSquares(String[] words) {
    	List<List<String>> squares = new ArrayList<List<String>>();
    	TrieNode root = new TrieNode();
    	buildTrie(root,words);
    	for(String word:words) {
    		List<String> list = new ArrayList<>();
    		list.add(word);
    		helper(word.length(),root,squares,list);
    	}
        return squares;
    }
    
  
    
	private void helper(int length, TrieNode root, List<List<String>> squares, List<String> list) {
		if(length==list.size()) {
			squares.add(new ArrayList<>(list));
			return;
		}
		String prefix = getPrefix(list);
		TrieNode node = searchNode(root,prefix);
		if(node==null) {
			return;
		}
		List<String> children = new ArrayList<>();
		getChildren(node,children,prefix);
		for(String child : children) {
			list.add(child);
			helper(length,root,squares,list);
			list.remove(list.size()-1);
		}
	}



	private void getChildren(TrieNode node, List<String> children,String prefix) {
		if(node.isWord) {
			children.add(prefix);
			return;
		}
		for(int i=0;i<26;i++) {
			if(node.child[i]!=null) {
				getChildren( node.child[i],children,prefix+(char) ('a'+i));
			}
		}
	}



	private TrieNode searchNode(TrieNode root, String prefix) {
		TrieNode tn = root;
		for(char c:prefix.toCharArray()) {
			if(tn.child[c-'a']==null) {
				return null;
			}
			tn=tn.child[c-'a'];
		}
		return tn;
	}



	private String getPrefix(List<String> list) {
		StringBuilder sb = new StringBuilder();
		int index = list.size();
		for(int i=0;i<index;i++) {
			char c = list.get(i).charAt(index);
			sb.append(c);
		}
		return sb.toString();
	}



	private void buildTrie(TrieNode root, String[] words) {
		TrieNode tn = root;
		for(String word:words) {
			for(char c:word.toCharArray()) {
				if(tn.child[c-'a']==null) {
					tn.child[c-'a']=new TrieNode();
				}
				tn =tn.child[c-'a'];
			}
			tn.isWord=true;
			tn=root;
		}
		
	}



	



	public static void main(String[] args) {
		Word_Squares re = new Word_Squares();
		String[] words = new String[] {"area","lead","wall","lady","ball"};
		List<List<String>> list = re.wordSquares(words);
		for(List<String> l: list) {
			for(String s:l) {
				System.out.println(s);
			}
			System.out.println();
		}


	}
	
}
