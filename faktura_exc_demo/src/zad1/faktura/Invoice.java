package zad1.faktura;

import java.util.Date;
import java.util.List;

public class Invoice {
    public  String Number;
    public  List<Line> Lines;
    public  Date DateOfSale;
    public  Price Price;
    public  PaymentDate PaymentDate;
    
    public Invoice(String number, List<Line> lines, Date dateOfSale, 
            PaymentDate pDate) {
        this.Number = number;
        this.Lines = lines;
        this.DateOfSale = dateOfSale;
        this.PaymentDate = pDate;
        
        float b = 0,n = 0;
        for(Line line : this.Lines) {
            b += line.Price.Brutto;
            n += line.Price.Netto;
        }
        
        this.Price = new Price(n, b, 0);
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        str += "{No.: " + this.Number + ", date of sale: " + this.DateOfSale.toLocaleString()
                + ", payment date: " + this.PaymentDate.toString() + ".\nLines:";
        
        for(Line line : this.Lines) {
            str += "\n\t" + line.toString();
        }
        
        str += "\n\n";
        str += "Total cost: " + this.Price.toString() + "}";
        
        return str;
    }
}
