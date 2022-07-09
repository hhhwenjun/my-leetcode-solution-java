class Solution {
    class PQcomparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(b[0], a[0]);
        }
    }

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diffs = new int[n];
        for(int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
        }
        
        int op = k1 + k2;

        Map<Integer, Integer> freqs = new HashMap<>();
        for(int num : diffs) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new PQcomparator());
        for(int key : freqs.keySet()) {
            pq.offer(new int[]{key, freqs.get(key)});
        }
        
        while(!pq.isEmpty()) {
            if (op == 0) {
                break;
            }
            
            int[] top = pq.poll();
            
            int key = top[0];
            int count = top[1];
            
            if (key == 0) {
                break;
            }

            int nextkey = 0;
            if (!pq.isEmpty()) {
                nextkey = pq.peek()[0];
            } else {
                pq.offer(new int[]{0, 0});
                nextkey = 0;
            }
            
            int diff = key - nextkey;
            if (count * diff <= op) {
                pq.peek()[1] += count;
                op -= count * diff;
            } else {
                int equalDistribute = op / count;
                int remaining = op - equalDistribute * count;
                
                int lowerKey = key - equalDistribute;
                if (lowerKey == 0) {
                    break;
                }
                
                pq.offer(new int[]{lowerKey, count - remaining});
                pq.offer(new int[]{lowerKey - 1, remaining});
                
                op = 0;
            }
        }
        
        long ans = 0;
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int key = top[0];
            int count = top[1];
            ans += 1l * key * key * count;
        }
        
        return ans;
    }
}