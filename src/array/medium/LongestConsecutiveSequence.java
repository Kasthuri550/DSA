package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int a[] = {100, 200, 1, 2, 3, 4},n=a.length;

		System.out.println(longestConsecutiveSequenceBrute(a,n));
		System.out.println(longestConsecutiveSequenceBetter(a, n));
		System.out.println(longestConsecutiveSequenceOptimal(a, n));
	}
	/*
	 * Time Complexity: O(3n)
	 * Space Complexity: O(n)
	 * */	
	private static int longestConsecutiveSequenceOptimal(int[] a, int n) {

		int longest=Integer.MIN_VALUE;

		Set<Integer> hashSet=new HashSet<>();

		for(int i=0;i<n;i++)
		{
			hashSet.add(a[i]);
		}

		for(int it:a)
		{
			if(!hashSet.contains(it-1))
			{
				int x=it,count=1;

				while(hashSet.contains(x+1))
				{
					x++;
					count++;
				}

				longest=Math.max(longest,count);
			}
		}

		return longest;
	}
	/*
	 * Time Complexity: O(nlogn)+O(n)
	 * Space Complexity: O(1)
	 * */	
	private static int longestConsecutiveSequenceBetter(int[] a, int n) {

		int lastSmaller=Integer.MAX_VALUE,longest=Integer.MIN_VALUE,count=0;

		Arrays.sort(a);

		for(int i=0;i<n;i++)
		{
			if(a[i]-1==lastSmaller)
			{
				count++;
				lastSmaller=a[i];
			}
			else if(a[i]!=lastSmaller)
			{
				count=1;
				lastSmaller=a[i];
			}

			longest=Math.max(longest,count);
		}

		return longest;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */	
	private static int longestConsecutiveSequenceBrute(int[] a, int n) {

		int longest=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int x=a[i],count=1;

			while(linearSearch(a,x+1))
			{
				x++;
				count++;
			}

			longest=Math.max(longest,count);
		}

		return longest;
	}

	private static boolean linearSearch(int[] a, int searchElement) {

		for(int i=0;i<a.length;i++)
		{
			if(a[i]==searchElement)
				return true;
		}
		return false;
	}
}
