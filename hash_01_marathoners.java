import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap <String, Integer> winners = new HashMap<String, Integer>();
        for(String name : completion) {
            if(winners.containsKey(name)) {
                winners.replace(name,winners.get(name) + 1);
            }
            else 
                winners.put(name, 1);
        }
        
        for(String name : participant) {
            if(!winners.containsKey(name)) {
                answer = name;
                break;
            }
            else {
                int count = winners.get(name);
                if(count > 1) {
                    winners.replace(name, --count);
                }
                else 
                    winners.remove(name);
            } 
        }
        
        return answer;
        
    
    }
}
