package tw.leetcode.utd.tw.leetcode.utd.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;

public class Word_Ladder {
	  //Queue to store the words next to be visit and have not been //visited
    Queue<Pair<String,Integer>> Q_begin = new LinkedList<>();
      Queue<Pair<String,Integer>> Q_end = new LinkedList<>();
      int L =0; //wordLength
  HashMap<String,ArrayList<String>> globalDict = new HashMap<>();
  
  //BFS
  public int BFS( Queue<Pair<String,Integer>> Q, HashMap<String,Integer> visited,HashMap<String,Integer> othersVisited,List<String> wordList){
      
      Pair<String,Integer> pair = Q.remove();
      String curr_word = pair.getKey();
      int level =pair.getValue();
      
      for(int i=0;i<L;i++){
        String wordKey = curr_word.substring(0,i)+"*"+curr_word.substring(i+1,L);
          for(String matchWord:globalDict.getOrDefault(wordKey,new ArrayList<String>())){
              if(othersVisited.containsKey(matchWord)){
                   return level+othersVisited.get(matchWord);
              
              }
                 
              if(!visited.containsKey(matchWord)){
                  visited.put(matchWord,level+1);
                  Q.add(new Pair(matchWord,level+1));
              }
          }
      }
      return -1;
  }
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       if(!wordList.contains(endWord)){
          return 0;
      }
       L=beginWord.length();
      wordList.forEach(
      word -> {for(int i=0;i<L;i++){
            String temp = word.substring(0,i)+"*"+word.substring(i+1,L);
          
          ArrayList<String> group = globalDict.getOrDefault(temp,new ArrayList<String>());
          group.add(word);
          globalDict.put(temp,group);
      }
              });
     
   HashMap<String,Integer> visited = new HashMap<>();
       HashMap<String,Integer> othersVisited = new HashMap<>();
             Q_begin.add(new Pair(beginWord,1));
      visited.put(beginWord,1);
     
   
      Q_end.add(new Pair(endWord,1));
      
      othersVisited.put(endWord,1);
      //visited? boolean to record the word has been visited
     
      
      //ex dog => d*g as key and value will be all the words with the           //same key
      while(!Q_begin.isEmpty() && !Q_end.isEmpty()){
           int ans =BFS(Q_begin,visited,othersVisited,wordList);
      if(ans>-1){
          return ans;
      }
      
      ans = BFS(Q_end,othersVisited,visited,wordList);
      if(ans>-1){
          return ans;
      }
      }
     
  return 0;
  }
	public static void main(String[] args) {
		Word_Ladder w = new Word_Ladder();
		String a="a",b="c";
		ArrayList<String> re = new ArrayList<String>();
		re.add("a");
		re.add("b");
		re.add("c");
		
	System.out.println(w.ladderLength(a,b,re));	
	}

}
