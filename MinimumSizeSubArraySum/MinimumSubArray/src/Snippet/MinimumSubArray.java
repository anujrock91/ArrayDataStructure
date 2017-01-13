package Snippet;

public class MinimumSubArray {
	
	public int minSubArrayLen(int s, int[] nums) {
		int left = 0;
		int right = 1;
		int minLen = Integer.MAX_VALUE;
		if(nums.length == 0 || (nums.length == 1 && s!=nums[0])){ return 0;}
		else if((nums.length == 1 && s==nums[0])){ return 1; }
		else{
			int tempSum = nums[left];
			while(right < nums.length && left<nums.length){
				if(tempSum >= s){
					minLen = Math.min(minLen, (right-left));
					tempSum -= nums[left];
					++left;
				}
				else{
					tempSum += nums[right];
					++right;
				}
			}
			while(left<nums.length){
				if(tempSum >= s){
					minLen = Math.min(minLen, (right-left));
					tempSum -= nums[left];
				}
				++left;
			}
		}
		return minLen;
    }
	
	
	public static void main(String args[]){
		System.out.println(new MinimumSubArray().minSubArrayLen(7, new int[]{2,3,1,2,4,3,7} ));
	}
	
}
