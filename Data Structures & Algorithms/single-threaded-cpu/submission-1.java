class Solution {
    public class Task
    {
        int enqueueTimei ;
        int processingTimei ;
        int idx ;
        Task(int enqueueTimei,int processingTimei,int idx)
        {
            this.enqueueTimei=enqueueTimei;
            this.processingTimei=processingTimei;
            this.idx=idx;
        }
    }
    //pq1.based on  enqueueTimei put all on pq2
    //pq2 based on processingTime and idx
    public int[] getOrder(int[][] tasks) {
        int [] result = new int[tasks.length];
        PriorityQueue<Task> pq_waiting = new PriorityQueue<>((a,b)->{
            return a.enqueueTimei-b.enqueueTimei ;
        });
        PriorityQueue<Task> pq_running = new PriorityQueue<>((a,b)->{
            if(a.processingTimei!=b.processingTimei)
            return a.processingTimei-b.processingTimei ;
            else 
            return a.idx-b.idx ;
            }) ;
        int i=0;
        for(int [] task :tasks)
        {
            pq_waiting.add(new Task(task[0],task[1],i));
            i++;
        }
        int curr_time =0 ;
        i=0;
        while(i!=tasks.length)
        {
            while(!pq_waiting.isEmpty()&&curr_time>pq_waiting.peek().enqueueTimei)
            {
                pq_running.offer(pq_waiting.poll());
            }
            if(!pq_running.isEmpty())
            {
                Task task = pq_running.poll();
                result[i] = task.idx ;
                // System.out.println(result[i]);
                curr_time = curr_time + task.processingTimei ;
                System.out.println(curr_time+ " "+i);
                i++;
            }
            else curr_time++;

        }

        return result ;

    }
}