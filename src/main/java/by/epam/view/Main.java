package by.epam.view;

import by.epam.controller.Controller;

import java.util.Scanner;

public class Main {
    private final String ERROR_MESSAGE = "This command doesn't exist";



    public static void main(String[] args) {
        System.out.println("Choose the command you want to execute.");
        System.out.println("1 - sign in" + "/n" +
                "2 - register" + "/n" +
                "3 - add a book to the catalog" + "/n" +
                "4 - delete a book from the catalog" + "/n" +
                "5 - change info about the author" + "/n" +
                "6 - change info about the name" + "/n" +
                "7 - change info about the year" + "/n");
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        boolean isRunning = true;
        while (isRunning) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    signIn();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    addBook();
                    break;
                case "4":
                    deleteBook();
                    break;
                case "5":
                    changeAuthor();
                    break;
                case "6":
                    changeName();
                    break;
                case "7":
                    changeYear();
                    break;
                case "8":
                    isRunning = false;
                    System.out.println("");
                    break;
                default:
                    System.out.println(ERROR_MESSAGE);
                    break;
            }
        }
    }
