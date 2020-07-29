package trie;

import java.util.ArrayList;
import java.util.List;

public class Replace_Words {
	class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean isDict;
    }
    TrieNode root;
    Replace_Words(){
        root = new TrieNode();
    }
    public String replaceWords(List<String> dict, String sentence) {
        putDictInTrie(dict);
        TrieNode tn = root;
        StringBuilder sb = new StringBuilder();
        String[] stringList = sentence.split(" ");
        for(String s:stringList){
 //              System.out.println(s);
            sb.append(shortestString(s));
            sb.append(" ");
            tn=root;
        }
     return sb.toString().substring(0,sb.length()-1);
    }
    private String shortestString(String s) {
    	StringBuilder sbs = new StringBuilder();
    	TrieNode tn =root;
    	  for(int i=0;i<s.length();i++){
              char c = s.charAt(i);
              sbs.append(c);
          if(tn.child[c-'a']==null){
              return s;
          }else{
              if(tn.child[c-'a'].isDict){
                  return sbs.toString();
              }
              tn=tn.child[c-'a'];
              }
              
          }
    	return sbs.toString();
	}
	public void putDictInTrie(List<String> dict){
        TrieNode tn =root;
        for(String s: dict){
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(tn.child[c-'a']==null){
                    tn.child[c-'a']=new TrieNode();
                }
                tn=tn.child[c-'a'];
            }
            tn.isDict=true;
            tn=root;
        }
    }
	
	public static void main(String[] args) {
		Replace_Words re = new Replace_Words();
		List<String> list = new ArrayList<>();
		list.add("cat");
		list.add("bat");
		list.add("rat");
String sen = "the cattle was rattled by the battery";
		System.out.println(re.replaceWords(list,sen));
	}
}
