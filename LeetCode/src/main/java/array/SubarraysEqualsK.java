package array;

public class SubarraysEqualsK {
    public int subarraySum(int[] nums, int k) {
        //1 2 3  k=3  res =5
        //l r start from 0, if nums[l] < k : r = l+1, check nums[r] + nums[l];
        //l= 2 r =2 sum =3  res=2   k=3
        int l=0, r=0;
        int res=0;
        for(r = 0;r < nums.length;){
            int sum = 0;
            sum += nums[l];
            while(sum <= k && r < nums.length){
                if(sum == k){
                    res++;
                    break;
                }
                r++;
                if(r < nums.length)
                    sum += nums[r];
            }
            l = r;
            if( l==r && l==nums.length-1) break;
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraysEqualsK re = new SubarraysEqualsK();
        int[] nums = new int[]{1,2,3};
        int k =3;
        re.subarraySum(nums,k);
    }
}
