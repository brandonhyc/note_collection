from collections import deque

class Solution(object):
    def sequenceReconstruction(self, org, seqs):
        """
        :type org: List[int]
        :type seqs: List[List[int]]
        :rtype: bool
        """
        
        if len(org) < 1:
            return False

        # init and build graph

        order = []
        size = len(org) + 1
        inDegree = {i: 0 for i in range(size)}
        graph = {i: [] for i in range(size)}

        for seq in seqs:
            for i in range(0, len(seq) - 1):
                parent = seq[i - 1]
                child = seq[i]
                
                inDegree[child] += 1
                graph[parent].append(child)

        # seed
        sources = deque()

        for i in range(1, len(inDegree) - 1):
            print ("here: ", i)
            if inDegree[i] == 0:
                sources.append(i)
        
        # traverse
        while sources:
            if len(sources) >= 2:
                return False
            source = sources.popleft()
            order.append(source)
            
            for nextNum in graph[source]:
                inDegree[nextNum] -= 1

                if inDegree[nextNum] == 0:
                    sources.append(nextNum)

        return order == org


    [1,2] [1,3] [1,2,3]