package array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOfTwoSortedArrays {

	public static void main(String[] args) {

		int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int arr2[] = {2, 3, 4, 4, 5, 11, 12};

		//		System.out.println(unionOfTwoSortedArraysBrute(arr1,arr2));
		//		System.out.println(unionOfTwoSortedArraysBetter(arr1,arr2));
		System.out.println(unionOfTwoSortedArraysOptimal(arr1,arr2));
	}
	/*
	 * Time Complexity: O(m+n)
	 * Space Complexity: O(m+n)
	 * */
	private static ArrayList<Integer> unionOfTwoSortedArraysOptimal(int[] arr1, int[] arr2) {

		int i=0,j=0,m=arr1.length,n=arr2.length;

		ArrayList<Integer> union=new ArrayList<>();

		while(i<m && j<n)
		{
			if(arr1[i]<=arr2[j])
			{
				if(union.size()==0 || union.get(union.size()-1)!=arr1[i])
				{
					union.add(arr1[i]);
				}
				i++;
			}
			else
			{
				if(union.size()==0 || union.get(union.size()-1)!=arr2[j])
				{
					union.add(arr2[j]);
				}
				j++;
			}
		}

		while(i<m)
		{
			if(union.get(union.size()-1)!=arr1[i])
			{
				union.add(arr1[i]);
			}
			i++;
		}

		while(j<n)
		{
			if(union.get(union.size()-1)!=arr2[j])
			{
				union.add(arr2[j]);
			}
			j++;
		}

		return union;
	}
	/*
	 * Time Complexity: O((m+n)*log(m+n))
	 * Space Complexity: O(m+n)
	 * */
	private static ArrayList<Integer> unionOfTwoSortedArraysBetter(int[] arr1, int[] arr2) {

		int m=arr1.length,n=arr2.length;
		HashSet<Integer> hashSet=new HashSet<>();
		ArrayList<Integer> union=new ArrayList<Integer>();

		for(int i=0;i<m;i++)
		{
			hashSet.add(arr1[i]);
		}

		for(int i=0;i<n;i++)
		{
			hashSet.add(arr2[i]);
		}

		for(int element:hashSet)
		{
			union.add(element);
		}

		return union;
	}
	/*
	 * Time Complexity: O((m+n)*log(m+n))
	 * Space Complexity: O(m+n)
	 * */
	private static ArrayList<Integer> unionOfTwoSortedArraysBrute(int[] arr1, int[] arr2) {

		int m=arr1.length,n=arr2.length;

		HashMap<Integer,Integer> hashMap=new HashMap<>();
		ArrayList<Integer> union=new ArrayList<>();

		for(int i=0;i<m;i++)
		{
			hashMap.put(arr1[i],hashMap.getOrDefault(arr1[i],0)+1);
		}

		for(int i=0;i<n;i++)
		{
			hashMap.put(arr2[i],hashMap.getOrDefault(arr2[i],0)+1);
		}

		for(int element:hashMap.keySet())
		{
			union.add(element);
		}

		return union;
	}
}
