class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char ch : ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch) == 0){
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }
}