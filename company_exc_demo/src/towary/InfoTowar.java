package towary;

public class InfoTowar {
	 public static void main(String[] args) {
		
		 	
		 	odczyt info = new odczyt();
		 	Towar hulahop = info.towar("hulahop","sztuki",13.43,20,200, 3958.23,4593.23,43);
		 
		 	hulahop.Info();
	 }
}
