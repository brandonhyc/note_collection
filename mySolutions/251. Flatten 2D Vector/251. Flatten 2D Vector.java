class Vector2D {

    Stack<Iterator> stack = new Stack<>();
    public Vector2D(int[][] v) {
        stack = new Stack<>();
        
        for (int i = v.length - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < v[i].length; j++) {
                list.add(v[i][j]);
            }
            
            Iterator<Integer> it = list.iterator();
            if (it.hasNext()) {
                stack.push(it);
            }
        }
        
    }
    
    public int next() {
        Iterator<Integer> it = stack.pop();
        int num = it.next();
        if (it.hasNext()) {
            stack.push(it);
        }
        return num;
    }
    
    public boolean hasNext() {
        return stack.size() != 0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */