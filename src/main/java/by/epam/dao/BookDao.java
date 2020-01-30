package by.epam.dao;

import by.epam.entity.Book;
import by.epam.dao.exception.DaoException;

public interface BookDao {
    void addBook(Book book) throws DaoException;
    void deleteBook(int bookId) throws DaoException;
    void changeAuthor(int bookId, String author) throws DaoException;
    void changeName(int bookId, String name) throws DaoException;
    void changeYear(int bookId, int year) throws DaoException;
}
