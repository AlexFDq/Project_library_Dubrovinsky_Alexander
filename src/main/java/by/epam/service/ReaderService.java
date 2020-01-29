package by.epam.service;

import by.epam.entity.Reader;
import by.epam.service.exception.ServiceException;

public interface ReaderService {
    void signIn(String login, String password) throws ServiceException;
    void register(Reader reader) throws ServiceException;
}
