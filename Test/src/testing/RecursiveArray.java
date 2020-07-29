package testing;

public class RecursiveArray {
	static int count=0;

	public static int arrayRecur(int[] arr, int position) {

		if (position > -1 && position < arr.length) {
			if (arr[position] % 2 == 1) {
				count++;
			}
			arrayRecur(arr, position + 1);
			// return count;
		}
		return count;

	}

	public static void main(String[] args) {
		int arr[] = new int[5];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		int position = 0;
		int result = arrayRecur(arr, position);

		if (position < 0 || position > arr.length) {
			System.out.println("Position should be within the array`s length");
		} else {
			System.out.println("result= " + result);
		}

	}

}
