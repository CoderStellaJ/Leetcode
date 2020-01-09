/*
DP
Time: O(m+n)
Memory: O(m+n)
Note: the index of the array and char

Memory can be improved to O(n) by only keeping a 1d array for DP.
because everytime updating F[i][j] only needs F[i-1][j] (old value of dp[j]) and F[i][j-1] (dp[j-1])
so we don't need to keep record of F[i-1][j-1]
*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len_s1 = s1.length();
        int len_s2 = s2.length();
        int len_s3 = s3.length();
        if(len_s3 != (len_s1 + len_s2)) {
            return false;
        }
        boolean[][] F = new boolean[len_s2+1][len_s1+1];
        for(int i = 0; i <= len_s2; i++) {
            for(int j = 0; j <= len_s1; j++) {
                if(i == 0 && j == 0) {
                    F[0][0] = true;
                }else if(i == 0) {
                    if(s3.substring(0,j).equals(s1.substring(0,j))) {
                        F[i][j] = true;
                    }else {
                        F[i][j] = false;
                    }
                }else if(j == 0) {
                    if(s3.substring(0,i).equals(s2.substring(0,i))) {
                        F[i][j] = true;
                    }else {
                        F[i][j] = false;
                    }
                }else {
                    if(F[i-1][j] == true) {
                        if(s3.charAt(i+j-1) == s2.charAt(i-1)) {
                            F[i][j] = true;
                        }
                    }
                    if(F[i][j-1] == true) {
                        if(s3.charAt(i+j-1) == s1.charAt(j-1)) {
                            F[i][j] = true;
                        }
                    }
                }
            }
        }
        return F[len_s2][len_s1];
    }
}