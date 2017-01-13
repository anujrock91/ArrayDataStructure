package Snippet;
import java.util.*;

public class MissingRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new MissingRange().missingRanges(new int[]{2});
		for(String s: l){
			System.out.println(s);
		}
	}
	
	public List<String> missingRanges(int nums[]){
		if(nums.length == 0){ 
			ArrayList<String> newList = new ArrayList<String>();
			newList.add("0->99");
			return newList;
		}
		else if(nums.length == 1){
			ArrayList<String> newList = new ArrayList<String>();
			if(nums[0] != 99 && nums[0] != 0){
				newList.add(0+"->"+(nums[0]-1));
				newList.add((nums[0]+1)+"->"+99);
			}
			else if(nums[0] == 0){
				newList.add(1+"->"+99);
			}
			else{
				newList.add(0+"->"+98);
			}
			return newList;
		}
		else{
			ArrayList<String> result = new ArrayList<>();
			int prev = nums[0];
			for(int i=1;i<nums.length;i++){
				int current = nums[i];
				if(current-prev == 1){
					prev=current;
				}
				else{
					if(prev+1 == current-1){
						result.add(""+(prev+1));
						prev = current;
					}
					else{
						result.add((prev+1)+"->" + (current-1));
						prev = current;
					}
				}
			}
			if(nums[0] != 0){ result.add(0,(0+"->"+(nums[0]-1))); }
			if(nums[nums.length-1] !=99){ result.add(((nums[nums.length-1]+1)+"->"+99)); }
			return result;
		}
	}

}
