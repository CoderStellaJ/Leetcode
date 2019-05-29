/*
Algorithm:

Note:
for taking string as int questions, please check whether the type is correct, whether you've converted all the types

Syntax:
1. convert character to int
Character.getNumericValue()
2. for number >= 10, need to use String instead of Character
3. remove all white spaces in a string
mysre = mystr.replaceAll("\\s","");
remember to assign the replaced result back to mystr!
4. compare 2 strings
cannot use ==, because it compares whether the 2 strings are the same object
we can only use str1.equals(str2) actually compares the content of the string
This method returns true if the String are equal; false otherwise.
5. stack.pop()
This method returns the element present at the top of the stack and then removes it.
6. Character.isDigit(mychar)
7. split a string based on multiple delimiters
String[] operands = s.split("[+|-|*|/]");
8. string comparison: mystr.equals("")
9.queue
offer/poll/peek
10.  arraylist
ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object
11. convert an array to arraylist
ArrayList<Element> arrayList = new ArrayList<Element>(Arrays.asList(array));
*/
//////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int calculate(String s) {
        int res = 0;
        String opt="";
        //remove all empty spaces in a string
        s = s.replaceAll(" ","");
        if(s.length() == 0) return 0;
        Stack<String> mystack = new Stack<String>();
        Stack<String> simple = new Stack<String>();
        StringBuilder operand = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if(Character.isDigit(c)) operand.append(c);
          if(!Character.isDigit(c) || i == s.length()-1){
            int val = Integer.parseInt(operand.toString());
            operand = new StringBuilder();
            if(!mystack.isEmpty() && (mystack.peek().equals("*") || mystack.peek().equals("/"))){
              opt = mystack.pop();
              int value1 = Integer.parseInt(mystack.pop());
              if(opt.equals("*")){
                mystack.push(Integer.toString(val*value1));
              }else{
                mystack.push(Integer.toString(value1/val));
              }
            }else{
              mystack.push(Integer.toString(val));
            }
            if(i != s.length()-1) mystack.push(Character.toString(c));
          }
        }
        //the last digit
        //simple.push(operand.toString()); //cannot do this because you consider the operator before it e.g. 3+2*2
        while(!mystack.isEmpty()){
          simple.push(mystack.pop());
        }
        while(simple.size() > 1){
          int value1 = Integer.parseInt(simple.pop());
          opt = simple.pop();
          int value2 = Integer.parseInt(simple.pop());
          if(opt.equals("+")){
            simple.push(Integer.toString(value1+value2));
          }else{
            simple.push(Integer.toString(value1-value2));
          }
        }
        res = (simple.size() == 1) ? Integer.parseInt(simple.pop()):0;
        return res;
    }
}
