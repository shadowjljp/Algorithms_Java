package edu.utdallas.taskExecutorImpl;

import edu.utdallas.blockingFIFO.BlockingFIFO;
import edu.utdallas.taskExecutor.Task;
import edu.utdallas.taskExecutor.TaskExecutor;

public class TaskExecutorImpl implements TaskExecutor
{
	BlockingFIFO FIFO;
	public TaskExecutorImpl(int numThreads) {
		 FIFO = new BlockingFIFO(100);
		 
		 for(int i = 0; i < numThreads; i++) {
			 Thread t = new Thread(new TaskRunner(FIFO));
			 t.start();
		 }
	}

	@Override
	public void addTask(Task task)
	{
		try {
			FIFO.put(task);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
