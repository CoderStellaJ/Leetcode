/*
Given the length of string in the array can be at most 10, 
we use an array of length 10 to store how many strings in words have larger frequencies

time: O(MN): M is the length of queries/words, N is the length of each string in the array
space: O(M)

Runtime: 3 ms, faster than 82.90% of Java online submissions for Compare Strings by Frequency of the Smallest Character.
Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Compare Strings by Frequency of the Smallest Character.

Syntax:
1. convert string to char array:
char[] wordArray = word.toCharArray();
2. sort
Arrays.sort(myArr);

*/

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int [] results = new int[queries.length];
        int [] count = new int[10];
        //process words list first
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            int cnt = countNum(word);
            count[cnt-1]++;
        }
        int [] sum = new int[10];
        int value = 0;
        for(int i = 9; i >= 0; i--) {
            sum[i] = value;
            value += count[i];
        }
        //process query
        for(int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int queryCount = countNum(query);
            results[i] = sum[queryCount-1];
        }
        return results;
    }
    
    public int countNum(String word) {
        int cnt = 0;
        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);
        for(int i = 0; i < wordArray.length; i++) {
            if(i == 0 || (wordArray[i] == wordArray[i-1])) {
                cnt++;
            } else {
                break;
            }
        }
        
        return cnt;
    }
}