package array.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

	public static void main(String[] args) {

		int[] a = {2, 3, 5, 1, 9};
		int k = 10;

		System.out.println(longestSubarrayWithSumKBrute(a,k));
		System.out.println(longestSubarrayWithSumKBetter(a,k));
		System.out.println(longestSubarrayWithSumKOptimal1(a,k));
		System.out.println(longestSubarrayWithSumKOptimal2(a,k));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int longestSubarrayWithSumKOptimal2(int[] a, int k) {

		int n=a.length,left=0,right=0,sum=a[0],maxLen=Integer.MIN_VALUE;

		while(right<n)
		{
			while(left<=right && sum>k)
			{
				sum=sum-a[left];
				left++;
			}

			if(sum==k)
				maxLen=Math.max(maxLen,right-left+1);

			right++;
			if(right<n)
				sum=sum+a[right];
		}

		return maxLen;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int longestSubarrayWithSumKOptimal1(int[] a, int k) {

		int n=a.length,sum=0,maxLen=Integer.MIN_VALUE;

		Map<Integer,Integer> preSumMap=new HashMap<>();

		for(int i=0;i<n;i++)
		{
			sum=sum+a[i];

			if(sum==k)
			{
				maxLen=Math.max(maxLen,i+1);
			}

			int rem=sum-k;

			if(preSumMap.containsKey(rem))
			{
				int len=i-preSumMap.get(rem);
				maxLen=Math.max(maxLen,len);
			}

			if(!preSumMap.containsKey(sum))
			{
				preSumMap.put(sum,i);
			}
		}

		return maxLen;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int longestSubarrayWithSumKBetter(int[] a, int K) {

		int n=a.length,maxLen=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum=sum+a[j];

				if(sum==K)
				{
					maxLen=Math.max(maxLen,j-i+1);
				}
			}
		}
		return maxLen;
	}
	/*
	 * Time Complexity: O(n^3)
	 * Space Complexity: O(1)
	 * */
	private static int longestSubarrayWithSumKBrute(int[] a, int K) {

		int n=a.length,maxLen=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;

				for(int k=i;k<=j;k++)
				{
					sum=sum+a[k];
				}

				if(sum==K)
				{
					maxLen=Math.max(maxLen,j-i+1);
				}
			}
		}		

		return maxLen;
	}
}
