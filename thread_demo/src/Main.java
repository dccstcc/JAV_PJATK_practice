
public class Main {

	public static void main(String[] args) throws InterruptedException
	{
		
		IntPrinter p = new IntPrinter();
		Thread t = new Thread(p);
		System.out.println("Main działa na wątku o id:"+
				Thread.currentThread().getId());
		t.start();
		Thread t2 = new Thread(p);
		t2.start();
		
		
//		while(p.isRunning)
//		{
//			System.out.print(".");
//			Thread.sleep(100);
//		}
	}
}
