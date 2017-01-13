package Snippet;

public class RotateArray {
	
	public void rotateArray(int [] nums, int k){
		int left = 0;
		int right = (nums.length-1);
		int temp = 0;
		if(k<= (int)Math.round(nums.length/2)){
			while(temp != k){
				int x = nums[right%nums.length];
				nums[right%nums.length] = nums[left%nums.length];
				nums[left%nums.length] = x;
				++left;
				--right;
				++temp;
			}
			
			left = 0;
			right = (k-1);
			while(left<=right && left<k && right>=0){
				int x = nums[right];
				nums[right] = nums[left];
				nums[left] = x;
				++left;
				--right;
			}
			left = k;
			right = (nums.length-1);
			while(left<nums.length-1 && right>=k && left<=right){
				int x = nums[right];
				nums[right] = nums[left];
				nums[left] = x;
				++left;
				--right;
			}
			
			left=(2*k);
			right = (nums.length-1);
			while(left<=nums.length-1 && right >= 2*k && left<=right){
				int x = nums[right];
				nums[right] = nums[left];
				nums[left] = x;
				++left;
				--right;
			}
		}
		else{
			int kTotal = k;
			while(kTotal>=(int)Math.round(nums.length/2)){
				int kCurrent = (int)Math.round(nums.length/2);
				rotateArray(nums, kCurrent);
				kTotal = kTotal-kCurrent;
			}
			rotateArray(nums, kTotal);
		}
		
	}
	
	
	public static void main(String args[]){
		int [] arr= new int[]{1,2,3,4,5,6,7};
		new RotateArray().rotateArray(arr, 5);
		for(int i: arr){
			System.out.print(i+" | ");
		}
		System.out.println();
	}
}
