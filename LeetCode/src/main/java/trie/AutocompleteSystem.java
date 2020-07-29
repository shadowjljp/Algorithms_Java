package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AutocompleteSystem {
	String str;
	Trie curr;
	Trie root;
	class Trie{
		Trie[] child;
		int times;
		Trie(){
			child=new Trie[27];
			times=0;
		}
	}
	class Pair{
		String str;
		int times;
		public Pair(String s, int t) {
            str = s;
            times = t;
        }
	}
	public AutocompleteSystem(String[] sentences, int[] times) {
		 root = new Trie();
		//insert
		for(int i=0;i<sentences.length;i++) {
			insert(root,sentences[i],times[i]);
		}
		this.curr=root;
		this.str="";
	}
	
	private void insert(Trie root, String string, int times) {
		Trie node =root;
		for(int i=0;i<string.length();i++) {
			int index = getIndex(string.charAt(i));
			if(node.child[index]==null) {
				node.child[index] = new Trie();
			}
			node =node.child[index];
		}
		node.times+=times;
	}

	private int getIndex(char charAt) {
		// TODO Auto-generated method stub
		int re = charAt == ' ' ? 26 : charAt-'a';
		return re;
	}

	//input
	public List<String> input(char c) {
		ArrayList<String> list = new ArrayList<>();
		if(c=='#') {
			insert(root,str,1);
			curr=root;
			str="";
			return list;
		}
		int index = getIndex(c);
		curr= curr.child[index];
		str+=c;
		
		return getKHot(curr,str,3);
	}
	//getKhot
	
	private List<String> getKHot(Trie node, String s, int k) {
		List<Pair> list = new ArrayList<>();
		dfs(list,node,s);
		Collections.sort(list,(a,b)->(a.times !=b.times ? b.times-a.times : a.str.compareTo(b.str)));
		List<String> res = new ArrayList<>();
		for(int i=0;i<Math.min(k,list.size());i++) {
			res.add(list.get(i).str);
		}
		return res;
		
		
	}
	//dfs
	private void dfs(List<Pair> list, Trie node, String s) {
		if(node.times>0) {
			list.add(new Pair(s,node.times));
		}
		for(char i='a';i <='z';i++) {
			int c =getIndex(i);
			if(node.child[c]!=null)
			dfs( list,  node.child[c], s+i);
		}
		if(node.child[26]!=null) {
			dfs( list,  node.child[26], s+" ");
		}
	}

	
	public static void main(String[] args) {
		String[] sen = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem re = new AutocompleteSystem(sen,times);
		
		List<String> res = re.input('i');
		for(String s:res) {
			System.out.println(s);
		}
	}

}
