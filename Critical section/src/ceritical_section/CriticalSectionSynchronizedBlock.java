package ceritical_section;

public class CriticalSectionSynchronizedBlock
{
	 String message = "Now Is The Time For All Good Men\n";
	 int numThreads = 200;
	
	 Integer lock = 1;
	 public CriticalSectionSynchronizedBlock() {
		 
	 }

	public static void main(String args[])
	{
		CriticalSectionSynchronizedBlock c = new CriticalSectionSynchronizedBlock();
	
		for (int idx = 0; idx < c.numThreads; idx++) {
			Thread t = new Thread(new StreamPrinter(c));
			t.start();
		}
	}

}