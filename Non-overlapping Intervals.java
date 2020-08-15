class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      if(intervals.length < 2) return 0;
        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));
        int count = 0, last_included = 0;
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] < intervals[last_included][1]){ // Overlap
                count++;
                if(intervals[i][1] < intervals[last_included][1]) last_included = i;
            } else 
                last_included = i;
        }
        return count;   
    }
}