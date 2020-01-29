package by.epam.service;

import by.epam.entity.Book;
import by.epam.service.exception.ServiceException;

public interface BookService {
    void addBook(Book book) throws ServiceException;
    void deleteBook(int bookId) throws ServiceException;
    void changeAuthor(int bookId, String author) throws ServiceException;
    void changeName(int bookId, String name) throws ServiceException;
    void changeYear(int bookId, int year) throws ServiceException;
}
