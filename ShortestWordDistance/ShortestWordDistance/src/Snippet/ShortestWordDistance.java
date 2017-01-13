package Snippet;

public class ShortestWordDistance {
	
	public int getDistance(String[] words, String word1, String word2){
		int left = 0;
		int right = words.length-1;
		int min = Integer.MAX_VALUE;
		while(left < words.length && right >= 0){
			while(left < words.length && !words[left].equals(word1)) { ++left; }
			while(right >= 0 && !words[right].equals(word2)) { --right; }
			if(left < words.length && right >=0){
				int diff = Math.abs(left-right);
				if(diff < min){
					min = diff ;
				}
				++left;
				--right;
			}
		}
		return min;
	}
	
	
	public static void main(String [] args){
		System.out.println(new ShortestWordDistance().getDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "makes"));
		System.out.println(new ShortestWordDistance2(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "makes").getShortestDistance());
	}
}
