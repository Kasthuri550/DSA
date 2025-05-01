package array.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int n = 5;
		int[] arr = {2, 6, 5, 8, 11};
		int target = 14;

		System.out.println(twoSumBrute1(arr,n,target));
		int result1[]=twoSumBrute2(arr, n, target);
		System.out.println(Arrays.toString(result1));
		System.out.println(twoSumBetter1(arr,n,target));
		int result2[]=twoSumBetter2(arr, n, target);
		System.out.println(Arrays.toString(result2));

		System.out.println(twoSumOptimal1(arr,n,target));
		int result3[]=twoSumOptimal2(arr, n, target);
		System.out.println(Arrays.toString(result3));
	}
	/*
	 * Time Complexity: O(nlogn)
	 * Space Complexity: O(n)
	 * */
	private static int[] twoSumOptimal2(int[] arr, int n, int target) {

		int valueIndexPairs[][]=new int[n][2];

		for(int i=0;i<n;i++)
		{
			valueIndexPairs[i][0]=arr[i];
			valueIndexPairs[i][1]=i;
		}

		Arrays.sort(valueIndexPairs,Comparator.comparingInt(a->a[0]));

		int left=0,right=n-1,sum;
		while(left<right)
		{
			sum=valueIndexPairs[left][0]+valueIndexPairs[right][0];

			if(sum==target)
			{
				return new int[] {valueIndexPairs[left][1],valueIndexPairs[right][1]};
			}
			else if(sum<target)
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		return new int[] {-1,-1};
	}

	/*
	 * Time Complexity: O(nlogn)
	 * Space Complexity: O(1)
	 * */
	private static String twoSumOptimal1(int[] arr, int n, int target) {

		int left=0,right=n-1,sum=0;
		Arrays.sort(arr);

		while(left<right)
		{
			sum=arr[left]+arr[right];

			if(sum==target)
			{
				return "YES";
			}
			else if(sum<target)
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		return "NO";
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int[] twoSumBetter2(int[] arr, int n, int target) {

		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
		int result[]=new int[2];
		result[0]=result[1]=-1;

		for(int i=0;i<n;i++)
		{
			int rem=target-arr[i];

			if(hashMap.containsKey(rem))
			{
				result[0]=hashMap.get(rem);
				result[1]=i;
				return result;
			}

			hashMap.put(arr[i],i);
		}

		return result;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static String twoSumBetter1(int[] arr, int n, int target) {

		Map<Integer,Integer> hashMap=new HashMap<>();

		for(int i=0;i<n;i++)
		{
			int rem=target-arr[i];

			if(hashMap.containsKey(rem))
			{
				return "YES";
			}
			hashMap.put(arr[i],i);
		}

		return "NO";
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int[] twoSumBrute2(int[] arr, int n, int target) {

		int result[]=new int[2];
		result[0]=result[1]=-1;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]+arr[j]==target)
				{
					result[0]=i;
					result[1]=j;
					return result;
				}
			}
		}

		return result;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static String twoSumBrute1(int[] arr, int n, int target) {

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]+arr[j]==target)
					return "Yes";
			}
		}

		return "No";
	}
}
