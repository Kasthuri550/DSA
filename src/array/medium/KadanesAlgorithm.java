package array.medium;

public class KadanesAlgorithm {

	public static void main(String[] args) {

		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		int n = arr.length;

		System.out.println(maximumSubarraySumBrute(arr,n));
		System.out.println(maximumSubarraySumBetter(arr,n));
		System.out.println(maximumSubarraySumOptimal1(arr,n));
		maximumSubarraySumOptimal2(arr, n);
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static void maximumSubarraySumOptimal2(int[] arr, int n) {

		int sum=0,max=Integer.MIN_VALUE,start=0;
		int ansStart=-1,ansEnd=-1;

		for(int i=0;i<n;i++)
		{
			if(sum==0)
				start=i;
			sum=sum+arr[i];

			if(sum>max)
			{
				max=sum;
				ansStart=start;
				ansEnd=i;
			}

			if(sum<0)
			{
				sum=0;
			}
		}

		for(int i=ansStart;i<=ansEnd;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int maximumSubarraySumOptimal1(int[] arr, int n) {

		int sum=0,max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];

			if(sum>max)
			{
				max=sum;
			}

			if(sum<0)
			{
				sum=0;
			}
		}
		return max;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int maximumSubarraySumBetter(int[] arr, int n) {

		int max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum=sum+arr[j];

				if(sum>max)
				{
					max=sum;
				}
			}
		}

		return max;
	}
	/*
	 * Time Complexity: O(n^3)
	 * Space Complexity: O(1)
	 * */
	private static int maximumSubarraySumBrute(int[] arr, int n) {

		int max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum=sum+arr[k];
				}

				if(sum>max)
				{
					max=sum;
				}
			}
		}

		return max;
	}
}
