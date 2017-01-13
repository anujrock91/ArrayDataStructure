package Snippet;

public class BestTimeBuySell {
	
	public int maxProfit(int[] prices){
		int left = 0;
		int right = 0;
		int profit = 0;
		while(left< prices.length && right<prices.length){
			int currentDiff = (prices[right]-prices[left]);
			if(currentDiff >= 0){
				profit = Math.max(currentDiff, profit);
			}
			else{
				left = right;
			}
			++right;
		}
		return profit;
	}
	
	
	public static void main(String [] args){
		System.out.println(new BestTimeBuySell().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}
}
