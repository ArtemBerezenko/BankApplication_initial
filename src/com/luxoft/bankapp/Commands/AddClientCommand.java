package com.luxoft.bankapp.Commands;

/**
 * Created by omsk20 on 11/10/2016.
 */
public class AddClientCommand implements Command {

    @Override
    public void execute() {
        System.out.println("AddClientCommand");
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Add Client Command");

    }
}
