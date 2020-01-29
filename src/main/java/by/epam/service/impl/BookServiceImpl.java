package by.epam.service.impl;

import by.epam.entity.Book;
import by.epam.service.BookService;
import by.epam.service.exception.ServiceException;

public class BookServiceImpl implements BookService {
    @Override
    public void addBook(Book book) throws ServiceException {
        if (book == null) {
            throw new ServiceException("Incorrect data");
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new ServiceException("Incorrect author info");
        }
        if (book.getName() == null || book.getName().isEmpty()) {
            throw new ServiceException("Incorrect name info");
        }
        if (book.getYear() <= 0) {
            throw new ServiceException("Incorrect year info");
        }
    }

    @Override
    public void deleteBook(int bookId) throws ServiceException {
        if (bookId <= 0) {
            throw new ServiceException("Incorrect book id");
        }
    }

    @Override
    public void changeAuthor(int bookId, String author) throws ServiceException {
        if (bookId <= 0) {
            throw new ServiceException("Incorrect book id");
        }
        if (author == null || author.isEmpty()) {
            throw new ServiceException("Incorrect author's name");
        }
    }

    @Override
    public void changeName(int bookId, String name) throws ServiceException {
        if (bookId <= 0) {
            throw new ServiceException("Incorrect book id");
        }
        if (name == null || name.isEmpty()) {
            throw new ServiceException("Incorrect book name");
        }
    }

    @Override
    public void changeYear(int bookId, int year) throws ServiceException {
        if (bookId <= 0) {
            throw new ServiceException("Incorrect book id");
        }
        if (year <= 0) {
            throw new ServiceException("Incorrect book year");
        }
    }
}
