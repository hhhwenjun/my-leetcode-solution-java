class Pair {
    String display;
    int step;
    
    public Pair(String display, int step){
        this.display = display;
        this.step = step;
    }
}

class Solution {
    Set<String> deadendsSet;
    String target;
    
    public int openLock(String[] deadends, String target) {
        deadendsSet = new HashSet<>();
        for (String deadend : deadends){
            deadendsSet.add(deadend);
        }
        this.target = target;
        
        // 1. starts from target, find its neighbors, bfs
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(target, 0));
        int output = -1;
        String newtarget = "0000";
        if (deadendsSet.contains(newtarget)) return output;
        // 2. each time we have neighbors 2 + 2 + 2 + 2
        while(!queue.isEmpty()){
            Pair currPair = queue.poll();
            String curr = currPair.display;
            if (deadendsSet.contains(curr)){
                continue;
            }
            deadendsSet.add(curr);
            int val = currPair.step;
            if (curr.equals(newtarget)){
                output = val;
                break;
            }
            // each time we change 1 digit value -> 2 possible change method +/-1
            for (int i = 0; i < curr.length(); i++){
                char digit = curr.charAt(i);
                int digitVal = digit - '0';
                int digitPossible1 = (digitVal + 1 + 10) % 10;
                int digitPossible2 = (digitVal - 1 + 10) % 10;
                String next1 = curr.substring(0, i) + digitPossible1 + curr.substring(i + 1);
                String next2 = curr.substring(0, i) + digitPossible2 + curr.substring(i + 1);
                
                if (!deadendsSet.contains(next1)){
                    queue.add(new Pair(next1, val + 1));
                }
                if (!deadendsSet.contains(next2)){
                    queue.add(new Pair(next2, val + 1));
                }
            }
        }
        // 3. until we find "0000", reach it and return output
        return output;
    }
}