import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
        
        
        String curPart = "";
        for(int i = 0; i < clothes.length; i++) {
            curPart = clothes[i][1];
            if(clothesMap.containsKey(curPart)) 
                clothesMap.replace(curPart, clothesMap.get(curPart) + 1);
            else 
                clothesMap.put(curPart, 2);
        }
        
        Iterator <String> it = clothesMap.keySet().iterator();
        String curKey = "";
        
        while(it.hasNext()) {
            curKey = (String)it.next();
            answer *= clothesMap.get(curKey);
        }
        
        return answer - 1; //none of clothes
    }
}
