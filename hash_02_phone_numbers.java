import java.util.TreeSet;
import java.util.Iterator;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        TreeSet<String> numbers = new TreeSet<String>();
        for(String number : phone_book) {
            numbers.add(number);
        }
        
        Iterator<String> it = numbers.iterator();
        String prevNumber = "";
        String curNumber = "";
        if(it.hasNext()) {
            prevNumber = it.next();
        }
        
        while(it.hasNext()) {
            curNumber = it.next();
            if(prevNumber.length() <= curNumber.length()) {
                if(curNumber.startsWith(prevNumber)){
                    answer = false;
                    break;  
                }
                else if(Integer.valueOf(prevNumber) != Integer.valueOf(curNumber.substring(0, prevNumber.length()))) { 
                    prevNumber = curNumber;    
                }
                
            } else {
                prevNumber = curNumber; 
            }
        }
        
        return answer;
    }
}
