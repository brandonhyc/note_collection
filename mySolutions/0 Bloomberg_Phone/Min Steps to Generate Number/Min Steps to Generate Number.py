from collections import deque

def minSteps_bfs(num):

    steps = -1
    queue = deque()
    queue.append(1)

    while len(queue) != 0:
        steps += 1
        size = len(queue)

        for i in range(size):
            cur = queue.popleft()
            if cur == num:
                return steps

            cur_m_2 = int(cur * 2)
            cur_d_3 = int(cur / 3)
            
            queue.append(cur_m_2)
            queue.append(cur_d_3) 

def main():
  print(minSteps(10)) #6
  print(minSteps(3))  #7
  print(minSteps(20))   #20

main()