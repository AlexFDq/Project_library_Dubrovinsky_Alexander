package by.epam.dao.factory;

import by.epam.dao.BookDao;
import by.epam.dao.ReaderDao;
import by.epam.dao.impl.XmlBookDao;
import by.epam.dao.impl.XmlReaderDao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final BookDao bookDao = new XmlBookDao();
    private final ReaderDao readerDao = new XmlReaderDao();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public ReaderDao getReaderDao() {
        return readerDao;
    }
}
