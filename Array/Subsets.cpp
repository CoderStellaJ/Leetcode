/*
Syntax:
1. Copy a vector
std::vector<Foo> f;
std::vector<Foo> cp = f; //deep copy. All Foo copied

std::vector<Foo*> f;
std::vector<Foo*> cp = f; //deep copy (of pointers), or shallow copy (of objects).
//All pointers to Foo are copied, but not Foo themselves

vector<int> newvec = vec; //is deep copy
*/
////////////////////////////////////////////////////////////////////
