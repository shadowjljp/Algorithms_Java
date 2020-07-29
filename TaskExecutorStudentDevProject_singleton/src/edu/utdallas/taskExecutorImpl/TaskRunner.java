package edu.utdallas.taskExecutorImpl;

import edu.utdallas.blockingFIFO.BlockingFIFO;
import edu.utdallas.taskExecutor.Task;

public class TaskRunner implements Runnable {

	@Override
	public void run() {
		while (true) {
			// take() blocks if queue is empty

			Task newTask = BlockingFIFO.take();
			try {
				newTask.execute();
			} catch (Throwable th) {
				System.out.println("Issues with TaskRunner run()" + th.getMessage());
				// Log (e.g. print exception¡¦s message to console)
				// and drop any exceptions thrown by the task¡¦s
				// execution.
			}
		}

	}

}
