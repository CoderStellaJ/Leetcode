/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Spiral Matrix II.
Memory Usage: 9.2 MB, less than 6.62% of C++ online submissions for Spiral Matrix II.

Algorithm:
Recursion

Syntax:
1. Dynamically create a 2D array:
int** a = new int*[rowCount];
for(int i = 0; i < rowCount; ++i)
    a[i] = new int[colCount];
2. Create a vector of certain size:
vector<int> v(N,val); // v[0:N-1] are all equal to val
3. Create a 2D vector of certain size:
vector<vector<int>> result(n,vector<int>(n));
vector<vector<int>> result(n,vector<int>(n, 0));	//all initialized to 0
*/
///////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> result(n,vector<int>(n));
        matrix(result, n, n, 1);
        return result;
    }
	
    void matrix(vector<vector<int>>& result, int n, int size, int num) {
        int start = size-n;
        int end = n-1;
        if(start > end) {return;}
        //fill the outer shell
        for(int j = start; j <= end; j++) {
            result[start][j] = num;
            num++;
        }
        for(int i = start+1; i<= end; i++) {
            result[i][end] = num;
            num++;
        }
        for(int j = end-1; j >= start; j--) {
            result[end][j] = num;
            num++;
        }
        for(int i = end-1; i > start; i--) {
            result[i][start] = num;
            num++;
        }
        matrix(result, n-1, size, num);
    }
};
