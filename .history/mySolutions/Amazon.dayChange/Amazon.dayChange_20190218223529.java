/*package whatever //do not write package name here */

import java.io.*;

// Java program to count active and 
// inactive cells after k days 

class GFG { 
	
// cells[] - store current status 
// of cells n - Number of cells 
// temp[] - to perform intermediate operations 
// k - number of days 
// active - count of active cells after k days 
// inactive - count of active cells after k days 
static void activeAndInactive(boolean cells[], 
								int n, int k) 
{ 
        if (cells == null || cells.length == 0) {
            return null;
        }

        int daysCell = Arrays.copyArray(cells, 0, cells.length);
        int nextDayCells = new boolean[8];
        for (int day = 0; day < days; day++) {
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) {
                    nextDayCells[i] = (false != daysCell[i + 1]);
                    continue;
                }
                else if (i == cells.length - 1) {
                    nextDayCells[i] = (false != daysCell[i - 1]);
                    continue;
                }
                else {
                    // 2- 7
                    nextDayCells[i] = (daysCell[i - 1] != daysCell[i + 1]);
                    continue;
                }
            }
            daysCell = Arrays.copyArray(nextDayCells, 0, cells.length);
        }
        System.out.print(Arrays.toString(daysCell));
        return daysCell;


// 	System.out.print("Active Cells = " + active + ", " + 
// 					"Inactive Cells = " + inactive); 
} 

// Driver code 
public static void main(String[] args) 
{ 
	boolean cells[] = {false, true, false, true, 
					false, true, false, true}; 
	int k = 3; 
	int n = cells.length; 
	activeAndInactive(cells, n, k); 
} 
} 

// This code is contributed by Anant Agarwal. 
