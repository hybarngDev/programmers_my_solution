import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList <Integer> readyTrucks = new LinkedList<Integer>();
        LinkedList <Integer> underwayTrucks = new LinkedList<Integer>();
        for(int i = 0; i < truck_weights.length; i++) {
            readyTrucks.add(truck_weights[i]);
        }
        for(int i = 0; i < bridge_length; i++) {
            underwayTrucks.add(0);
        }
            
        int totalWeight = 0;
        while(readyTrucks.size() > 0|| totalWeight > 0) { 
            answer++;
            totalWeight -= underwayTrucks.poll();
            Integer nextTruck = readyTrucks.peek();
            if(nextTruck != null 
               && totalWeight + nextTruck <= weight) {
                underwayTrucks.add(readyTrucks.poll());
                totalWeight += nextTruck;
            }
            else {
                underwayTrucks.add(0);
            }
        }
        
        return answer;
    }
    
}
