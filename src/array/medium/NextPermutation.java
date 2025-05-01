package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {

		int[] nums = {1, 2, 3};

		nextPermutationBrute(nums);
		int[] result = nextPermutationOptimal(nums);
		System.out.println(Arrays.toString(result));
	}
	/*
	 * Time Complexity: O(3n)
	 * Space Complexity: O(1)
	 * */
	private static int[] nextPermutationOptimal(int[] nums) {

		int n=nums.length,index=-1;

		for(int i=n-2;i>=0;i--)
		{
			if(nums[i]<nums[i+1])
			{
				index=i;
				break;
			}
		}

		if(index==-1)
		{
			reverse(nums,0,n-1);
			return nums;
		}

		for(int i=n-1;i>index;i--)
		{
			if(nums[i]>nums[index])
			{
				int temp=nums[i];
				nums[i]=nums[index];
				nums[index]=temp;
				break;
			}
		}

		reverse(nums,index+1,n-1);

		return nums;
	}

	private static void reverse(int[] nums, int start, int end) {

		while(start<end)
		{
			int temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
	/*
	 * Time Complexity: O(n!*n)+O(n!logn!)+o(n!*n)+O(n)
	 * Space Complexity: O(n!*n)
	 * */
	private static void nextPermutationBrute(int[] nums) {

		List<List<Integer>> allPermutations=new ArrayList<>();

		generatePermutation(0,nums,allPermutations);

		allPermutations.sort((a,b)->{
			for(int i=0;i<allPermutations.size();i++)
			{
				if(!a.get(i).equals(b.get(i)))
				{
					return a.get(i)-b.get(i);
				}
			}
			return 0;
		});

		for(int i=0;i<allPermutations.size();i++)
		{
			if(matches(nums,allPermutations.get(i)))
			{
				int nextIndex=(i+1)%allPermutations.size();

				List<Integer> nextPerum=allPermutations.get(nextIndex);

				for(int j=0;j<nums.length;j++)
				{
					nums[j]=nextPerum.get(j);
				}
				break;
			}
		}

		System.out.println(Arrays.toString(nums));
	}

	private static boolean matches(int[] nums, List<Integer> list) {

		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]!=list.get(i))
				return false;
		}

		return true;
	}

	private static void generatePermutation(int index, int[] nums, List<List<Integer>> allPermutations) {

		if(index==nums.length)
		{
			List<Integer> ds=new ArrayList<>();
			for(int i=0;i<nums.length;i++)
			{
				ds.add(nums[i]);
			}

			allPermutations.add(new ArrayList<Integer>(ds));
			return;
		}

		for(int i=index;i<nums.length;i++)
		{
			swap(index,i,nums);
			generatePermutation(index+1, nums, allPermutations);
			swap(index,i,nums);
		}
	}

	private static void swap(int i, int j, int[] nums) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
