package com.luxoft.bankapp.Commands;

import java.util.Scanner;

import static com.luxoft.bankapp.BankCommander.BankCommander.*;


/**
 * Created by omsk20 on 11/10/2016.
 */
public class FindClientCommand implements Command {


//    @Override
//    public void execute() {
//        System.out.println("Please, enter name of client");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        for(Client client : BankCommander.currentBank.getClients()){
//            if(client.getName().equals(name)){
//                BankCommander.currentClient = client;
//                System.out.println(client.toString());
//                return;
//            }
//        }
//        System.out.println("Client not found!");
//    }

    public void execute(){
        System.out.println("Please, enter name of client: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            currentClient = currentBank.getClients().get(name);
            System.out.println(currentClient.toString());
        } catch (Exception e) {
            System.out.println("Client not found!");
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Find Client Command");
    }
}
