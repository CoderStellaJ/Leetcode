/*
Runtime: 20 ms, faster than 18.29% of C++ online submissions for Simplify Path.
Memory Usage: 11.5 MB, less than 66.05% of C++ online submissions for Simplify Path.

Complexity: O(N)

Note:
1. directory name can be "..."
2. for ".." and "..." and dirname, you need to make sure there is an end 

Syntax:
mystack.pop() return type is void. So you need to mystack.top() and then mystack.pop()
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
