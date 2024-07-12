import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        /*
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i < completion.length; i++) {
            if(participant[i].equals(completion[i])) continue;
            else return participant[i];
        }
        
        return participant[participant.length - 1];
        */
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String s : participant) hm.put(s, hm.getOrDefault(s, 0) + 1);
        for(String s : completion) hm.put(s, hm.get(s) - 1);
        
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}