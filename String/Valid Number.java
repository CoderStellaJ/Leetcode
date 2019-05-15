/*
Runtime: 49 ms, faster than 5.23% of Java online submissions for Valid Number.
Memory Usage: 36.4 MB, less than 92.14% of Java online submissions for Valid Number.

Complexity:
runtime: O(N)
trim() //O(N)
count() //O(N)
loop through //O(N)
space: O(1)

Algorithm 2:
1. trim the string so that all leading and trailing spaces are removed.
2. count the number of "e" in string
3. split the string based on indexOf("e")
    index of "e" cannot be 0 and cannot be s.length()-1
3. check the left part first:
    at most 1 "." and sign
    sign is the first element and not the last element
    "." : before can be empty, latter must be digit OR
    "." : before is a digit, latter is nothing in part1
    can only be digit apart from the sign and "."
4. check the right part
    sign is the first element and not the last element
    the rest must all be digits
5.count number of occurrences of a char in string

Corner cases:
1. "3." -> true
2. "3.e" -> false
3. ".1" -> correct
4. "." -> false
5. ".." ->false
6. "2e0" -> true
7. ".1." -> false
8. "46.e3" -> true
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean isNumber(String s) {
        //remove all leading and trailing space first 
        s = s.trim();
        if(s.length() == 0) return false;
        //check cases when there are 0e, 1e, more than 1e
        long count = s.chars().filter(ch -> ch == 'e').count();
        //System.out.println(count);
        String part1 = "";
        int index = s.indexOf("e");;
        if(count >= 2) return false;
        if(count == 0) {
            part1 = s;
        }else if(count == 1) {
            if(index == 0 || index == s.length()-1) return false;
            part1 = s.substring(0,index);
        }
        Boolean part1sign = false;
        //System.out.println("part1 is "+part1);
        for(int i = 0; i < part1.length(); i++) {
            char c = part1.charAt(i);
            long countdot = part1.chars().filter(ch -> ch == '.').count();
            long countpos = part1.chars().filter(ch -> ch == '+').count();
            long countneg = part1.chars().filter(ch -> ch == '-').count();
            if(countdot >= 2) return false;
            if(countpos + countneg >= 2) return false;
            if(c == '+' || c == '-'){
                part1sign = true;
                if(i != 0 || (i == 0 && part1.length() == 1)){
                    return false;
                }
            }else if(c == '.'){
              //before "." it can be empty but must be followed by a digit
                if(i == part1.length()-1 || (i != part1.length()-1 && !Character.isDigit(part1.charAt(i+1)))){
                    if(!(i == part1.length()-1 && i >= 1 && Character.isDigit(part1.charAt(i-1))))
                    return false;
                }
            }else if(!Character.isDigit(c)){
                return false;
            }
        }
        if(count == 1) {
            String part2 = s.substring(index+1);
            //System.out.println("part2 is "+part2);
            Boolean part2sign = false;
            for(int i = 0; i < part2.length(); i++) {
                char c = part2.charAt(i);
                if(c == '+' || c == '-'){
                    part2sign = true;
                    if(i != 0 || (i == 0 && part2.length() == 1)){
                        return false;
                    }
                }else if(!Character.isDigit(c)){
                    return false;
                }
            }
        }
        return true;
    }
}
/////////////////////////////////////////////////////////////////////////
/*
Runtime error
Special case "e"

Algorithm 1:
1. split based on " " and make sure there is no " " in between (apart from leading and trailing spaces)
2. split string based on "e" to make sure there is only one e in string
3. check the left part first:
    sign is the first element and not the last element
    "." cannot follow sign and can't be the last
    can only be digit apart from the sign and "."
4. check the right part
    sign is the first element and not the last element
    the rest must all be digits

Syntax:
1. check a string using delimiter
String[] segs = mystr.split(",");
When String.split(String regex) is called, it is called with limit = 0, which will remove all trailing empty strings in the array
2. check whether a char is digit
Character.isDigit(mychar);
3. print out an array
System.out.println(Arrays.toString(segs));
4.convert an array to list
Arrays.asList(myarr)
5. mylist.size()
6. mystr.trim() 
helps to truncate the leading and trailing spaces in a string
7.count number of occurrences of a char in string
long count = s.chars().filter(ch -> ch == 'e').count();   //type is long

Corner case:
1. string containing spaces " -6 "
2. "e"
mystr.split("e") will return ["", "e", ""]

*/
///////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean isNumber(String s) {
        if(s.length() == 0) return false;
        //remove all leading and trailing space first 
        String[] spacesegs = s.split(" ");
        Boolean start = false;
        int index = 0;
        for(int j = 0; j < spacesegs.length; j++){
            if(spacesegs[j] != "") {
                start = true;
                index = j;
            }else{
                if(start == true) return false;
            }
        }
        s = spacesegs[index];
        String[] segs = s.split("e");
        //System.out.println(Arrays.toString(segs));
        //for debugging
        if(segs.length > 2) return false;
        //can only have 1 e at most
        //doesn't contain e
        String part1 = segs[0];
        Boolean part1sign = false;
        for(int i = 0; i < part1.length(); i++) {
            char c = part1.charAt(i);
            if(c == '+' || c == '-'){
                part1sign = true;
                if(i != 0 || (i == 0 && part1.length() == 1)){
                    return false;
                }
            }else if(c == '.'){
                if(i == part1.length()-1 || (i == 1 && part1sign == true)){
                    return false;
                }
            }else if(!Character.isDigit(c)){
                return false;
            }
        }
        if(segs.length == 2) {
            String part2 = segs[1];
            Boolean part2sign = false;
            for(int i = 0; i < part2.length(); i++) {
                char c = part2.charAt(i);
                if(c == '+' || c == '-'){
                    part2sign = true;
                    if(i != 0 || (i == 0 && part2.length() == 1)){
                        return false;
                    }
                }else if(!Character.isDigit(c)){
                    return false;
                }
            }
        }
        return true;
    }
}
