//Related Topic: Heap,greedy,etc.
class Solution{
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Integer> capitalHeap = new PriorityQueue<>((i, j) -> capital[i] - capital[j]);
        Queue<Integer> profitsHeap = new PriorityQueue<>((i, j) -> profits[j] - profits[i]);
        
        for(int i = 0; i < capital.length; i++) capitalHeap.offer(i);
        
        int availableCapital = w;
        for(int i = 0; i < k; i++) {
            while(!capitalHeap.isEmpty() && availableCapital >= capital[capitalHeap.peek()]) profitsHeap.offer(capitalHeap.poll());
            if(!profitsHeap.isEmpty()) availableCapital += profits[profitsHeap.poll()];
        }
        return availableCapital;
    }
}