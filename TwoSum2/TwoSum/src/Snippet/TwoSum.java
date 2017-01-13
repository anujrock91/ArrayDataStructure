package Snippet;

public class TwoSum {

	public int[] twoSum(int []nums, int target){
		int left = 0;
		int right = (nums.length-1);
		int result[] = new int[2];
		while(left<right){
			int sum = nums[left] + nums[right];
			if(sum > target){ --right; }
			else if(sum < target){ ++left;}
			else{
				result[0] = left+1;
				result[1] = right+1;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int [] res = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
		for(int i: res){ System.out.print(i+" | ");}
	}

}
