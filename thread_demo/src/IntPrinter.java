import java.util.Random;


public class IntPrinter implements Runnable{

	public boolean isRunning = true;
	private Object token = new Object();
	@Override
	public synchronized void run() {
		System.out.println("Zaczynam działać na wątku: "
							+ Thread.currentThread().getId());
		isRunning = true;
		try {
				for(int i = 1;i<=9;i++)
				{
					Random r = new Random();
					Thread.sleep(5000*(int)r.nextDouble());
					System.out.println(i);
				}
						
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isRunning=false;
		System.out.println("koniec.");
	}

}
