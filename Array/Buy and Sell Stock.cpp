/*
Runtime: 8 ms, faster than 98.70% of C++ online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 9.7 MB, less than 8.75% of C++ online submissions for Best Time to Buy and Sell Stock.

Complexity:
Runtime: O(N)
Space: O(1)

Algorithm 3:
To improve space complecity:
maximum profit = prices[i] - min(so far)
So we just need to keep the min of the previous elements

Note:
before accessing any element of the vector, check whether it's empty
*/
//////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if(len == 0) return 0;      //before accessing the first element!
        int min = prices[0];
        int maxpro = 0;
        for(int i = 0; i < len; i++) {
            if(prices[i] <= min) {
                min = prices[i];
                continue;
            }
            if(prices[i]-min > maxpro) maxpro = prices[i]-min;
        }
        return maxpro;
    }
};
//////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 8 ms, faster than 98.70% of C++ online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 9.8 MB, less than 5.08% of C++ online submissions for Best Time to Buy and Sell Stock.

Complexity:
Runtime: O(2*N)
Space: O(N)

Algorithm 2:
The first loop only creates large
And the second loop keeps min while comparing whether it generates max profit
*/
////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if(len == 0) return 0;
        int min = prices[0];
        int max = prices[len-1];
        vector<int> large(len);
        for(int i = 0; i < len; i++) {
          //determine the large
            if(prices[len-1-i] > max) max = prices[len-1-i];
            large[len-1-i] = max;
        }
        int maxpro = 0;
        for(int i = 0; i < len; i++) {
            if(prices[i] < min) min = prices[i];
            if(large[i] - min > maxpro) maxpro = large[i] - min;
        }
        return maxpro;
    }
};

//////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 12 ms, faster than 32.62% of C++ online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 9.8 MB, less than 5.08% of C++ online submissions for Best Time to Buy and Sell Stock.

Complexity:
Runtime: O(2*N)
Space: O(2*N)

Algorithm 1:
Find the following:
previous part's smallest
latter part's largest
maxprofit = large[i] - small[i]

Syntax:
1. create a fixed-length vector:
vector<int> large(len);
*/
/////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if(len == 0) return 0;
        int min = prices[0];
        int max = prices[len-1];
        vector<int> small(len);
        vector<int> large(len);
        for(int i = 0; i < len; i++) {
          //determine the large and small
            if(prices[i] < min) min = prices[i];
            small[i] = min;
            if(prices[len-1-i] > max) max = prices[len-1-i];
            large[len-1-i] = max;
        }
        int maxpro = 0;
        for(int i = 0; i < len; i++) {
            if(large[i] - small[i] > maxpro) maxpro = large[i] - small[i];
        }
        return maxpro;
    }
};
