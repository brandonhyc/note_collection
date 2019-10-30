from collections import deque

class Solution:
    def sequenceReconstruction(self, org: List[int], seqs: List[List[int]]) -> bool:

        inDegree = {}
        graph = {}
        order = []

        # init
        for seq in seqs: 
            for i in range(len(seq)):
                inDegree[seq[i]] = 0
                graph[seq[i]] = []

        # build
        for seq in seqs:
            for i in range(len(seq) - 1):
                parent = seq[i]
                child = seq[i + 1]

                inDegree[child] += 1
                graph[parent].append(child)

        
        sources = deque()
        # seed
        for key in inDegree:
            if inDegree[key] == 0:
                sources.append(key)

        # traverse
        while sources:
            if len(sources) > 1:
                return False
            
            source = sources.popleft()
            order.append(source)

            for i in graph[source]:
                inDegree[i] -= 1
                if inDegree[i] == 0:
                    sources.append(i)
        
        return order == org