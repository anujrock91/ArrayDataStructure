package Snippet;
import java.util.List;
import java.util.ArrayList;

public class SummaryRange {

	public List<String> summaryRange(int [] nums){
		ArrayList<String> result = new ArrayList<>();
		int prev = Integer.MIN_VALUE;
		String res = "";
		for(int i=0;i<nums.length;i++){
			int current = nums[i];
			if((current-prev) == 1){
				prev = current;
			}
			else{
				res +="->"+prev;
				prev=current;
				result.add(res);
				res = ""+prev;
			}
		}
		result.add(res);
		result.remove(0);
		return result;
	}
	
	public static void main(String[] args) {
		List<String> l = new SummaryRange().summaryRange(new int[]{0,1,2,3,4,5,7});
		for(String s: l){
			System.out.print(s+" | ");
		}
		System.out.println();
	}
	
	

}
