public class ZigzagIterator {

    Queue<Iterator> queue = new LinkedList<>();
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        Iterator it1 = v1.iterator();
        Iterator it2 = v2.iterator();
        
        if (it1.hasNext()) {
            queue.offer(v1.iterator());
        }
        
        if (it2.hasNext()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        
        Iterator it = queue.poll();

        int num = (Integer) it.next();
        if (it.hasNext()) {
            queue.offer(it);
        }
        return num;
    }

    public boolean hasNext() {
        return queue.size() != 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */