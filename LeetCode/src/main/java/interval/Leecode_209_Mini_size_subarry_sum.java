package interval;

public class Leecode_209_Mini_size_subarry_sum {
	public int minSubArrayLen(int s,int[] nums) {
		int j=0;
		int mini = nums.length+1;
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			while(sum>=s) {
				int new_mini =i-j+1;
				if(mini>= new_mini) {
					mini = new_mini;
					sum -=nums[j];
					j++;
					
				}
			}
		}
		
		return mini;
	}
	public static void main(String[] args) {
		Leecode_209_Mini_size_subarry_sum re = new Leecode_209_Mini_size_subarry_sum();
		int s=7;
		int[] nums= {2,3,1,2,4,3};
		System.out.println(re.minSubArrayLen(s, nums));
		
	}

}
