package edu.utdallas.blockingFIFO;

//import java.util.concurrent.LinkedBlockingQueue;

import edu.utdallas.taskExecutor.Task;

public class BlockingFIFO {
//	private static LinkedBlockingQueue<Task> L;
//	static {
//		L = new LinkedBlockingQueue<>(100);
//	}
//	public BlockingFIFO() {}
//	public static void put(Task task) {
//		try {
//			L.put(task);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static Task take() {
//		try {
//			return L.take();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	private static  int N;
	private static Task[] buffer;
	private static int nextin, nextout;
	private static int count;
	private static Object notfull, notempty; // Monitors used for synchronization
	private static boolean isLocked;
	private static BlockingFIFO FIFO;
	static {
		notfull = new Object();
		notempty = new Object();
		isLocked = false;
		count = 0;
		nextout = 0;
		nextin = nextout;
//		buffer = new Task[N];
	}
	
	public static BlockingFIFO getFIFO(int i) {
		if(FIFO ==null) {
			synchronized (BlockingFIFO.class) {
				if(FIFO==null) {
					N=i;
					FIFO = new BlockingFIFO(N);
				}
			}
		}
		return FIFO;
	}
	private BlockingFIFO(int N) {
		buffer = new Task[N];
	}

	public static void put(Task task) {
		lock();
		while(count == N) {
			unlock();
			synchronized(notfull) {
				try {
					notfull.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   // Buffer is full, wait for take
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

	public static Task take() {
		lock();
		while(count == 0) {
			unlock();
			synchronized(notempty) {
				try {
					notempty.wait(); // Buffer is empty, wait for put
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
	private static void lock() {
		synchronized(BlockingFIFO.class) {
			while(isLocked) {
				try {
					BlockingFIFO.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			isLocked = true;
		}
	}
	
	private static void unlock() {
		synchronized(BlockingFIFO.class) {
			isLocked = false;
			BlockingFIFO.class.notify();
		}
	}
}
