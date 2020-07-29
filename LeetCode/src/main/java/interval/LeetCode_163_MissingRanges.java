package interval;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_163_MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<>();
		if (lower >= upper) {
			return list;
		}
		int j = lower;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < j) {
				continue;
			}
			if (nums[i] == j) {
				j++;
				continue;
			}
			list.add(getRange(j, nums[i] - 1));
			j = nums[i] + 1;
		}
		if(j<=upper) {
			list.add(getRange(j, upper));
		}
		return list;

	}

	private String getRange(int j, int num) {
		// TODO Auto-generated method stub
		return j == num ? j + "" : j + "->" + num;
	}

	public static void main(String[] args) {
		LeetCode_163_MissingRanges re = new LeetCode_163_MissingRanges();
		List<String> result = re.findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99);
		for (String s : result) {
			System.out.println(s);
		}
	}

}
