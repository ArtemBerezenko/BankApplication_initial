package com.luxoft.bankapp.Commands;

import com.luxoft.bankapp.service.BankFeedService;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by omsk20 on 11/17/2016.
 */
public class BankFeedCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Please, enter path to folder");
        try {
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            BankFeedService.loadFeed(path);
        } catch (Exception e) {
            System.out.println("You entred wrong path to folder");
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Bank Feed Command ");
    }
}
