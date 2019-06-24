/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for Flatten Nested List Iterator.
Memory Usage: 37.3 MB, less than 99.89% of Java online submissions for Flatten Nested List Iterator.

Algorithm:
1. NestedIterator implements iterator so we can use iterator for list
2. create a flatten function and recursively call itself to flatten the list

Syntax:
1. inheritance:
class MountainBike extends Bicycle {
}

2. extends vs implements
extends is for extending a class.
implements is for implementing an interface

The difference between an interface and a regular class is that 
in an interface you can not implement any of the declared methods. 
Only the class that "implements" the interface can implement the methods. 
The C++ equivalent of an interface would be an abstract class (not EXACTLY the same but pretty much).

3. @Override
annotation informs the compiler that the element is meant to override an element declared in a superclass.
While it is not required to use this annotation when overriding a method, it helps to prevent errors. 
If a method marked with @Override fails to correctly override a method in one of its superclasses, the compiler generates an error.
*/
///////////////////////////////////////////////////////////////////////////////
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
  
  List<Integer> mylist;
  Iterator<Integer> iter;
  
  public NestedIterator(List<NestedInteger> nestedList) {
    mylist = new ArrayList<>();
    flatten(nestedList);
    iter = mylist.iterator();
  }
 
  public void flatten(List<NestedInteger> nestedList) {   //recursive function
    for(NestedInteger ni:nestedList){
      if(ni.isInteger()) mylist.add(ni.getInteger());
      else flatten(ni.getList());
    }
  }
  
  @Override
  public Integer next() {
    return iter.next();
  }

  @Override
  public boolean hasNext() {
    return iter.hasNext();
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
