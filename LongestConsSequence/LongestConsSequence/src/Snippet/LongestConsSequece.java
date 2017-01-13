package Snippet;
import java.util.*;

public class LongestConsSequece {
	
	public static int longestConsecutive(int[] num){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i: num){
			set.add(i);
		}
		int max = Integer.MIN_VALUE;
		for(Integer i: num){
			int left = i-1;
			int right = i+1;
			int count = 1;
			while(set.contains(left)){
				set.remove(left);
				--left;
				++count;
			}
			while(set.contains(right)){
				set.remove(right);
				++right;
				++count;
			}
			max = Math.max(max, count);
		}
		return max;
	}
	
	public static void main(String [] args){
		System.out.println(longestConsecutive(new int[]{100,101,99, 4, 200, 1, 3, 2}));
	}
}
