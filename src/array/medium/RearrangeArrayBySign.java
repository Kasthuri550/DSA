package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RearrangeArrayBySign {

	public static void main(String[] args) {

		int arr1[]= {1,2,-4,-5},n1=arr1.length;

		int arr2[]= {1,5,2,-4,-5,3,4},n2=arr2.length;

		rearrangeArrayBySignBrute(arr1,n1);
		rearrangeArrayBySignOptimalBySameLength(arr1,n1);
		rearrangeArrayBySignOptimalByDifferentLength(arr2, n2);	
	}
	/*
	 * Time Complexity: O(2n)
	 * Space Complexity: O(n)
	 * */
	private static void rearrangeArrayBySignOptimalByDifferentLength(int[] arr, int n) {

		ArrayList<Integer> positive=new ArrayList<>();
		ArrayList<Integer> negative=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			if(arr[i]<0)
			{
				negative.add(arr[i]);
			}
			else
			{
				positive.add(arr[i]);
			}
		}

		if(positive.size()<negative.size())
		{
			for(int i=0;i<positive.size();i++)
			{
				arr[2*i]=positive.get(i);
				arr[2*i+1]=negative.get(i);
			}

			int index=positive.size()*2;

			for(int i=positive.size();i<negative.size();i++)
			{
				arr[index]=negative.get(i);
				index++;
			}
		}
		else
		{
			for(int i=0;i<negative.size();i++)
			{
				arr[2*i]=positive.get(i);
				arr[2*i+1]=negative.get(i);
			}

			int index=negative.size()*2;

			for(int i=negative.size();i<positive.size();i++)
			{
				arr[index]=positive.get(i);
				index++;
			}
		}

		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static void rearrangeArrayBySignOptimalBySameLength(int[] arr, int n) {

		int posIndex=0,negIndex=1;

		ArrayList<Integer> result=new ArrayList<>(Collections.nCopies(n,0));

		for(int i=0;i<n;i++)
		{
			if(arr[i]<0)
			{
				result.set(negIndex,arr[i]);
				negIndex+=2;
			}
			else
			{
				result.set(posIndex,arr[i]);
				posIndex+=2;
			}
		}

		System.out.println(result);
	}
	/*
	 * Time Complexity: O(n)+O(n/2)
	 * Space Complexity: O(n)
	 * */
	private static void rearrangeArrayBySignBrute(int[] arr, int n) {

		ArrayList<Integer> positive=new ArrayList<>();
		ArrayList<Integer> negative=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			if(arr[i]<0)
			{
				negative.add(arr[i]);
			}
			else
			{
				positive.add(arr[i]);
			}
		}

		for(int i=0;i<n/2;i++)
		{
			arr[2*i]=positive.get(i);
			arr[2*i+1]=negative.get(i);
		}

		System.out.println(Arrays.toString(arr));
	}
}
