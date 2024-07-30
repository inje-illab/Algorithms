import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++) {
            String [] arr = operations[i].split(" ");
            int num = Integer.parseInt(arr[1]);
            
            if(arr[0].equals("I")) {
                maxPq.add(num);
                minPq.add(num);
            }
            else if(arr[0].equals("D")) {
                if(maxPq.isEmpty() || minPq.isEmpty()) continue;
                if(num == 1) {
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
                else if(num == -1) {
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            }
        }
        
        if(maxPq.isEmpty() && minPq.isEmpty()) return new int[] {0, 0};
        
        return new int[] {maxPq.peek(), minPq.peek()};
    }
}