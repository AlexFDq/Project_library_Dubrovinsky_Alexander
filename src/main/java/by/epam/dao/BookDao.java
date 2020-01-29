package by.epam.dao;

import by.epam.entity.Book;
import by.epam.dao.exception.DaoException;

import java.util.ArrayList;

public interface BookDao {
    void addBook(Book book) throws DaoException;
    void deleteBook(int bookId) throws DaoException;
    void delete(Book book) throws DaoException;
    void changeInfo(Book book, ArrayList<String> info) throws DaoException;
}
