public class ShortestJobFirst {
    public float Solution(int[] req, int[] dur) {
        if (req == null || dur == null || req.length != dur.length) {
            return 0;
        }
        int index = 0, length = req.length;
        int waitTime = 0, curTime = 0;

        PriorityQueue<Process> pq = new PriorityQueue<Process>(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                if (p1.exeTime == p2.exeTime) {
                    return p1.arrTime - p2.arrTime;
                }
                return p1.exeTime - p2.exeTime;
            }
        });
        while (!pq.isEmpty() || index < length) {
            if (pq.isEmpty()) {
                pq.offer(new Process(req[index], dur[index]));
                curTime = req[index];
                index++;
            }
            else {
                process cur = pq.poll();
                waitTime += curTime - cur.arrTime;
                curTime += cur.exeTime;
                while (index < length && curTime >= req[index]) {
                    pq.offer(new Process(req[index], dur[index]));
                    index++;
                }
            }
        }
        


    }
}