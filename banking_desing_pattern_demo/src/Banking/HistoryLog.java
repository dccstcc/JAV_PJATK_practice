package Banking;

import Command.OperationType;

import java.util.Date;

public class HistoryLog {
    Date date;
    String details;
    OperationType operationType;

    public HistoryLog(String details, OperationType operationType) {
        this.date = new Date();
        this.details = details;
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Date: ");
        string.append(this.date.toLocaleString());
        string.append(", operation type: ");
        string.append(this.operationType);
        string.append(", ");
        string.append(this.details);

        return string.toString();
    }
}
