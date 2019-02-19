public class DaysChange {
    public int[] Solution(int[] cells, int days) {
        if (cells == null || cells.length == 0) {
            return null;
        }

        int nextDaycells = Arrays.copyArray(cells, 0, cells.length);
        int afterNextDaycells = new int[8];
        for (int day = 0; day < days; day++) {
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) {
                    if (0 == cells[i + 1])
                    nextDaycells[i] = 
                    continue;
                }
                if (i == cells.length - 1) {


                    continue;
                }

                
            }
        }

    }
}