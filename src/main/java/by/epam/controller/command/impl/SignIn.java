package by.epam.controller.command.impl;

import by.epam.bean.Request;
import by.epam.bean.Response;
import by.epam.bean.reader.ReaderRequest;
import by.epam.bean.reader.ReaderResponse;
import by.epam.controller.command.Command;
import by.epam.controller.command.CommandStatus;
import by.epam.service.ReaderService;
import by.epam.service.exception.ServiceException;
import by.epam.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReaderService readerService = serviceFactory.getReaderService();

        ReaderResponse readerResponse = new ReaderResponse();
        ReaderRequest readerRequest = (ReaderRequest) request;

        try {
            readerService.signIn(readerRequest.getLogin(), readerRequest.getPassword());
            readerResponse.setSuccessMessage("Welcome");
            readerResponse.setStatus(CommandStatus.SUCCESS);
        } catch (ServiceException e) {
            readerResponse.setErrorMessage("Error during sign in procedure");
            readerResponse.setStatus(CommandStatus.ERROR);
        }
        return readerResponse;
    }
}
