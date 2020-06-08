/*
greedy solution
insert the tallest person first into the result list.
and then convert the list to the array

time: O(N)
space: O(N)

Runtime: 5 ms, faster than 99.65% of Java online submissions for Queue Reconstruction by Height.
Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Queue Reconstruction by Height.
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        //lambda function, desending order of the first element and ascending order of the second element
        Arrays.sort(people, (a,b)->(a[0] == b[0]? a[1]-b[1]:b[0]-a[0]));    
        
        for(int[] p: people) {
            res.add(p[1], p);
        }
        //convert list to array
        return res.toArray(new int[people.length][2]);
    }
}

/*
the algorithm is tricky
start from the shortest person in the remaining array. 
count how many unoccupied position and people with same height are in the front to decide.

time: O(N^2)
space: O(N)

Runtime: 47 ms, faster than 5.03% of Java online submissions for Queue Reconstruction by Height.
Memory Usage: 40.4 MB, less than 97.87% of Java online submissions for Queue Reconstruction by Height.
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        int[][] res = new int[len][2];
        for(int i = 0; i < res.length; i++) {
            res[i][0] = -1;
        }
        
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }else {
                    return Integer.compare(a[0], b[0]);
                }
            }
        });
        
//         for(int i = 0; i < people.length; i++) {
//             System.out.println(people[i][0] + " " + people[i][1]);
//         }
        
        for(int i = 0; i < people.length; i++) {
            int height = people[i][0];
            int count = people[i][1];
            int j = 0, k = 0;
            while(k < count) {
                if(res[j][0] == -1 || res[j][0] >= height) {
                    k++;
                }
                j++;
            }
            while(res[j][0] != -1) {
                j++;
            }
            res[j] = people[i];
        }
        return res;
    }
}