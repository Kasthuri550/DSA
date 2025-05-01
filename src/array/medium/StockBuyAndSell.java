package array.medium;

public class StockBuyAndSell {

	public static void main(String[] args) {

		int arr[] = {7,1,5,3,6,4},n=arr.length;

		System.out.println(stockBuyAndSellBrute(arr,n));
		System.out.println(stockBuyAndSellOptimal(arr, n));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int stockBuyAndSellOptimal(int[] arr, int n) {

		int maxProfit=Integer.MIN_VALUE,min=Integer.MAX_VALUE;

		for(int i=0;i<n;i++)
		{
			min=Math.min(min,arr[i]);
			maxProfit=Math.max(maxProfit,arr[i]-min);
		}

		return maxProfit;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int stockBuyAndSellBrute(int[] arr, int n) {

		int maxProfit=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]>arr[i])
				{
					maxProfit=Math.max(maxProfit,arr[j]-arr[i]);
				}
			}
		}

		return maxProfit;
	}
}
