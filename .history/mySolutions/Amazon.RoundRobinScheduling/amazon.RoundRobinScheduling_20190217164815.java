class Process {
    int arrTime;
    int exeTime;
    Process(int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}

public class RoundRobinScheduling {
    public float Solution(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length) {
            return 0;
        }

        int length = Atime.length;
        Queue<Process> queue = new LinkedList<Process>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                
            }
        }

    }
}