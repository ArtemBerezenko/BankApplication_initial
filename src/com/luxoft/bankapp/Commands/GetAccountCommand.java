package com.luxoft.bankapp.Commands;

import com.luxoft.bankapp.BankCommander.BankCommander;
import com.luxoft.bankapp.model.Account;


import java.util.Scanner;

/**
 * Created by omsk20 on 11/10/2016.
 */
public class GetAccountCommand implements Command {
    @Override
    public void execute() {
        System.out.println(BankCommander.currentClient.getAccounts().toString());
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Get Account Command");
    }
}
