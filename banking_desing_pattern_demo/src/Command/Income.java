package Command;

import Banking.Account;
import Banking.HistoryLog;

public class Income extends Operation {
    Account destination;
    double ammount;

    public Income(Account destination, double ammount) {
        this.destination = destination;
        this.ammount = ammount;
    }

    @Override
    public void execute() {
        this.destination.add(ammount);
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Destination: ");
        string.append(this.destination.getNumber());
        string.append(", ammount: ");
        string.append(this.ammount);
        string.append(".");

        return string.toString();
    }
}
