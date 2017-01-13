package Snippet;
import java.util.*;

public class TwoSum {
	
	public int[] twoSum(int nums[], int target){
		int []result = new int[2];
		HashMap<Integer, Integer> remIndex = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(remIndex.containsKey(nums[i])){
				result[0] = remIndex.get(nums[i]).intValue();
				result[1] = i;
				return result;
			}
			else{
				remIndex.put(target-nums[i], i);
			}
		}
		return result;
	}
	
	
	public static void main(String args[]){
		int [] res = new TwoSum().twoSum(new int[]{2,7,11,9}, 9);
		System.out.println(res[0] + " , " + res[1]);
	}
}
