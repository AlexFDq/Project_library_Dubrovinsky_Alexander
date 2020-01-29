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

public class Registration implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReaderService readerService = serviceFactory.getReaderService();

        ReaderResponse readerResponse = new ReaderResponse();
        ReaderRequest readerRequest = (ReaderRequest) request;

        try {
            readerService.register(readerRequest.getReader());
            readerResponse.setSuccessMessage("Registration successfully completed");
            readerResponse.setStatus(CommandStatus.SUCCESS);
        } catch (ServiceException e) {
            readerResponse.setErrorMessage("Error during registration procedure");
            readerResponse.setStatus(CommandStatus.ERROR);
        }
        return readerResponse;
    }
}
