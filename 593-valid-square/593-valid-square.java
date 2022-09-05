class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> squarelength = new HashSet<>();
        // calculate all distances between 4 points
        int[][] points = new int[][]{p1, p2, p3, p4};
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                int distance = (int)Math.pow(points[i][0] - points[j][0], 2) 
                    + (int)Math.pow(points[i][1] - points[j][1], 2);
                if (distance == 0) return false; // cannot be at the same location
                squarelength.add(distance);
            }
        }
        return squarelength.size() == 2;
    }
}