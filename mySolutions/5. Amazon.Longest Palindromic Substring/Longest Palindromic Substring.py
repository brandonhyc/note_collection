#https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2yRjwxBY7A

def find_LPS_length(st):
  return find_LPS_length_recursive(st, 0, len(st) - 1)


def find_LPS_length_recursive(st, startIndex, endIndex):
  if startIndex > endIndex:
    return 0

  if startIndex == endIndex:
    return 1

  if st[startIndex] == st[endIndex]:
    remainingLength = endIndex - startIndex - 1
    if remainingLength == find_LPS_length_recursive(st, startIndex + 1, endIndex - 1):
      return remainingLength + 2

  # case 2: skip one character either from the beginning or the end
  c1 = find_LPS_length_recursive(st, startIndex + 1, endIndex)
  c2 = find_LPS_length_recursive(st, startIndex, endIndex - 1)
  return max(c1, c2)


def main():
  print(find_LPS_length("abdbca"))
  print(find_LPS_length("cddpd"))
  print(find_LPS_length("pqr"))


main()
