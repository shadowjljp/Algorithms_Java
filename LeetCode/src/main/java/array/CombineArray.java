package array;

public class CombineArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m+n-1;
      int length1 = m-1;
          int length2 = n-1;
          while(length2>=0){
              if(length1>=0){
            	  int temp = end--;
                    nums1[temp] = nums1[length1]> nums2[length2] ?   nums1[length1--] : nums2[length2--] ;   
              }else{
            	  int temp = end--;
                  nums1[temp] = nums2[length2--];
              }
                 
          }
      }
	public static void main(String[] args) {
		CombineArray c = new CombineArray();
		int[] nums1 = {1,2,3,0,0,0};
		int m=		3;
		int[] nums2 = {2,5,6};
		int n =		3;
		c.merge(nums1, m, nums2, n);
		for(int a: nums1) {
			System.out.print(a +",");
		}
	}

}
