package by.epam.dao;

import by.epam.entity.Book;
import by.epam.entity.Catalog;
import by.epam.dao.exception.DaoException;

import java.util.ArrayList;

public interface CatalogDao {
    int getBooksAmount(Catalog catalog) throws DaoException;
    ArrayList<String> getInfo(Book book) throws DaoException;
}
