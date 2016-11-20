package com.luxoft.bankapp.Commands;

import com.luxoft.bankapp.BankCommander.BankCommander;

import java.util.Scanner;

/**
 * Created by omsk20 on 11/10/2016.
 */
public class DepositCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();
        BankCommander.currentClient.getActiveAccount().deposit(amount);

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Deposit Command");

    }
}
