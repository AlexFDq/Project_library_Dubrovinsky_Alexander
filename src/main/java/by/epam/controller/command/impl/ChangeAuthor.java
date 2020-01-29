package by.epam.controller.command.impl;

import by.epam.bean.Request;
import by.epam.bean.Response;
import by.epam.bean.book.BookRequest;
import by.epam.bean.book.BookResponse;
import by.epam.controller.command.Command;
import by.epam.controller.command.CommandStatus;
import by.epam.service.BookService;
import by.epam.service.exception.ServiceException;
import by.epam.service.factory.ServiceFactory;

public class ChangeAuthor implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();

        BookResponse bookResponse = new BookResponse();
        BookRequest bookRequest = (BookRequest)request;

        try {
            bookService.changeAuthor(bookRequest.getId(), bookRequest.getAuthor());
            bookResponse.setSuccessMessage("Author's name successfully changed");
            bookResponse.setStatus(CommandStatus.SUCCESS);
        } catch (ServiceException e) {
            bookResponse.setErrorMessage("Error during author's name changing procedure");
            bookResponse.setStatus(CommandStatus.ERROR);
        }
        return bookResponse;
    }
}
