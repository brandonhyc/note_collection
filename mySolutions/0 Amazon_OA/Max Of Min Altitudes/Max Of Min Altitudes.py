def getMaxOfMinAltitudes(matrix):
    if len(matrix) == 0 or len(matrix[0]) == 0:
        return 0
    matrix[0][0] = sys.maxsize
    matrix[len(matrix) - 1][len(matrix[0]) - 1] = sys.maxsize
    
    minPath = [[sys.maxsize for i in range(len(matrix[0]))] for j in range(len(matrix))]

    for y in range(1, len(matrix)):
        minPath[y][0] = min(matrix[y][0], minPath[y - 1][0])
    
    for x in range(1, len(matrix[0])):
        minPath[0][x] = min(matrix[0][x], minPath[0][x - 1])
    
    for y in range(1, len(matrix)):
        for x in range(1, len(matrix[0])):
            fromUp = min(minPath[y - 1][x], matrix[y][x])
            fromRight = min(minPath[y][x - 1], matrix[y][x])
            minPath[y][x] = max(fromUp, fromRight)

    return max(minPath[len(matrix) - 2][len(matrix[0]) - 1], minPath[len(matrix) - 1][len(matrix[0]) - 2])
    
def main():
    matrix1 = [[1, 2, 3], [4, 5, 1]]
    matrix2 = [[5, 1], [4, 5]]
    print(getMaxOfMinAltitudes(matrix1))
    print(getMaxOfMinAltitudes(matrix2))
    
    
main();