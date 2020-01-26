package by.epam.controller.command.impl;

import by.epam.controller.command.Command;
import by.epam.service.ReaderService;
import by.epam.service.exception.ReaderException;
import by.epam.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute() {
        String login = null;
        String password = null;
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReaderService readerService = serviceFactory.getReaderService();

        try {
            readerService.signIn(login, password);
            response = "Welcome";
        } catch (ReaderException e) {
            e.getMessage();
            response = "Error during sign in procedure";
        }
        return response;
    }
}
