package Banking;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<HistoryLog> logs;

    public History() {
        this.logs = new ArrayList<>();
    }

    public void add(HistoryLog log) {
        this.logs.add(log);
    }
    public List<HistoryLog> getLogs() {
        return this.logs;
    }
}
