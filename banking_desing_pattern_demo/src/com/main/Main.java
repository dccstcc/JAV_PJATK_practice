package com.main;

import Banking.Account;
import Banking.Bank;
import Command.Income;
import Command.Operation;
import Command.Transfer;

public class Main {

    public static void main(String[] args) {
	    Account account1 = new Account("Account number 1");

        Operation income = new Income(account1, 500);
        Bank bank = new Bank();
        bank.takeOperation(income);

        bank.executeOperations();

        System.out.println(account1.getAmmount());

        Account account2 = new Account("Account number 2");

        Operation transfer = new Transfer(account1, account2, 300);
        bank.takeOperation(transfer);
        bank.executeOperations();

        System.out.println(account1.getAmmount());
        System.out.println(account2.getAmmount());

        System.out.println(account1.showLogs());
        System.out.println(account2.showLogs());
    }
}
