/*
Runtime: 3 ms, faster than 97.94% of Java online submissions for ZigZag Conversion.
Memory Usage: 37.2 MB, less than 99.56% of Java online submissions for ZigZag Conversion.

Complexity: O(N)

Algorithm 4:
Standard solution with clearer structure
Cycle/Pattern Questions:
Declare a variable as the cyclelen which can save a lot of time and make it clearer

Syntax:
1. StringBuilder object: mutable string which saves space
The StringBuilder in Java represents a mutable sequence of characters. 
Since the String Class in Java creates and immutable sequence of characters, 
the StringBuilder class provides an alternate to String Class, as it creates a mutable sequence of characters.

StringBuilder ret = new StringBuilder();
ret.append();
ret.toString()      //convert StringBuilder to String
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder result = new StringBuilder();
        int cycle = 2*numRows-2;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j+i < s.length(); j+=cycle){
                result.append(s.charAt(j+i));
                if(i != 0 && i != numRows-1 && j+cycle-i < s.length()){
                    result.append(s.charAt(j+cycle-i));
                }
            }
            
        }
        return result.toString();
    }
}
/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 20 ms, faster than 48.42% of Java online submissions for ZigZag Conversion.
Memory Usage: 38.2 MB, less than 92.69% of Java online submissions for ZigZag Conversion.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 3:
Simplified version based on Algorithm 2
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        String result = "";
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < numRows; i++) {
            int k = 0;
            index1 = i + (k/2)*(2*numRows-2);
            index2 = ((k+1)/2)*(2*numRows-2) - i;
            while((k%2 == 0 && index1 < s.length()) || (k%2 != 0 && index2 < s.length())) {
                if(k % 2 == 0) {
                    result = result + s.charAt(index1);
                }else if(i != 0 && i != numRows-1){
                    result = result + s.charAt(index2);
                }
                k++;
                index1 = i + (k/2)*(2*numRows-2);
                index2 = ((k+1)/2)*(2*numRows-2) - i;
            }         
        }
        return result;
    }
}
//////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 19 ms, faster than 54.18% of Java online submissions for ZigZag Conversion.
Memory Usage: 39.3 MB, less than 80.36% of Java online submissions for ZigZag Conversion.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 2:
Improve from algorithm 1 to directly get result without using a grid to match its positions
Assume the start of the pattern index is i
For the kth row:
if colindex is even: i+ (2*numRows-2)
if colindex is odd: i+(2*numRows-2-k)
*/
/////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        String result = "";
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < numRows; i++) {
            int k = 0;
            if(i == 0 || i == numRows-1) {
                while(i+k*(2*numRows-2) < s.length()) {
                    result = result + s.charAt(i+k*(2*numRows-2));
                    k++;
                }
            }else{
                while((k%2==0 && i + (k/2)*(2*numRows-2) < s.length()) || (k%2!=0 && ((k+1)/2)*(2*numRows-2) - i < s.length())) {
                    //Note: here 2 conditions in || relationship
                    //System.out.println("i is: "+ i);
                    if(k % 2 == 0) {
                        //System.out.println("k is even: "+ k);
                        //System.out.println("index is : "+ (i + (k/2)*(2*numRows-2)));
                        result = result + s.charAt(i + (k/2)*(2*numRows-2));
                    }else {
                        //System.out.println("k is odd: "+ k);
                        //System.out.println("index is: "+ (((k+1)/2)*(2*numRows-2) - i));
                        result = result + s.charAt(((k+1)/2)*(2*numRows-2) - i);
                        //Note: (k+1)/2
                    }
                    k++;
                }
                
            }
        }
        return result;
    }
}
///////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 213 ms, faster than 5.01% of Java online submissions for ZigZag Conversion.
Memory Usage: 49 MB, less than 5.02% of Java online submissions for ZigZag Conversion.

Complexity:
runtime: O(N)
space: O(ZigZagspace)

Algorithm 1:
Use a 2d array to store strings and for each char, map it into the array
After this, loop through the grid to get the result
Note:
whichcol and whichrow are not index, the index should be whichcol-1 and whichrow-1

What is ZigZag pattern?
https://en.wikipedia.org/wiki/Zigzag

Syntax:
1. declare a 2d array
int[][] myArray = new int[3][5] ;

Habit:
Always rememeber to initialize the variable if it's assigned value in latter loop or if-else
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
        int whichcol =  1;      //must initialize 
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
