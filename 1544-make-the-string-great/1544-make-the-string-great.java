class Solution {
    public String makeGood(String s) {
        List<Character> list = new LinkedList<>();
        char[] array = s.toCharArray();
        for (char ch : array){
            list.add(ch);
        }
        
        // find the bad characters and remove them in list
        while(list.size() > 1){
            boolean find = false;
            // find the bad characters
            for (int i = 0; i < list.size() - 1; i++){
                if (Math.abs(list.get(i) - list.get(i + 1)) == 32){
                    find = true;
                    list.remove(i);
                    list.remove(i);
                    break;
                }
            }
            if (!find) break;
        }
        StringBuilder newString = new StringBuilder();
        for (Character ch : list){
            newString.append(ch);
        }
        return newString.toString();
    }
}