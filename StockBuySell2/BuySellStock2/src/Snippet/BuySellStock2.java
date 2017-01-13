package Snippet;

public class BuySellStock2 {
	
	public int maxProfit(int [] prices){
		 int profit = 0;
		    for(int i=1; i<prices.length; i++){
		        int diff = prices[i]-prices[i-1];
		        if(diff > 0){
		            profit += diff;
		        }
		    }
		    return profit;
	}
	
	public static void main(String args[]){
		System.out.println(new BuySellStock2().maxProfit(new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
	}
	
}
