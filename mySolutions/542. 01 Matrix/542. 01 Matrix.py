from collections import deque

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if len(matrix) == 0:
            return matrix

        DIRS = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        queue = deque()

        # set all 1 to max value and push all 0 in queue
        for y in range(len(matrix)):
            for x in range(len(matrix[0])):
                if matrix[y][x] == 1:
                    matrix[y][x] = sys.maxsize
                if matrix[y][x] == 0:
                    queue.append([y, x])

        while len(queue) != 0:
            pos = queue.popleft()
            curDistance = matrix[pos[0]][pos[1]]
            # print("at ", pos, "distance ", curDistance)

            for j in range(len(DIRS)):
                nx = pos[1] + DIRS[j][1]
                ny = pos[0] + DIRS[j][0]

                if nx < 0 or nx >= len(matrix[0]) or ny < 0 or ny >= len(matrix):
                    continue

                if curDistance + 1 < matrix[ny][nx]:
                    matrix[ny][nx] = curDistance + 1
                    queue.append([ny, nx])
        
        return matrix