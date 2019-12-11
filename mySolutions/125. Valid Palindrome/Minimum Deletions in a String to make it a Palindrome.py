//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gkX4prBkRLj

def find_minimum_deletions(st):
  # subtracting the length of Longest Palindromic Subsequence from the length of
  # the input string to get minimum number of deletions
  return find_LPS_length(st)


def find_LPS_length(st):
    


def main():
  print(find_minimum_deletions("abdbca"))
  print(find_minimum_deletions("cddpd"))
  print(find_minimum_deletions("pqr"))


main()
