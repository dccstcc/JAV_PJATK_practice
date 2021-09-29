package zadanie;

import java.util.ArrayList;
import java.util.List;

public class Client implements Visitable {
    String _number;
    List<Order> _orders;
    
    public Client() { 
        this("");
    }
    public Client(String number) {
        this._number = number;
        this._orders = new ArrayList<>();
    }
    
    public String getNumber() { 
        return this._number;
    }
    public void setNumber(String number) {
        this._number = number;
    }
    public void addOrder(Order order) {
        this._orders.add(order);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    

    @Override
    public String giveReport() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += "Client: " + this._number + ", Orders:\n";
        for(Order order : this._orders)
            str += "\t" + order.toString() + "\n";
        
        return str;
    }
}