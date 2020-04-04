import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            answer[i] = getNumber(array, commands[i]);
        }
        
        return answer;
    }
    
    private int getNumber(int[] array, int[] command) {
        int[] newArray = new int[command[1] - command[0] + 1];
        int index = 0;
        
        for(int i = command[0] - 1; i < command[1]; i++) {
            newArray[index] = array[i];
            index++;
        }
        Arrays.sort(newArray);
        return newArray[command[2] - 1];
    } 
}
