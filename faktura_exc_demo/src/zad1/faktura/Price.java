package zad1.faktura;

import java.text.DecimalFormat;

public class Price {
    public  float Netto, Brutto, Tax;
    
    public Price(float brutto, float tax){
        this.Brutto = brutto;
        this.Tax = tax;
        
        float vat = (this.Brutto * this.Tax) / (1 + this.Tax);
        this.Netto = this.Brutto - vat;
    }
    public Price(float netto, float brutto, float tax) {
        this.Netto = netto;
        this.Brutto = brutto;
        this.Tax = tax;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        DecimalFormat dFormat = new DecimalFormat("###.##");
        str += "{Netto: " + dFormat.format(this.Netto) + " zł, brutto: " + dFormat.format(this.Brutto)
                + " zł";
        if(this.Tax == 0)
            str += "}";
        else
            str += ", tax: " + this.Tax + "%}";
        return str;
    }
    
}
