package com.luxoft.bankapp.BankCommander;

import com.luxoft.bankapp.Commands.*;
import com.luxoft.bankapp.model.Bank;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

/**
 * Created by omsk20 on 11/10/2016.
 */
public class BankCommander {
    public static Bank currentBank = new Bank();
    public static Client currentClient;

   public static Command[] commands = {
            new BankFeedCommand(),
            new FindClientCommand(),
            new GetAccountCommand(),
            new WithdrawCommand(),
            new DepositCommand(),
            new TransferCommand(),
            new AddClientCommand(),
            new Command(){
                public void execute() {
                    System.exit(0);
                }
                public void printCommandInfo() {
                    System.out.println("Exit");
                }
            }
    };

    public static void printMenu() {
        for (int i=0;i<commands.length;i++) {
            System.out.print(i+") ");
            commands[i].printCommandInfo();
        }
    }
}
