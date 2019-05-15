/*
Runtime: 48 ms, faster than 25.49% of Java online submissions for Count Primes.
Memory Usage: 33.3 MB, less than 49.01% of Java online submissions for Count Primes.

Algorithm:
after marking all the multiples of numbers smaller than k,
if k is not marked, it's prime without passing into isprime function

Syntax:
1. java has type boolean
The array will be initialized to false when you allocate it.
*/
///////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] mark = new boolean[n];
        for(int i = 2; i < n; i++) {
            for(int k = 2; k*i < n; k++) {
                mark[k*i] = true;    
            }
            if(mark[i] == false){
                count++;   
            }
        }
        return count;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 360 ms, faster than 16.82% of Java online submissions for Count Primes.
Memory Usage: 39.7 MB, less than 6.01% of Java online submissions for Count Primes.

Algorithm 2: 
for each number, mark its multiples as non prime
*/
//////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) return 0;
        int count = 0;
        int[] mark = new int[n];
        mark[2] = 1;
        for(int i = 2; i < n; i++) {
            int k = 2;
            while(k*i < n){
                mark[k*i] = -1;
                k++;
            }
            if(mark[i] != -1 && isprime(i)){
                count++;   
            }
        }
        return count;
    }
    public Boolean isprime(int i){
        if(i == 2) return true;
        for(int j = 2; j <= (int)Math.sqrt(i); j++){
            if(i%j == 0) return false;
        }
        return true;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 470 ms, faster than 15.31% of Java online submissions for Count Primes.
Memory Usage: 31.9 MB, less than 90.93% of Java online submissions for Count Primes.

Algorithm 1:
check whether each number is prime
Note:
the question says count the number of primes less than n which excludes n itself!!!

syntax:
1. squareroot
Math.sqrt(num);

*/
////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isprime(i)){
                count++;
            }
        }
        return count;
    }
    public Boolean isprime(int i){
        if(i == 2) return true;
        for(int j = 2; j <= (int)Math.sqrt(i); j++){
            if(i%j == 0) return false;
        }
        return true;
    }
}
