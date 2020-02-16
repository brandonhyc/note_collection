class ProductOfNumbers {
    
    List<Integer> res = new ArrayList<>();

    public ProductOfNumbers() {
        res = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            res = new ArrayList<>();
        }
        else if (res.size() == 0) {
            res.add(num);
        } 
        else res.add(res.get(res.size() - 1) * num);
    }
    
    public int getProduct(int k) {
        if (k > res.size()) {
            return 0;
        }
        else if (k == res.size()) {
            return res.get(k - 1);
        }
        int all = res.get(res.size() - 1);
        int prefix = res.get(res.size() - 1 - k);
        return all / prefix;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */