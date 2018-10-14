public class MovingAverage {
    /*
    * @param size: An integer
    */
    int capacity = 0;
    int ptr = 0;
    List<Integer> list = new ArrayList<>();
    
    public MovingAverage(int size) {
        // do intialization if necessary
        if (size == 0) {
            return;
        }

        this.capacity = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        double result = 0;

        if (list.size() == this.capacity) {
            list.remove(0);
        }

        list.add(val);
        
        for (int value: list) {
            result += value;
        }
        result /= list.size();

        return result ;
    }
}