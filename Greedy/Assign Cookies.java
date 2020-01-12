/*
time complexity: O(m+n)
memory: O(1)

note:
when to break to move on to the next problem is important

*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //sort the arrays
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int k = 0;
        for(int i = 0; i < g.length; i++) {
            int g_fac = g[i];
            while(k < s.length) {
                int cookie = s[k];
                k++;
                if(cookie >= g_fac) {
                    count++;
                    break;
                }
            }
            if(k >= s.length) {
                break;
            }
        }
        return count;
        
    }
}