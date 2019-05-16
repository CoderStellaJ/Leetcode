/*
Runtime: 213 ms, faster than 5.01% of Java online submissions for ZigZag Conversion.
Memory Usage: 49 MB, less than 5.02% of Java online submissions for ZigZag Conversion.

Complexity:
runtime: O(N)
space: O(ZigZagspace)

What is ZigZag pattern?
https://en.wikipedia.org/wiki/Zigzag

Syntax:
1. declare a 2d array
int[][] myArray = new int[3][5] ;
*/
//////////////////////////////////////////////////////////////////////////
class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        String result = "";
        int numcol;
        numcol = (s.length()/(2*numRows-2))*(numRows-1);
        int rest = s.length()%(2*numRows-2);
        if(rest >= 1 && rest <= numRows) {
            numcol += 1;
        }else if(rest > numRows){
            numcol += (rest-numRows + 1);
        }
        //initialization
        String[][] grid = new String[numRows][numcol];
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numcol; j++) {
                grid[i][j] = "";
            }
        }
        int whichcol =  1;
        int whichrow = 1;
        int rmd;
        for(int k = 0; k < s.length(); k++) {
            String c = Character.toString(s.charAt(k));
            rmd = (k+1) % (2*numRows-2);
            whichcol = ((k+1)/(2*numRows-2))*(numRows-1);
            if(rmd <= numRows && rmd >= 1){
                whichcol += 1;
                whichrow = rmd;
            }else if(rmd > numRows){
                whichcol += (rmd-numRows + 1);
                whichrow = numRows - (rmd - numRows);
            }else if(rmd == 0) {
                whichrow = 2;
            }
            grid[whichrow-1][whichcol-1] = c;
        }
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numcol; j++) {
                result = result + grid[i][j];
            }
        }
        return result;
    }
}
