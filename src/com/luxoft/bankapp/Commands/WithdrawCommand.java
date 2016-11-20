package com.luxoft.bankapp.Commands;

import com.luxoft.bankapp.BankCommander.BankCommander;
import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

import java.util.Scanner;

/**
 * Created by omsk20 on 11/10/2016.
 */
public class WithdrawCommand implements Command {
    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextFloat();
        try {
            BankCommander.currentClient.getActiveAccount().withdraw(amount);
        } catch (NotEnoughFundsException e) {
            System.out.println("Not enough found");
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Withdraw Command");

    }
}
