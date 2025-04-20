package array.easy;

public class FindMissingNumber {

	public static void main(String[] args) {

		int n = 5;
		int a[] = {1, 2, 4, 5};

		System.out.println(findMissingNumberBrute(a,n));
		System.out.println(findMissingNumberBetter(a, n));
		System.out.println(findMissingNumberOptimal1(a, n));
		System.out.println(findMissingNumberOptimal2(a, n));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int findMissingNumberOptimal2(int[] a, int n) {

		int xor1=0,xor2=0;

		for(int i=0;i<n-1;i++)
		{
			xor1=xor1^a[i];
			xor2=xor2^(i+1);
		}

		xor2=xor2^n;

		return xor1^xor2;
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int findMissingNumberOptimal1(int[] a, int n) {

		int sum1=n*(n+1)/2;
		int sum2=0;

		for(int i=0;i<n-1;i++)
		{
			sum2=sum2+a[i];
		}

		int result=sum1-sum2;

		return result;
	}
	/*
	 * Time Complexity: O(2n)
	 * Space Complexity: O(n)
	 * */
	private static int findMissingNumberBetter(int[] a, int n) {

		int hash[]=new int[n+1];

		for(int i=0;i<n-1;i++)
		{
			hash[a[i]]++;
		}

		for(int i=1;i<=n;i++)
		{
			if(hash[i]==0)
			{
				return i;
			}
		}		

		return -1;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int findMissingNumberBrute(int[] a, int n) {

		for(int i=1;i<=n;i++)
		{
			int flag=0;
			for(int j=0;j<n-1;j++)
			{
				if(a[j]==i)
				{
					flag=1;
					break;
				}
			}

			if(flag==0) return i;
		}

		return -1;
	}
}
