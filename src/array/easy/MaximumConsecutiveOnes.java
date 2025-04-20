package array.easy;

public class MaximumConsecutiveOnes {

	public static void main(String[] args) {

		int nums[] = { 1, 1, 0, 1, 1, 1 };

		System.out.println(maxConsecutiveOnes(nums));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int maxConsecutiveOnes(int[] nums) {

		int n=nums.length,count=0,max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			if(nums[i]==1)
			{
				count++;
			}
			else
			{
				count=0;
			}

			max=Math.max(max,count);
		}

		return count;
	}
}
