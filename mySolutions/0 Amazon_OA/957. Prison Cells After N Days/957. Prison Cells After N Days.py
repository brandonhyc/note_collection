class Solution:
    OCCUPIED = 1;
    VACANT = 0;
    def prisonAfterNDays(self, cells: List[int], N: int) -> List[int]:
        day = 0
        hasCycle = False
        states = {}
        state = ''.join(str(i) for i in cells)
        states[state] = day

        for i in range(N):
            day += 1
            cells = self.pastDay(cells)
            state = ''.join(str(i) for i in cells)
            if state in states:
                hasCycle = True
                break
            states[state] = day
        
        if hasCycle:
            startDay = states.get(state)
            cycle = day - startDay
            # if the cycle not start from day 0, then we need to cut that part before in loop
            N = (N - startDay + 1) % cycle
            N = cycle if N == 0 else N  
            # N - 1 because cells is now on the first day in the cycle
            for i in range(N - 1):
                cells = self.pastDay(cells)
        return cells

    def pastDay(self, cells):
        nCells = [0 for i in range(len(cells))]
        
        for i in range(1, len(cells) - 1):
            nCells[i] = self.OCCUPIED if cells[i - 1] == cells[i + 1] else self.VACANT;            
        
        return nCells;