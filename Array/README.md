# Array

### Syntax
1. Create a vector of fixed length
<br/>std::vector<int> v(10);
<br/>std::vector<int> v(10, 0);  //initialized to all 0
<br/>vector<vector<int> > vect{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };   //initialize using { }
<br/>vector<vector<int>> vec(m, vector<int> (n, 0));   //a m*n vector
  

### Common Problems
- remove or add elements while iterating 
- Check whether the vector is empty before accessing any element
