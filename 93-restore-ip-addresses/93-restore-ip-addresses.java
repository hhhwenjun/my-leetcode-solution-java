class Solution {
    List<String> res;
    String s;
    
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<String>();
        this.s = s;
        // not valid address
        if (s.length() < 4 || s.length() > 12) return res;
        backtrack(0, new StringBuilder(), 4);
        return res;
    }
    
    // use backtracking to traverse all possible ip address
    public void backtrack(int start, StringBuilder ip, int step){
        // base case: reach the end of string
        if (start == s.length() && step == 0){
            res.add(ip.toString().substring(0, ip.length() - 1));
            return;
        }
        for (int i = start; i <= start + 2 && i < s.length(); i++){
            String num = s.substring(start, i + 1);
            if (!isvalid(num)) continue;
            
            // add a dot
            ip.append(num);
            ip.append(".");
            backtrack(i + 1, ip, step - 1);
            ip.setLength(ip.length() - (i + 1 - start + 1));
            
        }
        
    }
    
    private boolean isvalid(String num){
        if (num.length() > 1 && num.startsWith("0") || Integer.parseInt(num) > 255){
            return false;
        }
        return true;
    }
}