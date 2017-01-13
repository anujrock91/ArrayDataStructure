package Snippet;

public class JumpGame2 {
	
	public int minJumps(int [] nums){
		int []minJumps = new int[nums.length];
		int []fromTo = new int[nums.length];
		
		for(int i=1;i<nums.length;i++){
			int left = 0;
			while(left < i){
				if((left+nums[left]) >= i){
					int paths = (minJumps[left]+1);
					if(minJumps[i] == 0){ minJumps[i] = paths; fromTo[i]=left; }
					else{
						if(paths < minJumps[i]){ minJumps[i]=paths; fromTo[i]=left; }
					}
				}
				++left;
			}
		}
		
		for(int i=0;i<nums.length;i++){
			System.out.print(" | " + minJumps[i]);
		}
		System.out.println();
		for(int i=0;i<nums.length;i++){
			System.out.print(" | " + fromTo[i]);
		}
		System.out.println();
		
		return minJumps[minJumps.length-1];
	}
	
	
	public static void main(String args[]){
		System.out.println(new JumpGame2().minJumps(new int[]{2,3,1,1,4}));
	}
}
