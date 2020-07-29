package testing;

import java.util.ArrayList;
import java.util.HashMap;

public class hush {
	int[] ar= new int[] {3823,8806, 8783, 2850, 3593, 8479, 1941, 4290, 8818, 7413};
	HashMap<Integer,Integer> map = new HashMap<>();
	public void linear_prob() {
		
		//int[] ar= new int[] {50, 700, 76, 85, 92, 73, 101};
				for(int a:ar) {
					int r=a%13;
					//int r=a%7;
					System.out.print(a+" with "+r+",\n");
				}
	}
	public void quadratic_prob() {
		int i=1;
		//int[] ar= new int[] {50, 700, 76, 85, 92, 73, 101};
				for(int num:ar) {
					int key=num%13;
					if(!map.containsKey(key)) {
						map.put(key, num);
						System.out.print(map.get(key)+" with "+key+",\n");
					}else {
						quadratic_collid(num,i);
					}
					//int r=a%7;
				}
	}
	public int quadratic_collid(int num,int i) {
		int key=(int) ((num+Math.pow(i, 2))%13);
		if(!map.containsKey(key)) {
			map.put(key, num);
			System.out.print(map.get(key)+" with "+key+",\n");
		}else {
			i++;
			quadratic_collid(num,i);
		}
		return 0;
		
	}
	public void doubleHushing() {
		int i=1;
		//int[] ar= new int[] {50, 700, 76, 85, 92, 73, 101};
				for(int num:ar) {
					int key=num%13;
					if(!map.containsKey(key)) {
						map.put(key, num);
						System.out.print(map.get(key)+" with "+key+",\n");
					}else {
						collid(key,num,i);
					}
					//int r=a%7;
				}
	}
	private void collid(int orginalKey,int num, int i) {
		int key1=(int) 11-(num%11);
		int key = key1*i+orginalKey;	
		if(!map.containsKey(key)) {
			map.put(key, num);
			System.out.print(map.get(key)+" with "+key+",\n");
		}else {
			i++;
			collid(orginalKey,num,i);
		}
		
	}
	public static void main(String[] args) {
		hush hush = new hush();
		//hush.doubleHushing();
		hush.quadratic_prob();
		
	//	hush.linear_prob();
		
	}

}
