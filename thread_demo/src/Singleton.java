
public class Singleton {
	
	private Singleton(){}
	
	private static Singleton singl;
	private static Object token = new Object();
	
	public static Singleton getInstance()
	{
		if(singl == null){
			synchronized(token)
			{
				if(singl==null)
					singl = new Singleton();
			}
		}
		return singl;
	}
}
