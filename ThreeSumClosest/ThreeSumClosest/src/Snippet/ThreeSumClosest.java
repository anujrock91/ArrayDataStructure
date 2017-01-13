package Snippet;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int getClosest(int nums[], int target){
		int minDiff = Integer.MAX_VALUE;
		int sumTarget = 0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			int first = nums[i];
			int left = i+1;
			int right = (nums.length-1);
			while(left < right){
				int second = nums[left];
				int third = nums[right];
				int sum = (first+second+third);
				minDiff = Math.min(minDiff, target-sum);
				if(minDiff == (target-sum)){ sumTarget = sum; }
				if(sum>target){ --right; }
				else if( sum < target){ ++left; }
				else{ return sum; }
			}
		}
		return sumTarget;
	}
	
	public static void main(String args[]){
		System.out.println(new ThreeSumClosest().getClosest(new int[]{-1,2,1,-4}, 1));
	}
	
}
