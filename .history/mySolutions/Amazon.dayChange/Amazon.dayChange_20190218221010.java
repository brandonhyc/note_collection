public class DaysChange {
    public int[] Solution(int[] cells, int days) {
        if (cells == null || cells.length == 0) {
            return null;
        }

        int Daycells = Arrays.copyArray(cells, 0, cells.length);
        int nextDayCells = new int[8];
        for (int day = 0; day < days; day++) {
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) {
                    nextDayCells[i] = (0 == Daycells[i + 1]) ? 0 : 1;
                    continue;
                }
                else if (i == cells.length - 1) {
                    nextDayCells[i] = (0 == Daycells[i - 1]) ? 0 : 1;
                    continue;
                }
                else {
                    // 2- 7
                    nextDayCells[i] = (Daycells[i - 1] == Daycells[i + 1]) ? 0 : 1;
                    continue;
                }
            }
            Daycells = Arrays.copyArray(nextDayCells, 0, cells.length);

        }

    }
}