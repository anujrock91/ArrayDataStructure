package Snippet;

import java.util.Arrays;

public class SearchRange {
	
	public int[] searchRange(int nums[], int target ){
		double left = 0;
		double right = nums.length-1;
		int prevLeft = Integer.MIN_VALUE;
		int [] range = new int[2];
		while(left<=right){
			int middle = (int)Math.round(((left+right)/2));
			int curr = nums[(int)middle];
			if(curr < target){ left = middle+1; }
			else if(curr > target){ right = middle-1; } 
			else{
				left = middle;
				if(prevLeft == middle){
					range[0] = prevLeft;
					break;
				}
				prevLeft = middle;
			}
		}
		
		int prevRight = Integer.MIN_VALUE;
		left = 0;
		right = nums.length-1;
		while(left<=right){
			int middle = (int)((left+right)/2);
			int curr = nums[middle];
			if(curr < target){ left = middle+1; }
			else if(curr > target){ right = middle-1; } 
			else{
				right = middle;
				if(prevRight == middle){
					range[1] = prevRight;
					break;
				}
				prevRight = middle;
			}
		}
		
		if(nums[prevLeft] != nums[prevRight]){ return new int[]{-1,-1}; }
		else{ Arrays.sort(range); return range; }
	}
	
	
	public static void main(String args[]){
		int [] range = new SearchRange().searchRange(new int[]{1, 7, 7, 7, 7, 8}, 7);
		System.out.println(range[0] + " | " + range[1]);
	}
	
}
