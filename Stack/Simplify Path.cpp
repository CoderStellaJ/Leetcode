/*
Runtime: 8 ms, faster than 100.00% of C++ online submissions for Simplify Path.
Memory Usage: 10.2 MB, less than 98.77% of C++ online submissions for Simplify Path.

Complexity: O(N)

Algorithm 2:
1. you just need the sequence of the folder names, can change to use vector structure
2. instead of taking in a char at a time, you can use '/' to separate the string

Syntax:
1. stringstream
A stringstream associates a string object with a stream allowing you to read from the string as if it were a stream (like cin).
2. getline
istream& getline (istream& is, string& str, char delim);
Extracts characters from is and stores them into str until the delimitation character delim is found
3. range-based for loop
for (const int& i : v)
for (auto i : v)
4. auto
auto is type inference, automatic deduction of the data type of an expression in a programming language
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    string simplifyPath(string path) {
        string res, tmp;
        vector<string> stk;
        stringstream ss(path);
        while(getline(ss,tmp,'/')) {
            if (tmp == "" or tmp == ".") continue;
            if (tmp == ".." and !stk.empty()) stk.pop_back();
            else if (tmp != "..") stk.push_back(tmp);
        }
        for(auto str : stk) res += "/"+str;
        return res.empty() ? "/" : res;
    }
};

////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 20 ms, faster than 18.29% of C++ online submissions for Simplify Path.
Memory Usage: 11.5 MB, less than 66.05% of C++ online submissions for Simplify Path.

Complexity: O(N)

Algorithm 1:
use stack to keep track of the sequence of the folder names. 
need to consider all the cases

Problem:
because you are processing the string char by char, it's complicated to represent the conditions for ".." and "..." 

Note:
1. directory name can be "..."
2. for ".." and "..." and dirname, you need to make sure there is an end 

Syntax:
1. mystack.pop() return type is void. So you need to mystack.top() and then mystack.pop()
2. str[i] == '/', str[i] gives you a char, you can't compare it with a string.
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    string simplifyPath(string path) {
        stack<std::string> dir;
        int strlen = path.length();
        string ans = "";
        string dirname = "";
        bool dirnow = false;
        
        for(int i = 0; i < strlen; i++) {
            if(path[i] == '.' && i!=strlen-1 && path[i+1] == '.' && ((i!=strlen-2 && path[i+2] == '/') || (i == strlen-2))) {
                //".." 
                i++;    //
                if(dir.empty() == false) {
                        dir.pop();
                }
            }else if(path[i] == '/'){
                // "/"
		    if(dirnow == true) {
			    dir.push(dirname);
			    dirnow = false;
			    dirname = "";
                    }
	    }else if(path[i] == '.' && (i==strlen-1 || (i!=strlen-1 && path[i+1] == '/'))) {
                //"." do nothing
            }else{
                //is some letter or "..."
		dirnow = true;
                int j;
                for(int j = i; j < strlen && path[j] != '/'; j++) {
                    dirname = dirname + path[j];
                }
                i = j-1;
            }
        }
        if(dirnow == true) {
            dir.push(dirname);
        }
        if(dir.empty()) {
            return "/";
        }
        
        while(!dir.empty()) {
            ans = "/" + dir.top() + ans;
            dir.pop();
        }
        return ans;
    }
};
