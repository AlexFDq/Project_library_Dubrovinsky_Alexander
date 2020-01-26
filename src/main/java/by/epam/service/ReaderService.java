package by.epam.service;

import by.epam.service.exception.ReaderException;

public class ReaderService {
    public void signIn(String login, String password) throws ReaderException {
        if (login == null || password == null) {
            throw new ReaderException("login or password equals null");
        }
    }
}
