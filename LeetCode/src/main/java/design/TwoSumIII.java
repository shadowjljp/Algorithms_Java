package design;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {
	Map<Integer,Integer> map = new HashMap<>();
	 public void add(int number) {
		 map.put(number, 1);
	 }
	 public boolean find(int value) {
		 for(Integer key : map.keySet()) {
			 if(2*key ==value && map.get(key)>=2) {
				 return true;
			 }
			 if(map.containsKey(value - key) && 2 * key !=value) {
				 return true;
			 }
		 }
		 return false;
		
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
