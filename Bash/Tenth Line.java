/*
Runtime: 0 ms, faster than 100.00% of Bash online submissions for Tenth Line.
Memory Usage: 3.7 MB, less than 75.27% of Bash online submissions for Tenth Line.

Syntax:
1. head
By default, ‘head’ command reads first 10 lines of the file. 
If you want to read more or less than 10 lines from the beginning of the file then you have to use ‘-n’ option with ‘head’ command.
1) -n 5
The first five lines of products.txt file will be shown in the output.
$ head -n 5 products.txt
2) -n -7
The following command will omit the last 7 lines from products.txt file.
$ head -n -7 products.txt
3) -n +10

2.tail
By default, ‘tail’ command reads last 10 lines of the file. 
If you want to read more or less than 10 lines from the ending of the file then you have to use ‘-n’ option with ‘tail’ command.
1) -n 2
When you want to read particular lines from the ending of the file then you have to use ‘-n’ option with positive value. 
The following command will display the last 2 lines of employee.txt file.
$ tail -n 2 employee.txt
2) -n -3
If you want to omit the specific lines from the beginning then you have to use ‘-n’ option with negative value in ‘tail’ command. 
The following command will display the content of employee.txt file by omitting 3 lines from the beginning.
$ tail -n -3 employee.txt

3.head and tail
The following command will read lines from 2 to 6 of products.txt file. 
At first, ‘head’ command will retrieve first 6 lines by omitting the last 5 lines for negative value 
and ‘tail’ command will retrieve the last 5 line from the output of ‘head’ command.
$ head -n -5 products.txt | tail -n 5

*/
/////////////////////////////////////////////////////////////////////
// Read from the file file.txt and output the tenth line to stdout.
tail -n +10 file.txt|head -n 1
//tail reads the 10th line onwards(including the 10th line)
//head get the first line from the tail output
