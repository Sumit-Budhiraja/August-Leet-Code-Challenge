class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int k : A) {
            if (k % 2 == 0) {
                result[start] = k;
                start++;
            } else {
                result[end] = k;
                end--;
            }
        }
        return result;
    }
}