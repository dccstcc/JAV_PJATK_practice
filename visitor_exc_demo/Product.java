package zadanie;

public class Product implements Visitable {
    String _name;
    double _price;
    
    public Product(String name, double price) { 
        this._name = name;
        this._price = price;
    }
    
    
    public String getName() {
        return this._name;
    }
    public void setName(String name) { 
        this._name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String giveReport() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += "Product: " + this._name + ", price: " + this._price + ".";
        
        return str;
    }
}