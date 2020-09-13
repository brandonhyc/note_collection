from collections import defaultdict
from tracestack import trace
@trace
def findAllLessThanTwoParents(graph):
    d = defaultdict(list)
    degree = {}
    degree = defaultdict(lambda: 0, degree)
    res = set()
    for parent, child in graph:
        d[parent].append(child)
        degree[child] += 1
    print(degree)

    for parent, child in graph:
        if degree[parent] <= 1: 
            res.add(parent)
        if degree[child] <= 1:
            res.add(child)

    return res


res = findAllLessThanTwoParents([[1,4], [1,5], [2,5], [3,6], [6,7]])
print(res)