/*
Runtime: 0 ms, faster than 100.00% of Bash online submissions for Tenth Line.
Memory Usage: 3.7 MB, less than 75.27% of Bash online submissions for Tenth Line.

Syntax:
tail and head
*/
/////////////////////////////////////////////////////////////////////
# Read from the file file.txt and output the tenth line to stdout.
tail -n +10 file.txt|head -n 1
//tail get the last 10 lines
//head get the first line from the tail output
