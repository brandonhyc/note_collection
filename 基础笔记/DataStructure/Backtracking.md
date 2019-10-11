# substring
remember when taking out the substring as a word, the loop should be i <= str.length() not just < so that could cut the whole str;

# subset 时间复杂度
https://www.1point3acres.com/bbs/thread-117602-1-1.html

# Permutations without Repetition
solutions: n!

# Combinations
solutions: n!

n!/r!(n − r)!



# Way to remove duplicate
1. use start
2. use isVisited boolean[]
3. use start < i && num[i] == num[i - 1], skip