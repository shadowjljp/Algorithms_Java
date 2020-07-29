package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
public static int lengthOfLongestSubstring(String s) {
        
        char[] result;
        result = s.toCharArray();
        Set set = new HashSet();
        for(int i=0;i<result.length;i++) {
        	set.add(result[i]);
        }
        
		return set.size();
        
        
    }
	public static void main(String[] args) {
		
	}

}
