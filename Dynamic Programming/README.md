# Dynamic Programming

### Key part
Dynamic programming is a method to store the results of the subproblems we have solved 
to avoid the situation that we solve the same subproblem over and over again.
So the most important thing in designing a DP is to think about:

How to write down that relationship equation:
- What is the subproblem? How do we represent it?
  - s.substring(i,j)
  - s.substring(i)
- What kind of information are we going to store?
  - answer of subproblem
  - some other element needed for answer
- How to store it?
  - array
  - hashmap
- Iteration sequence?
  - taking the right element as the outer loop can help you reduce the dimension of sp array
