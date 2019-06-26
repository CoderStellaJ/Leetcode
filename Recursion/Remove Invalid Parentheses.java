/*
Runtime: 50 ms, faster than 40.82% of Java online submissions for Remove Invalid Parentheses.
Memory Usage: 45.6 MB, less than 15.54% of Java online submissions for Remove Invalid Parentheses.

Complexity:
runtime: O(2^N)
space: O(N)

Explanations for the Question:
if we start looking at each of the bracket from left to right, 
1. as soon as we encounter a closing bracket, there should be an unmatched opening bracket available to match it. 
2. The expression can also become invalid if the number of opening parentheses 
i.e. ( are more than the number of closing parentheses i.e. ).
3. We can remove multiple different sets of K brackets that will eventually give us the same final expression. 
But, each valid expression should be recorded only once. 
4. For every bracket we have two choices:
1) Either it can be considered a part of the final expression OR
2) It can be ignored i.e. we can delete it from our final expression.

Algorithm:
1. Initialize an array that will store all of our valid expressions finally.
2. Start with the leftmost bracket in the given sequence and proceed right in the recursion.
3. The state of recursion is defined by the index which we are currently processing in the original expression. 
Let this index be represented by the character i. 
3. Also, we have two different variables left_count and right_count 
that represent the number of left and right parentheses we have added to our expression till now. 
These are the parentheses that were considered.
4. If the current character i.e. S[i] (considering S is the expression string) is neither a closing or an opening parenthesis, 
then we simply add this character to our final solution string for the current recursion.
5. However, if the current character is either of the two brackets i.e. S[i] == '(' or S[i] == ')', then we have two options. 
We can either discard this character by marking it an invalid character 
or we can consider this bracket to be a part of the final expression.
6. When all of the parentheses in the original expression have been processed, 
we simply check if the expression represented by expr i.e. the expression formed till now is valid one or not. 
7. The way we check if the final expression is valid or not is by looking at the values in left_count and right_count. 
For an expression to be valid left_count == right_count. If it is indeed valid, then it could be one of our possible solutions.
8. Even though we have a valid expression, we also need to keep track of the number of removals we did to get this expression. 
This is done by another variable passed in recursion called rem_count.
Once recursion finishes we check if the current value of rem_count is < the least number of steps 
we took to form a valid expression till now i.e. the global minima. 
If this is not the case, we don't record the new expression, else we record it.

Syntax:
1. hashset clear
myset.clear()
2. StringBuilder
sb.deleteCharAt(index)
*/
//////////////////////////////////////////////////////////////////////////
class Solution {
  private Set<String> validExpressions = new HashSet<>();
  private int minRemoved;
  
  private void reset() {
    this.validExpressions.clear();
    this.minRemoved = Integer.MAX_VALUE;
  }
  
  private void recurse(String s, int index, int leftCount, int rightCount, StringBuilder expression, int removedCount) {
    if(index == s.length()) {
      if(leftCount == rightCount) {
        if(removedCount <= this.minRemoved) {
          String possibleAns = expression.toString();
          if(removedCount < this.minRemoved) {
            this.validExpressions.clear();
            this.minRemoved = removedCount;
          }
          this.validExpressions.add(possibleAns);
        }
      }
    }else {
      char currentChar = s.charAt(index);
      int len = expression.length();
      if(currentChar != '(' && currentChar != ')') {
        expression.append(currentChar);
        //add the non-bracket chars to final expression
        this.recurse(s, index+1, leftCount, rightCount, expression, removedCount);
        expression.deleteCharAt(len);
      }else {
        //remove current bracket
        this.recurse(s, index+1, leftCount, rightCount, expression, removedCount+1);
        //keep current char
        expression.append(currentChar);
        
        if(currentChar == '(') {
          this.recurse(s, index+1, leftCount+1, rightCount, expression, removedCount);
        }else if(leftCount > rightCount) {
          //important, add ) only if ( > ) 
          this.recurse(s, index+1, leftCount, rightCount+1, expression, removedCount);
        }
        // change expression back for other recurses because changes is made directly to the object
        expression.deleteCharAt(len);
      }
    }
  }
  
  public List<String> removeInvalidParentheses(String s) {
    this.reset();
    this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList<String>(this.validExpressions);
  }
}
