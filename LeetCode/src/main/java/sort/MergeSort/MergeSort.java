package sort.MergeSort;

public class MergeSort {

	public static void main(String[] args) {
		 int arr[] = {5,4,3,2,1}; 
		  
	        System.out.println("Given Array"); 
	        printArray(arr); 
	  
	        MergeSort ob = new MergeSort(); 
	        ob.sort(arr, 0, arr.length-1); 
	  
	        System.out.println("\nSorted array"); 
	        printArray(arr); 

	}

	private void sort(int[] arr, int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			sort(arr,l,m);
			sort(arr,m+1,r);
			
			mergeSort(arr,l,r,m);
		}
		
	}
	public void  mergeSort(int[] arr,int l,int r,int m) {
	int n1 = m-l+1;
	int n2 = r-m;
	int[] L = new int[n1];
	int[] R = new int[n2];
	
	for(int i=0;i<n1;i++) {
		L[i] = arr[l+i];
		
	}
	for(int j=0;j<n2;j++) {
		R[j] = arr[m+j+1];
	}
	
	int i=0,j=0;
	int k=l;
	while(i<n1 &&j<n2) {
		if(L[i]<R[j]) {
			arr[k] = L[i];
			i++;
		}else {
			arr[k] =R[j];
					j++;
		}
		k++;
	}
	while(i<n1) {
		arr[k] = L[i];
		k++;
		i++;
	}
	while(j<n2) {
		arr[k]=R[j];
		k++;
		j++;
	}
	
	}

	private static void printArray(int[] arr) {
for(int x: arr) {
	System.out.print(x+",");
}

		
	}

}
