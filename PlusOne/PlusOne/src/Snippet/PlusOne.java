package Snippet;

public class PlusOne {
	
	public int[] plusOne(int nums[]){
		nums[nums.length-1] = (nums[nums.length-1]+1);
		int quo = 0;
		int rem = 0;
		for(int i=nums.length-1;i>=0;i--){
			nums[i] = (nums[i]+quo);
			rem = (nums[i]%10);
			quo = (nums[i]/10);
			nums[i] = rem;
		}
		int res[];
		res = new int[quo==1?nums.length+1:nums.length];
		res[0] = quo==1?quo:0;
		if(res.length == nums.length){
			for(int i=0;i<nums.length;i++){
				res[i] = nums[i];
			}
		}
		else{
			for(int i=0;i<nums.length;i++){
				res[i+1] = nums[i];
			}
		}
		return res;
	}
	
	
	public static void main(String args[]){
		int [] res = new PlusOne().plusOne(new int[]{9,8,9});
		for(int i: res){ System.out.print(i);}
		System.out.println();
	}
	
	
}
