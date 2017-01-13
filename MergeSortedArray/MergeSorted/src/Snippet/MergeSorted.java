package Snippet;

public class MergeSorted {
	
	public int[] mergeSorted(int nums1[] , int m, int nums2[], int n){
		int count1 = (m-1);
		int count2 = (n-1);
		int total = (m+n-1);
		while(count1>=0 && count2>=0){
			if(nums1[count1] > nums2[count2]){ 
				nums1[total] = nums1[count1];
				--count1;
			}
			else if(nums2[count2] >= nums1[count1]){
				nums1[total] = nums2[count2];
				--count2;
			}
			--total;
		}
		return nums1;
	}
	
	public static void main(String args[]){
		int [] x = new int[]{1,5,7,8,15,19,0,0,0,0,0,0};
		int [] y = new int[]{2,4,6,7,8,9};
		int [] temp = new MergeSorted().mergeSorted(x,6,y,6);
		for(int i: temp){ System.out.print(i + " | "); } System.out.println();
	}
	
}
