package array.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberThatAppearsOnceAndTheOtherNumbersTwice {

	public static void main(String[] args) {

		int[] arr = {4, 1, 2, 1, 2};

		System.out.println(findTheNumberThatAppearsOnceBrute(arr));
		System.out.println(findTheNumberThatAppearsOnceBetter1(arr));
		System.out.println(findTheNumberThatAppearsOnceBetter2(arr));
		System.out.println(findTheNumberThatAppearsOnceOptimal(arr));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int findTheNumberThatAppearsOnceOptimal(int[] arr) {

		int n=arr.length,xor=0;

		for(int i=0;i<n;i++)
		{
			xor=xor^arr[i];
		}

		return xor;
	}
	/*
	 * Time Complexity: O(nlogm)
	 * Space Complexity: O(m)
	 * */
	private static int findTheNumberThatAppearsOnceBetter2(int[] arr) {

		int n=arr.length;
		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();

		for(int i=0;i<n;i++)
		{
			hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
		}

		for(Map.Entry<Integer,Integer> entry:hashMap.entrySet())
		{
			if(entry.getValue()==1)
			{
				return entry.getKey();
			}
		}

		return -1;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int findTheNumberThatAppearsOnceBetter1(int[] arr) {

		int n=arr.length,max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			max=Math.max(max,arr[i]);
		}

		int hash[]=new int[max+1];

		for(int i=0;i<n;i++)
		{
			hash[arr[i]]++;
		}

		for(int i=0;i<n;i++)
		{
			if(hash[arr[i]]==1)
			{
				return arr[i];
			}
		}

		return -1;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int findTheNumberThatAppearsOnceBrute(int[] arr) {

		int n=arr.length;

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

			if(count==1)
				return arr[i];
		}

		return -1;
	}
}
