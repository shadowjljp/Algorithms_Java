package edu.utdallas.blockingFIFO;

import edu.utdallas.taskExecutor.Task;

public class BlockingFIFO {
	private int N;
	private Task[] buffer;
	private int nextin, nextout;
	private int count;
	private Object notfull, notempty; // Monitors used for synchronization
	private boolean isLocked;

	public BlockingFIFO(int size) {
		N = size;
		notfull = new Object();
		notempty = new Object();
		isLocked = false;
		count = 0;
		nextout = 0;
		nextin = nextout;
		buffer = new Task[N];
	}
	
	public void put(Task task) throws InterruptedException {
		lock();
		while(count == N) {
			unlock();
			synchronized(notfull) {
				notfull.wait();
			}
			lock();
		}
		buffer[nextin] = task;
		nextin = (nextin + 1) % N;
		count++;
		synchronized(notempty) {
			notempty.notify(); // Signal waiting take threads
		}
		unlock();
	}

	public Task take() throws InterruptedException {
		lock();
		while(count == 0) {
			unlock();
			synchronized(notempty) {
				notempty.wait(); // Buffer is empty, wait for put
			}
			lock();
		}
		Task result = buffer[nextout];
		nextout = (nextout + 1) % N;
		count--;
		synchronized(notfull) {
			notfull.notify(); // Signal waiting put threads
		}
		unlock();
		return result;
	}
	
	private void lock() throws InterruptedException {
		synchronized(this) {
			while(isLocked) {
				this.wait();
			}
			isLocked = true;
		}
	}
	
	private void unlock() {
		synchronized(this) {
			isLocked = false;
			this.notify();
		}
	}
}
