public class DaysChange {
    public int[] Solution(int[] cells, int days) {
        if (cells == null || cells.length == 0) {
            return null;
        }

        for (int i = 0; i < cells.length; i++) {
            if (i == 0) {
                if (0 != cells[i] && cells[i] != cells[i + 1])
                cells[i]
                continue;
            }
            if (i == cells.length - 1) {


                continue;
            }

            
        }

    }
}