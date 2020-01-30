package by.epam.service.impl;

import by.epam.dao.ReaderDao;
import by.epam.dao.exception.DaoException;
import by.epam.dao.factory.DaoFactory;
import by.epam.entity.Reader;
import by.epam.service.ReaderService;
import by.epam.service.exception.ServiceException;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void signIn(String login, String password) throws ServiceException {
        if (login == null) {
            throw new ServiceException("Login equals null");
        }
        if (password == null) {
            throw new ServiceException("Password equals null");
        }

        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            ReaderDao readerDao = daoObjectFactory.getReaderDao();
            readerDao.signIn(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void register(Reader reader) throws ServiceException {
        if (reader == null)
            throw new ServiceException("Incorrect data");
        if (reader.getLogin() == null || reader.getLogin().isEmpty())
            throw new ServiceException("Incorrect login");
        if (reader.getPassword() == null || reader.getPassword().isEmpty())
            throw new ServiceException("Incorrect password");

        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            ReaderDao readerDao = daoObjectFactory.getReaderDao();
            readerDao.register(reader);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
