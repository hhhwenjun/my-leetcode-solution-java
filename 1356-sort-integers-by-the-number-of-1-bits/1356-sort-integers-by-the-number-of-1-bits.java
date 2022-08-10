class Solution {
    public int[] sortByBits(int[] arr) {
       Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxedArray, (a,b) -> {
            int A = Integer.bitCount(a);
            int B = Integer.bitCount(b);
            if(A < B) return -1;
            if(A > B) return 1;
            return Integer.compare(a,b);
        });
        
        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }
}