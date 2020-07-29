package sort;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (i % 2 == 0 && nums[i] > nums[i + 1] || i % 2 == 1 && nums[i] < nums[i + 1]) {
				int temp = nums[i + 1];
				nums[i + 1] = nums[i];
				nums[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		WiggleSort re = new WiggleSort();
		int[] nums = { 3, 5, 2, 1, 6, 4 };

		re.wiggleSort(nums);

		for (int n : nums) {
			System.out.print(n + " , ");
		}
	}

}
