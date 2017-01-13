package Snippet;
import java.util.ArrayList;

public class AllRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDisappeared(new int[]{4,3,2,7,8,2,3,1}));
	}
	
	public static ArrayList<Integer> getDisappeared(int [] arr){
		ArrayList<Integer> missing = new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			if(arr[Math.abs(arr[i])-1] < 1){
				continue;
			}
			arr[Math.abs(arr[i])-1] = (-1*arr[Math.abs(arr[i])-1]);
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i] > 0){
				missing.add(i+1);
			}
		}
		return missing;
	}

}
