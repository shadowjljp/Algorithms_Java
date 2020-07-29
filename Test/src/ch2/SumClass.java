package ch2;

public class SumClass {

		public static int sum(int arr[],int left, int right) {
			if(left==right) {
				return arr[left];
				
			}else {
				int center = (left+right)/2;
				int leftsum = sum(arr,left,center);
				int rightsum=sum(arr,center+1,right);
				return leftsum+rightsum;
			}
		}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		int mysum = sum(arr,0,arr.length-1);
		System.out.println("The sum is: "+mysum);
	}

}
