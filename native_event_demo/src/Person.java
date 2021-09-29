
public class Person implements PetListener{

	private String name;
	
	public Person(String name)
	{
		this.name=name;
	}
	
	@Override
	public void petHungry(PetEvent e) {
		System.out.println(name + " karmi "+ e.getPet().getName() );
		
	}

	@Override
	public void petBored(PetEvent e) {

		System.out.println(name + " bawi się z "+ e.getPet().getName() );
		
	}

	@Override
	public void petDirty(PetEvent e) {

		System.out.println(name + " daje kąpiel "+ e.getPet().getName());
		
	}

}
