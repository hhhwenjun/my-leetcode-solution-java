class Solution {
    public String tictactoe(int[][] moves) {
        // 1. create a map to record the moves, each possible way to win
        Map<String, List<Integer>> countMap = new HashMap<>();
        countMap.put("row0", new ArrayList<Integer>());
        countMap.put("row1", new ArrayList<Integer>());
        countMap.put("row2", new ArrayList<Integer>());
        
        countMap.put("col0", new ArrayList<Integer>());
        countMap.put("col1", new ArrayList<Integer>());
        countMap.put("col2", new ArrayList<Integer>());
        
        countMap.put("diag0", new ArrayList<Integer>());
        countMap.put("diag1", new ArrayList<Integer>());
        
        //.  1.1 columns, rows, diagonals, Integer: value, List: value on corresponding cells
        // 2. Each time put value to the map, to the list
        int value = 0;
        int winner = 0;
        int space = 0;
        for (int i = 0; i < moves.length; i++){
            if (i % 2 == 0) {
                value = 1;
            } else {
                value = 2;
            }
            
            int currRow = moves[i][0];
            int currCol = moves[i][1];
            
            String rowKey = "row" + currRow;
            String colKey = "col" + currCol;
            String diagKey1 = "";
            String diagKey2 = "";
            if (currRow == currCol){
                diagKey1 = "diag0";
            }
            if (currRow + currCol == 2){
                diagKey2 = "diag1";
            }
            
            countMap.get(rowKey).add(value);
            if (countMap.get(rowKey).size() == 3){
                int sum = 0;
                space++;
                for (int digit : countMap.get(rowKey)){
                    sum += digit;
                }
                if (sum == 3 || sum == 6){
                    winner = value;
                    break;
                }
            }
            countMap.get(colKey).add(value);
            if (countMap.get(colKey).size() == 3){
                space++;
                int sum = 0;
                for (int digit : countMap.get(colKey)){
                    sum += digit;
                }
                if (sum == 3 || sum == 6){
                    winner = value;
                    break;
                }
            }
            if (countMap.containsKey(diagKey1)){
                countMap.get(diagKey1).add(value);
                if (countMap.get(diagKey1).size() == 3){
                    space++;
                    int sum = 0;
                    for (int digit : countMap.get(diagKey1)){
                        sum += digit;
                    }
                    if (sum == 3 || sum == 6){
                        winner = value;
                        break;
                    }
                }
            }
            if (countMap.containsKey(diagKey2)){
                countMap.get(diagKey2).add(value);
                if (countMap.get(diagKey2).size() == 3){
                    space++;
                    int sum = 0;
                    for (int digit : countMap.get(diagKey2)){
                        sum += digit;
                    }
                    if (sum == 3 || sum == 6){
                        winner = value;
                        break;
                    }
                }
            }
        }
        // 3. check list reach size 3, and same value in the same list
        if (winner == 0 && space < 8) return "Pending";
        if (winner == 0) return "Draw";
        if (winner == 1) return "A";
        else  return "B";
    }
}