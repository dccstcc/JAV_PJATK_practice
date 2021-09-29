package Banking;

import Command.OperationType;

public class Account {
    String number;
    double ammount;

    History history;

    public Account(String number) {
        this.number = number;
        this.ammount = 0;
        this.history = new History();
    }


    public void add(double ammount) {
        this.ammount += ammount;
        this.history.add(
                new HistoryLog("ammount: " + this.ammount, OperationType.Income));
    }
    public void substract(double ammount) {
        this.ammount -= ammount; // Nie znaj?c polityki banku zakadam, ze srodki na koncie moga byc ujemne.
        this.history.add(
                new HistoryLog("ammount: " + this.ammount, OperationType.Outcome));
    }


    public String getNumber() {
        return this.number;
    }
    public double getAmmount() {
        return this.ammount;
    }
    public String showLogs() {
        StringBuilder string = new StringBuilder();
        for(HistoryLog log : this.history.getLogs()) {
            string.append(log.toString());
            string.append("\n");
        }

        return string.toString();
    }
}
