package towary;

public class Towar {
	
	String nazwa;
	String jednostkaSprzedazy;
	double cenaJednostkowaNetto;
	double cenaJednostkowaBrutto;
	int iloscJednostek;
	double cenaCalkowitaNetto;
	double cenaCalkowitaBrutto;
	double procentPodatku;
			
	void Info() {
		 
		String info = "Nazwa towaru: "  + nazwa + "\n"
				+ "Jednostka Sprzeda¿y: " + jednostkaSprzedazy + "\n" + 
				"Cena jednostkowa Brutto: " + cenaJednostkowaBrutto+ "\n" + 
				"Cena jednostkowa Netto:	 " + cenaJednostkowaNetto + "\n" + 
				"Cena ca³kowita brutto: " + cenaCalkowitaBrutto + "\n" +
				"Cena ca³kowita netto: " + cenaCalkowitaNetto + "\n"  +
				"Procent podatku: "		+ procentPodatku+ "\n" +
				"Iloœæ jednostek: " + iloscJednostek;
			
		
		System.out.println(info);
}
}