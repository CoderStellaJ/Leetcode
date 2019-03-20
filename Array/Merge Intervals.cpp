/*
Runtime: 204 ms, faster than 7.09% of C++ online submissions for Merge Intervals.
Memory Usage: 11.1 MB, less than 13.19% of C++ online submissions for Merge Intervals.

Complexity: O(NlogN)

Algorithm 1:
sort the vector based on starting time. And loop thorugh the sorted vector once to merge the intervals

Note:
1. start1 and end1 should be assigned values after the vector is sorted!!!
And update start1 and start2 once intervals[k] changes or k updates.
2. remove elements of vector in a loop is dangerous because index changes after removal. i shouldn't increase in next iteration.

Syntax:
1. vector std::sort, you can write your own comparison function
note: it's in increasing order, return A < B
And the function should be static function.
2. myvec.erase(myvec.begin() + i);

Corner Case:
1. the vector intervals is empty. For array/vector problem, always check whether it's empty before doing any operations.
Otherwise, there will be Runtime Error
*/
////////////////////////////////////////////////////////////////////////
/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
bool compareFunc(Interval a, Interval b) {
    return a.start < b.start;
}

class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        int k = 0;
        if(intervals.empty()) return intervals;
        int start1, end1;
        int start2, end2;
        sort(intervals.begin(), intervals.end(), compareFunc);		//O(NlogN)
    	/*for(int j = 0; j < intervals.size(); j++) {
	    	cout<<"["<<intervals[j].start<<","<<intervals[j].end<<"]"<<endl;
        }*/
        start1 = intervals[0].start;
        end1 = intervals[0].end;
        for(int i = 1; i < intervals.size(); ) {
            start2 = intervals[i].start;
            end2 = intervals[i].end;
            if(end1 >= start2) {
                if(end1 < end2) {		
                    intervals[k].end = end2;
                    end1 = end2;
                }
                //cout<<i<<" removed"<<endl;
                intervals.erase(intervals.begin()+i);	
            }else {
                k++;
                start1 = intervals[k].start;
                end1 = intervals[k].end;
                i++;
            }	
        }
        return intervals;
    }
};
