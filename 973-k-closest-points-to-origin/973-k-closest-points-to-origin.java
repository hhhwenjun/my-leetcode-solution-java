class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // k closest point: priority queue
        // k size priority queue, store the point and its distance
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int squareA = a[0] * a[0] + a[1] * a[1];
                int squareB = b[0] * b[0] + b[1] * b[1];
                return squareB - squareA;
            }
        }); 
        
        for (int[] point : points){
            heap.add(point);
            if (heap.size() > k){
                heap.poll();
            }
        }
        
        int[][] res = new int[k][2];
        int i = 0;
        while(heap.size() > 0){
            int[] curr = heap.poll();
            res[i][0] = curr[0];
            res[i][1] = curr[1];
            i++;
        }
        return res;
    }
}