package Snippet;
import java.util.*;


class Interval {
    int start;
    int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {
	
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		 int count1 = 0;int count2 = 0;
		 int startIndex = 0;
		 Interval start = null;
		 Interval end = null;
		 int endIndex = 0;
		 int flag = 0;
		 for(int i=0;i<intervals.size();i++){
			 if(intervals.get(i).end >= newInterval.start && count1 == 0){
				 ++count1; start = intervals.get(i);
				 startIndex = i;
			 }
			 if(intervals.get(i).end >= newInterval.end && count2 == 0){
				 ++count2; end = intervals.get(i);
				 endIndex = i;
			 }
		 }
		 System.out.println(startIndex + " - " + endIndex);
		 if(startIndex == endIndex){
			 if( newInterval.start >= end.start ){  }
			 if( newInterval.end < end.start ){ flag=1; }
			 else{ end.start = newInterval.start; }
		 }
		 else{
			 if(newInterval.end < end.start){ start.end = newInterval.end; }
			 else{ flag = 2; start.end = end.end; } 
		 }
		 
		 if(flag == 1){
			 for(int i=endIndex;i<intervals.size();i++){
				 Interval tempInterval=new Interval(intervals.get(i).start, intervals.get(i).end);
				 intervals.get(i).start = newInterval.start;
				 intervals.get(i).end = newInterval.end;
				 newInterval.start = tempInterval.start;
				 newInterval.end = tempInterval.end;
			 }
			 intervals.add(newInterval);
		 }
		 else if(flag == 2){
			startIndex = startIndex+1;
			endIndex = endIndex+1;
			while(startIndex < intervals.size() && endIndex<intervals.size()){
				intervals.get(startIndex).start = intervals.get(endIndex).start;
				intervals.get(startIndex).end = intervals.get(endIndex).end;
				++startIndex;
				++endIndex;
			}
			int i=0;
			int size = intervals.size();
			while(i<(size-startIndex)){
				intervals.remove(intervals.size()-1);
				++i;
			}
		 }
		 
		 return intervals;
	 }
	 
	 
	 public static void main(String args[]){
		 Interval i1 = new Interval(1,2);Interval i2 = new Interval(3,5);Interval i3 = new Interval(6,7);
		 Interval i4 = new Interval(8,10);Interval i5 = new Interval(12,16);
		 List<Interval> l = new ArrayList<>();
		 l.add(i1);l.add(i2);l.add(i3);l.add(i4);l.add(i5);
		 List<Interval> newList = new InsertInterval().insert(l, new Interval(2,8));
		 for(Interval i: newList){
			 System.out.println("["+i.start+","+i.end+"]");
		 }
	 }
}
