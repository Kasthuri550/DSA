package array.medium;

import java.util.ArrayList;

public class LeadersInAnArray {

	public static void main(String[] args) {

		int n = 6;
		int arr[]=  {10, 22, 12, 3, 0, 6};

		System.out.println(leadersInAnArrayBrute(arr,n));
		System.out.println(leadersInAnArrayOptimal(arr,n));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static ArrayList<Integer> leadersInAnArrayOptimal(int[] arr, int n) {

		ArrayList<Integer> ans=new ArrayList<>();

		int max=arr[n-1];
		ans.add(max);

		for(int i=n-2;i>=0;i--)
		{
			if(arr[i]>max)
			{
				ans.add(arr[i]);
				max=arr[i];
			}
		}

		return ans;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 * */
	private static ArrayList<Integer> leadersInAnArrayBrute(int[] arr, int n) {

		ArrayList<Integer> ans=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			boolean leader=true;

			for(int j=i+1;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					leader=false;
					break;
				}
			}

			if(leader)
				ans.add(arr[i]);
		}

		return ans;
	}
}
