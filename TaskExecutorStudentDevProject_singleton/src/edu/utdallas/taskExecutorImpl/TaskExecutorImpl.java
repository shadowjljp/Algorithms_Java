package edu.utdallas.taskExecutorImpl;

import edu.utdallas.blockingFIFO.BlockingFIFO;
import edu.utdallas.taskExecutor.Task;
import edu.utdallas.taskExecutor.TaskExecutor;

public class TaskExecutorImpl implements TaskExecutor
{	
	BlockingFIFO FIFO;
	public TaskExecutorImpl(int i) { //thread number
		//get the FIFO,initialize BlockingFIFO
	 BlockingFIFO.getFIFO(100);
		 //Initialize ThreadPool & TaskRunner
		 for(int j=0;j<i;j++) {
			 Thread t = new Thread(new TaskRunner());
			 t.start();
		 }
	}

	@Override
	public void addTask(Task task)
	{
		BlockingFIFO.put(task);
	}

}
