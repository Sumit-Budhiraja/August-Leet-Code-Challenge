class StreamChecker {
    
    class Trie {
        boolean isWord;
        Trie [] next;
        
        public Trie () {
            next = new Trie[26];
        }
    
        
    }
    Trie root;
    List<Character> chars;
    public StreamChecker(String[] words) {
        root = new Trie();
        for(int i = 0;i<words.length;i++) {
           addToTrie(words[i]);
        }
        chars = new ArrayList<>();
    }
    
    
    void addToTrie(String str) {
        
        Trie node = root;
        for(int i = str.length()-1;i>=0;i--) {
            int ch = str.charAt(i) - 'a';
            if(node.next[ch] == null)  node.next[ch] = new Trie();
            node = node.next[ch];
        }
        
        node.isWord = true;
        
    }
    public boolean query(char letter) {
        
        Trie node = root;
        
        chars.add(letter);
        int i = chars.size()-1;
        while(node != null && !node.isWord && i >= 0) {
            int ch =  chars.get(i) - 'a';
            node = node.next[ch];
            --i;
        }
        
        return node != null && node.isWord;
    }
}