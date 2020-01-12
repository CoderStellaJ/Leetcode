class Solution {
    public boolean isSubsequence(String s, String t) {
        int len_s = s.length();
        int k = 0;
        if(len_s == 0) {
            return true;
        }
        for(int i = 0; i < len_s; i++) {
            char char_s = s.charAt(i);
            while(k < t.length()) {
                char char_t = t.charAt(k);
                k++;
                if(char_s == char_t) {
                    if(i == len_s-1) {
                        return true;
                    }
                    break;
                }
            }
            if(k >= t.length()) {
                return false;
            }
        }
        return false;
        
    }
}