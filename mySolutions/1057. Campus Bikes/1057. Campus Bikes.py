import sys

class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> List[int]:
        
        MAX = 2000
        res = [-1 for i in range(len(workers))]
        dists = [[] for i in range(MAX)] # distance: [workerIndex, bikeIndex]
        usedBike = set()
        
        for w in range(len(workers)):
            for b in range(len(bikes)):
                distance = self.getManhDist(workers[w], bikes[b])
                dists[distance].append([w, b])
        
        for distance in range(len(dists)):
            for worker, bike in dists[distance]:
                if res[worker] == -1 and bike not in usedBike:
                    usedBike.add(bike)
                    res[worker] = bike
        return res
    
    def getManhDist(self, p1, p2):
        return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])