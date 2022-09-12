public class Codec {
    // use non-ascii delimiter: string can use either code in ascii, 256 in total

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) return Character.toString((char)258);
        
        String delimiter = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str);
            sb.append(delimiter);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(Character.toString((char)258))) return new ArrayList<String>();
        
        String delimiter = Character.toString((char)257);
        String[] resStrings = s.split(delimiter, -1);
        return Arrays.asList(resStrings);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));