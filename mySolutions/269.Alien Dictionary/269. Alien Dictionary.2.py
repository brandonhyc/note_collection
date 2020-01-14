class Solution:
    def alienOrder(self, words: List[str]) -> str:
        if len(words) == 0:
            return ""

        # build graph
        graph = {}
        degree = {}
        res = ""

        for word in words:
            for ch in word:
                graph[ch] = []
                degree[ch] = 0
        
        for w in range(len(words) - 1):
            word1 = words[w]
            word2 = words[w + 1]
            
            minLen = min(len(word1), len(word2))
            
            for i in range(minLen):
                # find diff
                ch1 = word1[i]
                ch2 = word2[i]

                if ch1 == ch2:
                    continue
                    
                graph[ch1].append(ch2)
                degree[ch2] += 1
                break
        
        # print(graph)
        # print(degree)
        # traverse
        queue = collections.deque()
        for key in graph:
            if degree[key] == 0:
                queue.append(key)
                
        while len(queue) != 0:
            ch = queue.popleft()
            res += ch
            
            for ch2 in graph[ch]:
                degree[ch2] -= 1
                
                if degree[ch2] == 0:
                    queue.append(ch2)
                    
        for key in degree:
            if degree[key] != 0:
                print(key)
                return ""
        
        return res
        