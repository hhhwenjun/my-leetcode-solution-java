class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // use a hashmap to store the win/lose of each player
        // int[]: [0] win record, [1] lose record, [2] gamer num, length of 3
        Map<Integer, int[]> playerInfo = new HashMap<>();
        
        // store the records
        for (int[] match : matches){
            if (!playerInfo.containsKey(match[0])){
                playerInfo.put(match[0], new int[3]);
            }
            if (!playerInfo.containsKey(match[1])){
                playerInfo.put(match[1], new int[3]);
            }
            // put user information to each map entry
            playerInfo.get(match[0])[0]++;
            playerInfo.get(match[1])[1]++;
            
            playerInfo.get(match[0])[2]++;
            playerInfo.get(match[1])[2]++;
        }
        
        // use two lists to store the required players
        List<Integer> winners = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();
        
        for (Map.Entry<Integer,int[]> entry : playerInfo.entrySet()){
            int[] currInfo = entry.getValue();
            if (currInfo[0] == currInfo[2]){
                // not lost any matches
                winners.add(entry.getKey());
            }
            if (currInfo[1] == 1){
                loseOne.add(entry.getKey());
            }
        }
        Collections.sort(winners);
        Collections.sort(loseOne);
        List<List<Integer>> res = new ArrayList<>();
        res.add(winners); 
        res.add(loseOne);
        return res;
    }
}