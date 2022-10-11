class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // calculate the distance and then put it into the heap
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int squareA = a[0]*a[0] + a[1]*a[1];
                int squareB = b[0]*b[0] + b[1]*b[1];
                return squareB - squareA;
            }
        });
        for (int[] point : points){
            queue.add(point);
            if (queue.size() > k){
                queue.poll();
            }
        }
        int[][] res = new int[queue.size()][2];
        int i = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            res[i][0] = curr[0];
            res[i][1] = curr[1];
            i++;
        }
        return res;
    }
}