package Banking;

import Command.Operation;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Operation> operations;

    public Bank() {
        this.operations = new ArrayList<>();
    }

    public void takeOperation(Operation operation) {
        this.operations.add(operation);
    }
    public void executeOperations() {
        for(Operation operation : this.operations)
            operation.execute();
        this.operations.clear();
    }
}
