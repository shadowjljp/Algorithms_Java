package array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // 0 1 2 3 4 5
        // 3 4 -1 1
        // -1 4 3 1
        // -1 1 3 4
        //  1 0 3 4
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i] >0 && nums[i]-1 < n && nums[i]-1 != i){
                //exchange nums[nums[i]-1] and nums[i]
                int value = nums[i]-1;
                int temp = nums[value];
                nums[value] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]-1 != i){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive re = new FirstMissingPositive();
        int[] nums = new int[]{1};
        int res = re.firstMissingPositive(nums);
        System.out.println(res);
    }
}
