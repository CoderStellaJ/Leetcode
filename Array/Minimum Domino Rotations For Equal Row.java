/*
just 1 iteration of the array. Take the first element of the array as the baseline and check the latter numbers.
complexity: O(N)
space: O(1)

*/
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int countA = 0, countB = 0;
        
        if(A.length <= 1) {
            return 0;
        }
        countA = count(A, B, A[0]);
        countB = count(A, B, B[0]);
        if(countA == -1 && countB == -1) {
            return -1;
        }else if (countA == -1) {
            return countB;
        }else if (countB == -1){
            return countA;
        }else {
            return Math.min(countA, countB);
        }
        

    }

    public int count(int[] A, int[] B, int number) {
        int countA = 0, countB = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != number && B[i] != number) {
                return -1;
            }else if(A[i] != number) {
                countA++;
            }else if(B[i] != number) {
                countB++;
            }
        }
        return Math.min(countA, countB);
    }
}