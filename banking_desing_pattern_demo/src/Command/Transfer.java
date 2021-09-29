package Command;

import Banking.Account;
import Banking.HistoryLog;

public class Transfer extends Operation  {
    Account source, destination;
    double ammount;

    public Transfer(Account source, Account destination, double ammount) {
        this.source = source;
        this.destination = destination;
        this.ammount = ammount;
    }
    @Override
    public void execute() {
        this.source.substract(ammount);
        this.destination.add(ammount);
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Source: ");
        string.append(this.source.getNumber());
        string.append(", destination: ");
        string.append(this.destination.getNumber());
        string.append(", ammount: ");
        string.append(this.ammount);
        string.append(".");

        return string.toString();
    }
}
