class Solution:
    def sortedSquares(self, arr: List[int]) -> List[int]:
        
        squares = []
        
        left = 0
        right = len(arr) - 1
        
        while left <= right:
            leftSqrt = arr[left] * arr[left]
            rightSqrt = arr[right] * arr[right]
            
            if leftSqrt < rightSqrt:
                squares.append(rightSqrt)
                right -= 1
            else:
                squares.append(leftSqrt)
                left += 1
                
        squares.reverse()
        return squares