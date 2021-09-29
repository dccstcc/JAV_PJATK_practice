import java.util.ArrayList;
import java.util.List;


public class Pet {
	
	private String name;
	private List<PetListener> listeners;
	
	private Thread life = new Thread()
	{
		public void run()
		{
			while(true)
			{
				int r = (int)(Math.random()*3);
				switch(r)
				{
				case 0: hungry();break;
				case 1: bored();break;
				case 2: dirty();break;
				}
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	};
	
	
	public Pet(String name)
	{
		this.name=name;
		this.listeners = new ArrayList<PetListener>();
		life.start();
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public synchronized void addListener(PetListener listener)
	{
		listeners.add(listener);
	}
	
	public synchronized void removeListener(PetListener listener)
	{
		listeners.remove(listener);
	}
	
	protected synchronized void hungry()
	{
		System.out.println("jestem głodny");
		PetEvent e = new PetEvent(this);
		for(PetListener l: listeners)
		{
			l.petHungry(e);
		}
		
	}
	
	protected synchronized void bored()
	{
		System.out.println("nudzi mi sie");
		PetEvent e = new PetEvent(this);
		for(PetListener l: listeners)
		{
			l.petBored(e);
		}
		
	}
	
	protected synchronized void dirty()
	{
		System.out.println("pobrudziłem sie");
		PetEvent e = new PetEvent(this);
		for(PetListener l: listeners)
		{
			l.petDirty(e);
		}
		
	}
	
}
