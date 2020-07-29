package array;

public class SumII {
//https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1035/
	public int[] twoSum(int[] num, int target) {
	    int[] indice = new int[2];
	    if (num == null || num.length < 2) return indice;
	    int left = 0, right = num.length - 1;
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}
	public static void main(String[] args) {
		SumII res = new SumII();
		int[] numbers = {2,7,11,15};
		int target=9;
		int[] result = res.twoSum(numbers, target);
		
		for(int r:result)
		System.out.println(r);
	}

}
