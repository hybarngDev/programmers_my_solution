
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());


        for(int i = 0; i < scoville.length; i++) {
            minHeap.offer(scoville[i]);
        }
        
            //print(minHeap);
        int cur1;
        int cur2;
        while(minHeap.size() > 0) {
            cur1 = minHeap.poll();
            // System.out.println("poll = " + cur1);
            if(cur1 >= K) {
                break;
            } else if(minHeap.size() == 0) {
                answer = -1;
                break;
            }
            cur2 = minHeap.poll();
            // System.out.println("poll = " + cur2);
            minHeap.offer(cur1 + 2 * cur2);
            // System.out.println("offer = " + (cur1 + 2 * cur2));
            answer++; 
            //print(minHeap);
        }
        
        
    
        
    
        
        return answer;
    }
    
    public static void print(PriorityQueue<Integer> queue) {
        System.out.print("data: ");
        queue.forEach((value)->{
            System.out.print(value+ " ");
        });
        System.out.println(String.format(" size: %d", queue.size())); 
    }

}
