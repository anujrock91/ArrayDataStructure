package Snippet;

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
	 
		int max = 0;
		int left = 0;
		int right = height.length - 1;
	 
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
	 
		return max;
	}
	
	public static void main(String args[]){
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 5, 4, 3}));
	}
	
}
