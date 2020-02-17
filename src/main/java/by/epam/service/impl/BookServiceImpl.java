package by.epam.service.impl;

import by.epam.dao.BookDao;
import by.epam.dao.exception.DaoException;
import by.epam.dao.factory.DaoFactory;
import by.epam.entity.Book;
import by.epam.service.BookService;
import by.epam.service.exception.ServiceException;

// валидатор, все-таки, желательно писать отдельно
// если у тебя в книге будет 100 полей - замучаешься код логики среди валидационного искать
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

        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            BookDao bookDao = daoObjectFactory.getBookDao();
            bookDao.addBook(book);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteBook(int bookId) throws ServiceException {
        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            BookDao bookDao = daoObjectFactory.getBookDao();
            bookDao.deleteBook(bookId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeAuthor(int bookId, String author) throws ServiceException {
        if (author == null || author.isEmpty()) {
            throw new ServiceException("Incorrect author's name");
        }

        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            BookDao bookDao = daoObjectFactory.getBookDao();
            bookDao.changeAuthor(bookId, author);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeName(int bookId, String name) throws ServiceException {
        if (name == null || name.isEmpty()) {
            throw new ServiceException("Incorrect book name");
        }

        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            BookDao bookDao = daoObjectFactory.getBookDao();
            bookDao.changeName(bookId, name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeYear(int bookId, int year) throws ServiceException {
        if (year <= 0) {
            throw new ServiceException("Incorrect book year");
        }

        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            BookDao bookDao = daoObjectFactory.getBookDao();
            bookDao.changeYear(bookId, year);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
