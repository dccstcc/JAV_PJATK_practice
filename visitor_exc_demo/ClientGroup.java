package zadanie;

import java.util.ArrayList;
import java.util.List;

public class ClientGroup implements Visitable {
    String _name;
    List<Client> _clients;
    
    public ClientGroup(String name) {
        this._name = name;
        this._clients = new ArrayList<>();
    }
    
    public void addClient(Client client) {
        this._clients.add(client);
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
        
        str += "ClientGroup: " + this._name + ", Clients:\n";
        for(Client client : this._clients)
            str += "\t" + client.toString() + "\n";
        
        return str;
    }
}