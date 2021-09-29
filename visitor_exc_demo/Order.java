package zadanie;

import java.util.Date;
import java.util.List;

public class Order implements Visitable {
    String _number;
    double _price;
    Date _date;
    List<Product> _products;
    
    public Order(String number, List<Product> products) {
        this._number = number;
        this._products = products;
        
        this._date = new Date();
        
        if(products != null)
            for(Product product : products)
                this._price += product._price;
    }
    
    
    public String getNumber() {
        return this._number;
    }
    public double getPrice() {
        return this._price;
    }
    public Date getDate() {
        return this._date;
    }
    public void addProduct(Product product) {
        this._products.add(product);
        this._price += product._price;
    }
       @Override
    public String toString() {
        String str = "";
        
        str += "Order: " + this._number + ", date: " + this._date + ", price: " + this._price + "\nProducts: .";
        for(Product product : this._products)
            str += "\n\t" + product.toString();
        
        return str;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String giveReport() {
        return this.toString();
    }
    
}