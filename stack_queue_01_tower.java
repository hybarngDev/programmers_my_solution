import java.util.Stack;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int highest = heights[0];
        answer[0] = 0;
        
        for(int i = 1; i < heights.length; i++) {
            int nTh = 0;
            for(int j = i - 1; j >= 0 ; j-- ) {
                if(heights[i] < heights[j]) {
                    nTh = j + 1;
                    break;
                }                
            }
        
            answer[i] = nTh;
        }
       
        return answer;
    }
}
