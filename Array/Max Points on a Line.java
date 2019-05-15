/*
Complexity:
ArrayList	contains	O(n)
LinkedList  contains	O(n)

Algorithm:

Syntax:
1. arraylist
List<String> animals = new ArrayList<>();
mylist.add(element);

2. Pair
There is no Pair in the standard framework
Pair p1 = new Pair(3,4); 

3. Instead of using Pair, we use Entry in Java
Map.Entry<String,Integer> entry = new AbstractMap.SimpleEntry<String, Integer>("exmpleString", 42);

4. Iterate through a map
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + "/" + entry.getValue());
}

*/
//////////////////////////////////////////////////////////////////
