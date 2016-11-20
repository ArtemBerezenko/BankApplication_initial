package com.luxoft.bankapp.Commands;

import com.luxoft.bankapp.BankCommander.BankCommander;
import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.model.Client;

import java.util.Scanner;

/**
 * Created by omsk20 on 11/10/2016.
 */
public class TransferCommand implements Command {

//    @Override
//    public void execute() {
//        Client oldCur = BankCommander.currentClient;
//        float newBalance = 0;
//        float balance = BankCommander.currentClient.getBalance();
//        System.out.println("Current balance: " + balance);
//        Scanner scanner = new Scanner(System.in);
//        BankCommander.currentBank.printReport();
//        System.out.println("Enter client name: ");
//        String name = scanner.nextLine();
//        for(Client client : BankCommander.currentBank.getClients()){
//            if(client.getName().equals(name)){
//                BankCommander.currentClient = client;
//                System.out.println(BankCommander.currentClient.toString());
//                System.out.println("Enter amount for Transfer Command: ");
//                float amount = Float.parseFloat(scanner.nextLine());
//                try {
//                    client.withdraw(amount);
//                } catch (NotEnoughFundsException e) {
//                    System.out.println("Not enough found");;
//                }
//
//                oldCur.deposit(amount);
//
//                System.out.println(oldCur.toString());
//                System.out.println(client.toString());
//                client = oldCur;
//                return;
//            }
//        }
//        System.out.println("Client not found!");
//
//    }

    @Override
    public void execute() {
        Client oldCur = BankCommander.currentClient;
        float balance = BankCommander.currentClient.getBalance();
        System.out.println("Current " + oldCur);
        System.out.println("Current balance: " + balance);
        Scanner scanner = new Scanner(System.in);
        BankCommander.currentBank.printReport();
        System.out.println("Enter client name: ");
        String name = scanner.nextLine();
        try {
            BankCommander.currentClient = BankCommander.currentBank.getClients().get(name);
            System.out.println(BankCommander.currentClient.toString());
            System.out.println("Enter amount for Transfer Command: ");
            float amount = Float.parseFloat(scanner.nextLine());
            try {
                oldCur.withdraw(amount);
                BankCommander.currentClient.deposit(amount);
                System.out.println(oldCur.toString());
                System.out.println(BankCommander.currentClient.toString());
            } catch (NotEnoughFundsException e) {
                System.out.println("Not enough found!");;
            }
            BankCommander.currentClient = oldCur;
        } catch (IllegalArgumentException e) {
            System.out.println("Client not found!");
        }
        return;
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Transfer Command");

    }
}


