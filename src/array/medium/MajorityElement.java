package array.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {

		int arr[] = {2, 2, 1, 1, 1, 2, 2},n=arr.length;

		System.out.println(majorityElementBrute(arr,n));
		System.out.println(majorityElementBetter(arr,n));
		System.out.println(majorityElementOptimal(arr, n));
	}
	/*
	 * Time Complexity: O(n)+O(n)
	 * Space Complexity: O(1)
	 * */
	private static int majorityElementOptimal(int[] arr, int n) {

		int count=0,element=0;

		for(int i=0;i<n;i++)
		{
			if(count==0)
			{
				count=1;
				element=arr[i];
			}
			else if(element==arr[i])
			{
				count++;
			}
			else
			{
				count--;
			}
		}

		int count1=0;

		for(int i=0;i<n;i++)
		{
			if(element==arr[i])
			{
				count1++;
			}
		}

		if(count1>(n/2))
			return element;

		return -1;
	}
	/*
	 * Time Complexity: O(n)+O(nlogn)
	 * Space Complexity: O(n)
	 * */
	private static int majorityElementBetter(int[] arr, int n) {

		HashMap<Integer,Integer> hashMap=new HashMap<>();

		for(int i=0;i<n;i++)
		{
			hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
		}

		for(Map.Entry<Integer,Integer> entry:hashMap.entrySet())
		{
			if(entry.getValue()>(n/2))
			{
				return entry.getKey();
			}
		}

		return -1;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int majorityElementBrute(int[] arr, int n) {

		for(int i=0;i<n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
			}

			if(count>(n/2))
			{
				return arr[i];
			}
		}

		return -1;
	}
}
