public class DaysChange {
    public int[] Solution(int[] cells, int days) {
        if (cells == null || cells.length == 0) {
            return null;
        }

        int daysCell = Arrays.copyArray(cells, 0, cells.length);
        int nextDayCells = new int[8];
        for (int day = 0; day < days; day++) {
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) {
                    nextDayCells[i] = (0 == daysCell[i + 1]) ? 0 : 1;
                    continue;
                }
                else if (i == cells.length - 1) {
                    nextDayCells[i] = (0 == daysCell[i - 1]) ? 0 : 1;
                    continue;
                }
                else {
                    // 2- 7
                    nextDayCells[i] = (daysCell[i - 1] == daysCell[i + 1]) ? 0 : 1;
                    continue;
                }
            }
            daysCell = Arrays.copyArray(nextDayCells, 0, cells.length);
        }
        return daysCell;

    }
}