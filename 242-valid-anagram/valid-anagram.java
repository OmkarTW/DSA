class Solution {
    public boolean isAnagram(String s, String t) {
        
        // Returning false if both lengths are equal
        if(s.length() != t.length()){
            return false;
        }

        // Hashing Array
        int[] hashTable = new int [26];

        for(int i = 0; i < s.length(); i++){
            hashTable[s.charAt(i) - 'a']++;
            hashTable[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < hashTable.length; i++){
            if(hashTable[i] != 0){
                return false;
            }
        }

        return true;
    }
}