class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        if n == 0 or len(connections) == 0:
            return list()

        graph = self.buildGraph(connections)
        connections = self.standardize(connections)
        # print(list(connections))
        rank = [None for i in range(n)]

        self.dfs(graph, rank, connections, 0, 0)
        
        return connections

    def dfs(self, graph, rank, connections, fm, curDepth):
        # print(rank, connections, n, fm, curDepth)
        
        if rank[fm] != None and rank[fm] >= 0: # visited
            return rank[fm]

        # test this please
        minDepth = curDepth
        rank[fm] = curDepth

        for to in graph[fm]:

            if (rank[to] != None and rank[to] == curDepth - 1):
                continue
            
            backDepth = self.dfs(graph, rank, connections, to, curDepth + 1)
            if curDepth >= backDepth:
                # catch a loop
                connections.discard(tuple(sorted([fm, to])))
            minDepth = min(backDepth, minDepth)
            
        return minDepth        
        
        
    def standardize(self, connections):
        return set(map(tuple, map(sorted, connections)))
    
        
    def buildGraph(self, connections):
        graph = {}
        
        for conn in connections:
            fm = conn[0]
            to = conn[1]
            if fm not in graph:
                graph[fm] = set()
            if to not in graph:
                graph[to] = set()
        
            graph[fm].add(to)
            graph[to].add(fm)
        
        return graph