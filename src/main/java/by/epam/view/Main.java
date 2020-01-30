package by.epam.view;

import by.epam.bean.Response;
import by.epam.bean.book.BookRequest;
import by.epam.bean.book.BookResponse;
import by.epam.bean.reader.ReaderRequest;
import by.epam.bean.reader.ReaderResponse;
import by.epam.controller.Controller;
import by.epam.controller.command.CommandName;
import by.epam.controller.command.CommandStatus;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Controller controller = new Controller();

    private static void printResultMessage(Response response) {
        if (response.getStatus() == CommandStatus.SUCCESS) {
            System.out.println(response.getSuccessMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }
    }

    private static void signIn() {
        System.out.println("Enter login:");
        String login = input.nextLine();

        System.out.println("Enter password:");
        String password = input.nextLine();

        ReaderRequest readerRequest = new ReaderRequest();
        readerRequest.setLogin(login);
        readerRequest.setPassword(password);
        readerRequest.setCommandName(CommandName.SIGN_IN);

        ReaderResponse readerResponse = (ReaderResponse) controller.executeTask(readerRequest);
        printResultMessage(readerResponse);
    }

    private static void register() {
        System.out.println("Enter login:");
        String login = input.nextLine();

        System.out.println("Enter password:");
        String password = input.nextLine();

        ReaderRequest readerRequest = new ReaderRequest();
        readerRequest.setLogin(login);
        readerRequest.setPassword(password);
        readerRequest.setCommandName(CommandName.REGISTRATION);

        ReaderResponse readerResponse = (ReaderResponse) controller.executeTask(readerRequest);
        printResultMessage(readerResponse);
    }

    private static void addBook() {
        System.out.println("Enter the name of a book:");
        String name = input.nextLine();

        System.out.println("Enter the author of a book:");
        String author = input.nextLine();

        int year = getYear();

        BookRequest bookRequest = new BookRequest();
        bookRequest.setName(name);
        bookRequest.setAuthor(author);
        bookRequest.setYear(year);
        bookRequest.setCommandName(CommandName.ADD_BOOK);

        BookResponse bookResponse = (BookResponse) controller.executeTask(bookRequest);
        printResultMessage(bookResponse);
    }

    private static int getBookId() {
        int id;
        do {
            System.out.println("Enter book id:");
            try {
                id = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                id = -1;
            }
        } while (id < 0);
        return id;
    }

    private static int getYear() {
        int year;
        do {
            System.out.println("Enter year of the book:");
            try {
                year = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                year = -1;
            }
        } while (year < 0);
        return year;
    }

    private static void deleteBook() {
        int id = getBookId();
        BookRequest bookRequest = new BookRequest();
        bookRequest.setId(id);
        bookRequest.setCommandName(CommandName.DELETE_BOOK);

        BookResponse bookResponse = (BookResponse) controller.executeTask(bookRequest);
        printResultMessage(bookResponse);
    }

    private static void changeAuthor() {
        int id = getBookId();
        System.out.println("Enter new author's name of the book");
        String author = input.nextLine();

        BookRequest bookRequest = new BookRequest();
        bookRequest.setId(id);
        bookRequest.setAuthor(author);
        bookRequest.setCommandName(CommandName.CHANGE_AUTHOR);

        BookResponse bookResponse = (BookResponse) controller.executeTask(bookRequest);
        printResultMessage(bookResponse);
    }

    private static void changeName() {
        int id = getBookId();
        System.out.println("Enter new name of the book");
        String name = input.nextLine();

        BookRequest bookRequest = new BookRequest();
        bookRequest.setId(id);
        bookRequest.setName(name);
        bookRequest.setCommandName(CommandName.CHANGE_NAME);

        BookResponse bookResponse = (BookResponse) controller.executeTask(bookRequest);
        printResultMessage(bookResponse);
    }

    private static void changeYear() {
        int id = getBookId();
        int year = getYear();

        BookRequest bookRequest = new BookRequest();
        bookRequest.setId(id);
        bookRequest.setYear(year);
        bookRequest.setCommandName(CommandName.CHANGE_YEAR);

        BookResponse bookResponse = (BookResponse) controller.executeTask(bookRequest);
        printResultMessage(bookResponse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Choose the command you want to execute.");
            System.out.println("1 - sign in\n" +
                    "2 - register\n" +
                    "3 - add a book to the catalog\n"   +
                    "4 - delete a book from the catalog\n" +
                    "5 - change info about the author\n" +
                    "6 - change info about the name\n" +
                    "7 - change info about the year\n" +
                    "8 - exit");
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
                    System.out.println("Done");
                    break;
                default:
                    System.out.println("This command doesn't exist");
                    break;
            }
        }
    }
}
