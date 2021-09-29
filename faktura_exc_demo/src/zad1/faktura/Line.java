package zad1.faktura;

import java.text.DecimalFormat;

public class Line {
    public  int Number, Ammount;
    public  Article Article;
    public  Price Price;
    
    public Line(int number, Article art, int ammount)
    {
        this.Number = number;
        this.Article = art;
        this.Ammount = ammount;
        
        this.Price = new Price(
            this.Article.Price.Brutto * this.Ammount, this.Article.Price.Tax);
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        DecimalFormat dFormat = new DecimalFormat("###.##");
        str += "{No.: " + this.Number + ", " + this.Article.Name + " x"
                + this.Ammount + ", Cost: " + dFormat.format(this.Price.Netto) + " zł netto, " 
                + dFormat.format(this.Price.Brutto) + " zł brutto}";
        
        return str;
    }
}
