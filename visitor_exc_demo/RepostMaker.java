package zadanie;

public class RepostMaker implements Visitor{
    int _clients,
            _orders,
            _products;
    String _report;

    public RepostMaker() {
        this._clients = this._orders = this._products = 0;
    }
    
    
    public int getNumberOfClients() {
        return this._clients;
    }
    public int getNumberOfOrders() {
       return this._orders;
    }
    public int getNumberOfProducts() { 
        return this._products;
    }
    public String getReport() {
        return this._report;
    }
    
    @Override
    public void visit(Visitable visitable) {
        this._report += "\n" + visitable.giveReport();
        
        switch(visitable.getClass().getSimpleName()) {
            case "Product": this._products++; break;
            case "Order": this._orders++; break;
            case "Client": this._clients++; break;
        }
    }
    
    
}