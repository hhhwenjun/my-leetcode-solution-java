class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        // use the triangle list itself as the memo
        for (int i = 1; i < length; i++){
            int listSize = triangle.get(i).size();
            for (int j = 0; j < listSize; j++){
                if (j - 1 < 0){
                    triangle.get(i).set(j, Integer.valueOf(triangle.get(i).get(0) + triangle.get(i - 1).get(0)));
                }
                else if (j == listSize - 1){
                    triangle.get(i).set(j, Integer.valueOf(triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1)));
                }
                else {
                    triangle.get(i).set(j, Integer.valueOf(Math.min(triangle.get(i).get(j) + triangle.get(i - 1).get(j), 
                                                         triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1))));
                }
            }
        }
        int res = Collections.min(triangle.get(length - 1));
        return res;
    }
}