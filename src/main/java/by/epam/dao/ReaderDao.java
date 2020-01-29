package by.epam.dao;

import by.epam.entity.Reader;
import by.epam.dao.exception.DaoException;

public interface ReaderDao {
    void signIn(String login, String password) throws DaoException;
    void register(Reader reader) throws DaoException;
}
