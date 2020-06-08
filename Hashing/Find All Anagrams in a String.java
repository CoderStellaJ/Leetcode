/*
sliding window + hashmap

time: O(N)
space: O(1)

Runtime: 29 ms, faster than 34.08% of Java online submissions for Find All Anagrams in a String.
Memory Usage: 40.3 MB, less than 24.00% of Java online submissions for Find All Anagrams in a String.

syntax:
1. getOrDefault(key, 0);
2. mymap.put(...)
3. if you modify the object in the function, the object actually changes in the main function as well.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> letters = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        if(lenS < lenP) {
            return res;
        }
        // process string p
        int[] pLetters = new int[26];
        for(int j = 0; j < lenP; j++) {
            char pChar = p.charAt(j);
            pLetters[(int)pChar-(int)'a']++;
        }
        
        // initialization of the hashmap
        for(int i = 0; i < lenP; i++) {
            char sChar = s.charAt(i);
            int count = letters.getOrDefault(sChar, 0);
            int newCount = count + 1;
            letters.put(sChar, newCount);
        }
        
        for(int i = lenP-1; i < lenS; i++) {
            int start = i-(lenP-1);
            if(isAnagram(letters, pLetters) == true) {
                res.add(start);
            }
            // for(Character key: letters.keySet()) {
            //     System.out.print(key + " " + letters.get(key) + "/");    
            // }
            // System.out.println(" ");
            
            //take out the first letter
            char startChar = s.charAt(start);
            int count = letters.get(startChar);
            letters.put(startChar, count-1);
            //put in the last letter
            if(i != lenS-1) {
                char newChar = s.charAt(i+1);
                int countChar = letters.getOrDefault(newChar, 0);
                letters.put(newChar, countChar+1);
            }
            
        }
        return res;
        
    }
    
    public boolean isAnagram(HashMap<Character, Integer> mymap, int[] pLetters) {
        for(int i = 0; i < 26; i++) {
            char pChar = (char)(i+(int)'a');
            int count = pLetters[i];
            if(mymap.getOrDefault(pChar,0) != count) {
                return false;
            }
        }
        return true;
    }
}