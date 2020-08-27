class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int N = intervals.length;
        for(int i = 0; i < N; i++)
            map.put(new Pair<>(intervals[i][0], intervals[i][1]), i);
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int i = 0; i < N; i++){
            int index = -1;
            int b = intervals[i][1];
            for(int j = i + 1; j < N; j++){
                if(b <= intervals[j][0]){
                    index = map.get(new Pair<>(intervals[j][0], intervals[j][1]));
                    break;
                }
            }
            ans[map.get(new Pair<>(intervals[i][0], b))] = index;
        }
        return ans;
    }
}