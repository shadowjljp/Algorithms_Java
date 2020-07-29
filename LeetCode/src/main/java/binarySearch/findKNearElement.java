package binarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class findKNearElement {
	public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return (List<Integer>) Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }
	public static void main(String[] args) {
		findKNearElement re= new findKNearElement();
		List<Integer>  list =re.findClosestElements(new int[] {1,2,3,4,5}, 4, 5);
		for(Integer l: list) {
			System.out.println(l);
		}
	}

}
