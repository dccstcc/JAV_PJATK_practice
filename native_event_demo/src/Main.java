
public class Main {

	public static void main(String[] args) {
		
		Person p = new Person("Bot");
		Pet pet = new Pet("burek");
		pet.addListener(p);
		
	}

}
