package Snippet;
import java.util.Arrays;

public class NextPermutations {
	
	public void nextPerm(int nums[]){
		int right = (nums.length-2);
		while(right >= 0){
			if(nums[right] >=  nums[right+1]){
				--right;
			}
			else{
				break;
			}
		}
		if(right < 0){ Arrays.sort(nums);return; }
		else{
			int left = right+1;
			while(left < nums.length){
				if(nums[left]>nums[right]){ ++left; }
				else{ break; }
			}
			int temp = nums[right];
			nums[right] = nums[left-1];
			nums[left-1] = temp;
			left = (right+1);
			right = (nums.length-1);
			while(left <= right){ 
				int t = nums[left];  nums[left] = nums[right]; nums[right] = t; 
				++left; --right;
			}
		}
	}
	
	
	public static void main(String args[]){
		int nums[]= new int[]{4 ,5 ,6 ,3 ,2 ,1};
		new NextPermutations().nextPerm(nums);
		for(int i: nums){ System.out.print( i + " | ");}System.out.println();
	}
}	
