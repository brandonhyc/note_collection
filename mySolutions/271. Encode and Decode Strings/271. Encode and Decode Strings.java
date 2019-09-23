public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            int size = str.length();
            
            sb.append(size).append("/").append(str);
            
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        int start = 0;
        List<String> strs = new ArrayList<>();
        while (start < s.length()) {
            int slash = s.indexOf("/", start);
            int size = Integer.valueOf(s.substring(start, slash));
            
            int end = slash + 1 + size; 
            strs.add(s.substring(slash + 1, end));
            start = end;
        }
        
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));