class Solution {
    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        String[] s = S.split(" ");
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        for(int i = 0; i < s.length; i++) {
            if(vowels.contains(s[i].charAt(0))) {
                res.append(s[i]+"ma");   
            } else if(!vowels.contains(s[i].charAt(0))) {
                res.append(s[i].substring(1) + s[i].charAt(0) + "ma");
            }
            int j = i;
            while(j >= 0) {
                res.append("a");
                j--;
            }
            if (i != s.length - 1) res.append(" ");
        } 
        
        return res.toString();
    }
}