class MovingAverage {
    
    private int size;
    private List<Integer> list;

    public MovingAverage(int size) {
        this.size = size;
        list = new ArrayList<>();
    }
    
    public double next(int val) {
        list.add(val);
        if (list.size() > size){
            list.remove(0);
        }
        int denominator = list.size();
        int sum = 0;
        for (int i = 0; i < denominator; i++){
            int curr = list.get(i);
            sum += curr;
        }
        return (double)sum / (double)denominator;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */