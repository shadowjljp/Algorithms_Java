package tree;

import java.util.ArrayList;

public class tester {
	public boolean isMirror(int a,int b){
		return a==b;
	}
	public static void main(String[] args) {
		String User = "1";
		String Friend = "2";
		String FriendPair = (Integer.parseInt(User) < Integer.parseInt(Friend))?User+"\t"+Friend:Friend+"\t"+User;
		ArrayList<String> temp = new ArrayList<String>(FriendsList);
		temp.remove(Friend); 
		String listString = String.join(",", temp);
	}

}
