package towary;

public class odczyt {
	
	
		Towar towar (String nazwa,  String jednostkaSprzedazy,
			double cenaJednostkowaNetto, double cenaJednostkowaBrutto,
			int iloscJednostek,			 double cenaCalkowitaNetto,
			double cenaCalkowitaBrutto,  double procentPodatku){

				Towar towar = new Towar();
		
					towar.nazwa = nazwa;
					towar.jednostkaSprzedazy = jednostkaSprzedazy;
					towar.cenaJednostkowaNetto = cenaJednostkowaNetto;
					towar.cenaJednostkowaBrutto = cenaJednostkowaBrutto;
					towar.iloscJednostek = iloscJednostek;
					towar.cenaCalkowitaNetto = cenaCalkowitaNetto;
					towar.cenaCalkowitaBrutto = cenaCalkowitaBrutto;
					towar.procentPodatku = procentPodatku;
	
					
					return towar;
	}	
		
		
		}
			

