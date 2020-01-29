package by.epam.service.impl;

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
    }

    @Override
    public void register(Reader reader) throws ServiceException {
        if (reader == null)
            throw new ServiceException("Incorrect data");
        if (reader.getLogin() == null || reader.getLogin().isEmpty())
            throw new ServiceException("Incorrect login");
        if (reader.getPassword() == null || reader.getPassword().isEmpty())
            throw new ServiceException("Incorrect password");
    }
}
