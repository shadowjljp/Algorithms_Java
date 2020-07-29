package ceritical_section;

public class StreamPrinter implements Runnable
{
	
	CriticalSectionSynchronizedBlock c;
	public StreamPrinter(CriticalSectionSynchronizedBlock c) {
		this.c = c;
	}
	@Override
	public void run()
	{
		while (true) {
			byte chars[] = c.message.getBytes();
			synchronized (c.lock) {
				for (int idx = 0; idx < chars.length; idx++) {
					byte achar = chars[idx];
					System.out.write((char) achar);
					Thread.yield();
				}
			}
		}
	}
}
