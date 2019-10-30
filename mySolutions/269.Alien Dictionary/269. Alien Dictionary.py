from collections import deque

class Solution(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        
        chOrder = []

        # init and build graph
        inDegree = {}
        graph = {}

        for word in words:
            for ch in word:
                inDegree[ch] = 0
                graph[ch] = []
        
        for i in range(1, len(words)):
            w1 = words[i - 1]
            w2 = words[i]

            minLen = min(len(w1), len(w2))
            for j in range(minLen):
                parent = w1[j]
                child = w2[j]
                
                if parent != child:
                    inDegree[child] += 1
                    graph[parent].append(child)
                    break

        # seed
        sources = deque()
        for key in inDegree:
            if inDegree[key] == 0:
                sources.append(key)

        # traverse
        while sources:
            source = sources.popleft()
            chOrder.append(source)

            for ch in graph[source]:
                inDegree[ch] -= 1
                if inDegree[ch] == 0:
                    sources.append(ch)

        for key in inDegree:
            if inDegree[key] != 0: 
                return ""
        
        return "".join(chOrder)


[
"za",
"zb",
"ca",
"cb"]