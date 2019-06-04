# Dynamic Programming

### Key part
Dynamic programming is a method to store the results of the subproblems we have solved 
to avoid the situation that we solve the same subproblem over and over again.
So the most important thing in designing a DP is to think about:
- What is the subproblem? How do we represent it?
  - s.substring(i,j)
  - s.substring(i)
- How to store it?
  - array
  - hashmap
