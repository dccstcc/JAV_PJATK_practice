package zad1.faktura;
public class Article {
    public  String Name;
    public  Unit Unit;
    public  Price Price;
    
    public Article(String name, Unit unit, Price price)
    {
        this.Name = name;
        this.Unit = unit;
        this.Price = price;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        str += "{" + this.Name + ", Unit: " + this.Unit.toString() +
                ", Price: " + this.Price.toString() + "}";
        return str;
    }
}
