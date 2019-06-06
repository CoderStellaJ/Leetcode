/*
Runtime: 307 ms, faster than 8.56% of Java online submissions for Find Median from Data Stream.
Memory Usage: 67.4 MB, less than 38.60% of Java online submissions for Find Median from Data Stream.

Complexity:
runtime: O(N) (find position + shift)
if replace insertion sort with binary search then insert O(logN + N) = O(N)
shifting takes lots of time

Algorithm 1: List
insert element into a list

Runtime: 307 ms, faster than 8.56% of Java online submissions for Find Median from Data Stream.
Memory Usage: 67.4 MB, less than 38.60% of Java online submissions for Find Median from Data Stream.
*/
///////////////////////////////////////////////////////////////////////////////////////////
class MedianFinder {
    int index1, index2;
    List<Integer> list;
        /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        for(int i = 0; i < list.size(); i++) {
          if(num <= list.get(i)) {
            list.add(i,num);
            return;
          }
        }
        list.add(num);
    }

    public double findMedian() {
        if(list.size()==0) return 0.0;
        if(list.size()==1) return list.get(0)*1.0;
        if(list.size()%2 == 0){
          return (list.get(list.size()/2) + list.get(list.size()/2-1))*1.0/2;
        }else{
          return list.get(list.size()/2)*1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
