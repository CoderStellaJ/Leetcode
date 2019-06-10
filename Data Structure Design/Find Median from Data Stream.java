/*
Runtime: 133 ms, faster than 13.81% of Java online submissions for Find Median from Data Stream.
Memory Usage: 66.2 MB, less than 55.02% of Java online submissions for Find Median from Data Stream.

Complexity:
runtime: O(5logN)
space: O(N)

Algorithm 2: 2 Heaps
A max-heap to store the smaller half of the input numbers.
A min-heap to store the larger half of the input numbers.

If k = 2*n + 1 , then lo is allowed to hold n+1 elements, while hi can hold nn elements.
If k = 2*n , then both heaps are balanced and hold n elements each.

Adding a number num:
1. Add num to max-heap lo. Since lo received a new element, we must do a balancing step for hi. 
So remove the largest element from lo and offer it to hi.
2. The min-heap hi might end holding more elements than the max-heap lo, after the previous operation. 
We fix that by removing the smallest element from hi and offering it to lo.

Syntax:
1. Heap: by default, it's min Heap
Min Heap: PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(); 
Max Heap: PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(Collections.reverseOrder()); 
*/
///////////////////////////////////////////////////////////////////////////////////////////
class MedianFinder {
  /** initialize your data structure here. */
  PriorityQueue<Integer> lo; 
  PriorityQueue<Integer> hi;
  public MedianFinder() {
    lo = new PriorityQueue<>(Collections.reverseOrder());
    hi = new PriorityQueue<>();
  }

  public void addNum(int num) {
    //preassume: lo and hi are balanced already
    lo.offer(num);
    hi.offer(lo.peek());
    lo.poll();
    if(lo.size() < hi.size()){
      lo.offer(hi.poll());
    }
  }

  public double findMedian() {
    return (lo.size() > hi.size())?lo.peek():(lo.peek()+hi.peek())*0.5;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
///////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 307 ms, faster than 8.56% of Java online submissions for Find Median from Data Stream.
Memory Usage: 67.4 MB, less than 38.60% of Java online submissions for Find Median from Data Stream.

Complexity:
runtime: O(N) (find position + shift)
if replace insertion sort with binary search then insert O(logN + N) = O(N)
shifting takes lots of time
space: O(N)

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
