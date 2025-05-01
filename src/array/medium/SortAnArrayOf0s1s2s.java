package array.medium;

import java.util.Arrays;

public class SortAnArrayOf0s1s2s {

	public static void main(String[] args) {

		int n = 6;
		int arr[]={0, 2, 1, 2, 0, 1};

		sortArrayBrute(arr,n);
		sortArrayBetter(arr,n);
		sortArrayOptimal(arr, n);
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static void sortArrayOptimal(int[] arr, int n) {

		int low=0,mid=0,high=n-1;

		while(mid<=high)
		{
			if(arr[mid]==0)
			{
				int temp=arr[low];
				arr[low]=arr[mid];
				arr[mid]=temp;
				low++;
				mid++;
			}
			else if(arr[mid]==1)
			{
				mid++;
			}
			else
			{
				int temp=arr[mid];
				arr[mid]=arr[high];
				arr[high]=temp;
				high--;
			}
		}

		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Time Complexity: O(n)+O(n)
	 * Space Complexity: O(1)
	 * */
	private static void sortArrayBetter(int[] arr, int n) {

		int cnt0=0,cnt1=0,cnt2=0;

		for(int i=0;i<n;i++)
		{
			if(arr[i]==0)
				cnt0++;
			else if(arr[i]==1)
				cnt1++;
			else
				cnt2++;
		}

		for(int i=0;i<cnt0;i++)
		{
			arr[i]=0;
		}

		for(int i=cnt0;i<cnt0+cnt1;i++)
		{
			arr[i]=1;
		}

		for(int i=cnt0+cnt1;i<n;i++)
		{
			arr[i]=2;
		}

		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Time Complexity: O(nlogn)
	 * Space Complexity: O(1)
	 * */
	private static void sortArrayBrute(int[] arr, int n) {

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
