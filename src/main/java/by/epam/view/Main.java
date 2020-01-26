package by.epam.view;

import by.epam.controller.CommandProvider;
import by.epam.controller.command.Command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose the command you want to execute.");
        System.out.println("1 - sing in" + "/n" +
                "2 - register" + "/n" +
                "3 - add a book to the catalog" + "/n" +
                "4 - change info of a book" + "/n" +
                "5 - delete a book from the catalog");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        CommandProvider commandProvider = new CommandProvider();
        Command command;

        switch (choice) {
            case "1":
                command = commandProvider.getCommand("sign_in");
                break;
            case "2":
                command = commandProvider.getCommand("registration");
                break;
            case "3":
                command = commandProvider.getCommand("add_book");
                break;
            case "4":
                command = commandProvider.getCommand("delete_book");
                break;
            case "5":
                command = commandProvider.getCommand("change_info");
                break;
            default:
                command = commandProvider.getCommand("wrong_request");
        }
        System.out.println(command.execute());
    }
}
