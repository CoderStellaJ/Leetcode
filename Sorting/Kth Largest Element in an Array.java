/*
Runtime: 34 ms, faster than 25.49% of Java online submissions for Kth Largest Element in an Array.
Memory Usage: 35.9 MB, less than 96.97% of Java online submissions for Kth Largest Element in an Array.

Complexity:
runtime: worst: O(N^2); average: O(N)
n+1/2n+1/4n+... < 2n -> O(N)
space: O(1) in-place

Algorithm 3: QuickSelect
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return kthSmallest(nums,0,nums.length-1,nums.length-k+1);
    }
  
    public int partition(int [] arr, int start,  int end) 
    { 
        int pivot = arr[end], i = start; 
        for (int j = start; j <= end- 1; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                //Swapping arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
  
                i++; 
            } 
        } 
          
        //Swapping arr[i] and arr[r] 
        int temp = arr[i]; 
        arr[i] = arr[end]; 
        arr[end] = temp; 
  
        return i; 
    } 
      
    // This function returns k'th smallest element  
    // in arr[l..r] using QuickSort based method.  
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT 
    public int kthSmallest(int[] arr, int start,  int end, int k) 
    { 
        // If k is smaller than number of elements 
        // in array 
        if (k > 0 && k <= end - start + 1) 
        { 
            // Partition the array around last  
            // element and get position of pivot  
            // element in sorted array 
            int pos = partition(arr, start, end); 
  
            // If position is same as k 
            if (pos-start == k-1) 
                return arr[pos]; 
              
            // If position is more, recur for 
            // left subarray 
            if (pos-start > k-1)  
                return kthSmallest(arr, start, pos-1, k); 
  
            // Else recur for right subarray 
            return kthSmallest(arr, pos+1, end, k-pos+start-1); 
        } 
  
        // If k is more than number of elements 
        // in array 
        return Integer.MAX_VALUE; 
    } 
}
///////////////////////////////////////////////////////////////////////////////////
/*
Complexity:
runtime: O(Nlogk)
space:O(k)

Algorithm 2: MinHeap
*/
///////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 3 ms, faster than 81.77% of Java online submissions for Kth Largest Element in an Array.
Memory Usage: 38.1 MB, less than 58.72% of Java online submissions for Kth Largest Element in an Array.

Complexity:
runtime: O(nlogn)
space: O(1)

Algorithm 1: Sorting

Syntax:
1. Arrays.sort(myarr);
by default sort the array in ascending order
*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
    public int findKthLargest(int[] nums, int k) {
      if(nums.length == 0) return 0;
      Arrays.sort(nums);
      return nums[nums.length-k];
    }
}
