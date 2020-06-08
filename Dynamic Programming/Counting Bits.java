/*
based on observation: 
for 2^n, the count is just 1
for number falling in range [2^n+1, 2^(n+1)], the count is 1+res[num-closestPowerOfTwo]

time: O(N)
space: O(N)

Runtime: 5 ms, faster than 14.38% of Java online submissions for Counting Bits.
Memory Usage: 43.3 MB, less than 5.88% of Java online submissions for Counting Bits.

*/

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if(num >= 1) {
            res[1] = 1;
        }
        
        for(int i = 2; i <= num; i++) {
            int power = computePower(i);
            if(power == -1) {
                //power of 2
                res[i] = 1;
            }else {
                int closePower = (int)Math.pow(2, power);
                res[i] = 1 + res[i-closePower];
            }
        }
        return res;
        
    }
    
    public int computePower(int num) {
        double val = Math.log(num)/Math.log(2);
        if((int)val == val) {
            return -1;  //power of 2
        }
        return (int)val;
    }
}