package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosToTheEnd {

	public static void main(String[] args) {

		int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};

		int result1[]=moveZerosToTheEndBrute(arr);
		System.out.println(Arrays.toString(result1));

		int result2[]=moveZerosToTheEndOptimal(arr);
		System.out.println(Arrays.toString(result2));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int[] moveZerosToTheEndOptimal(int[] arr) {

		int n=arr.length,j=-1;

		for(int i=0;i<n;i++)
		{
			if(arr[i]==0)
			{
				j=i;
				break;
			}
		}

		if(j==-1)
			return arr;

		for(int i=j+1;i<n;i++)
		{
			if(arr[i]!=0)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j++;
			}
		}

		return arr;
	}
	/*
	 * Time Complexity: O(n)+O(x)+O(n-x) ~ O(2n)
	 * Space Complexity: O(n)
	 * */
	private static int[] moveZerosToTheEndBrute(int[] arr) {

		int n=arr.length;

		ArrayList<Integer> temp=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			if(arr[i]!=0)
			{
				temp.add(arr[i]);
			}
		}

		int nz=temp.size();

		for(int i=0;i<nz;i++)
		{
			arr[i]=temp.get(i);
		}

		for(int i=nz;i<n;i++)
		{
			arr[i]=0;
		}

		return arr;
	}
}
