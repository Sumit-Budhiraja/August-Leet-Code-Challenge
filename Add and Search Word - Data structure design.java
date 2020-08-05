class WordDictionary {

HashMap<Integer,List<String>> map;

/** Initialize your data structure here. */
public WordDictionary() {
    map = new HashMap<>();
}

/** Adds a word into the data structure. */
public void addWord(String word) {
    
    int len = word.length();
    if(!map.containsKey(len)) {
        
        List<String> lst = new ArrayList<>();
        lst.add(word);
        map.put(len,lst);
        
    } else {
        map.get(len).add(word);   
    }
}

/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
public boolean search(String word) {
    
    int len = word.length();
    
    if(!map.containsKey(len))
        return false;
    
    List<String> lst = map.get(len);
    
    if(lst.contains(word))
        return true;
    
    Iterator it = lst.iterator();
    while(it.hasNext()) {
        if(compareWords(word,(String) it.next()) == true) {
            return true;
        }    
    }
    return false;
}

private boolean compareWords(String word1, String word2) {
    
    // System.out.println("word1 = " + word1 + " word2 = " + word2);
    
    char[] arr1 = word1.toCharArray();
    char[] arr2 = word2.toCharArray();
    
    for(int i = 0; i < arr1.length; i++) {
        if(arr1[i] != '.') {
            if(arr1[i] != arr2[i])
                return false;
        }
    }
    
    return true;
}
}