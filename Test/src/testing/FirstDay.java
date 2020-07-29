package testing;

public class FirstDay {
	
	public static void main(String args[]) {
		int arr[] =new int[5];
		arr[0]=5;
		arr[1]=10;
		arr[2]=15;
		arr[3]=20;
		arr[4]=25;
		int sum=0;
		
		for( int i =0;i<arr.length;i++) {
			sum+=arr[i];
		}
		
		for( int i : arr) {
			sum+=i;
		}
		System.out.print(sum);
	}

}
