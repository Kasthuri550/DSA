package array.easy;

public class LinearSearch {

	public static void main(String[] args) {

		int arr[]={1,2,3,4,5},search=3;

		System.out.println(linearSearch(arr,search));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static boolean linearSearch(int[] arr, int search) {

		int n=arr.length;

		for(int i=0;i<n;i++)
		{
			if(arr[i]==search)
				return true;
		}

		return false;
	}

}
