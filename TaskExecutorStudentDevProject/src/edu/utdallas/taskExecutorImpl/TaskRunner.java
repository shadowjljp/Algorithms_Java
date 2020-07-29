package edu.utdallas.taskExecutorImpl;

import edu.utdallas.blockingFIFO.BlockingFIFO;
import edu.utdallas.taskExecutor.Task;

public class TaskRunner implements Runnable {

	private BlockingFIFO queue;
	
	public TaskRunner(BlockingFIFO fifo) {
		queue = fifo;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				// take() blocks if queue is empty
				Task newTask = queue.take();
				newTask.execute();
			} catch (Throwable th) {
				th.printStackTrace();
				// Log (e.g. print exception¡¦s message to console)
				// and drop any exceptions thrown by the task¡¦s
				// execution.
			}
		}

	}
}
