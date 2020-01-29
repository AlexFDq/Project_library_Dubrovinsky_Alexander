package by.epam.service.factory;

import by.epam.service.*;
import by.epam.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final BookService bookService = new BookServiceImpl();
    private final CatalogService catalogService = new CatalogServiceImpl();
    private final LibraryService libraryService = new LibraryServiceImpl();
    private final ReaderService readerService = new ReaderServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public BookService getBookService() {
        return bookService;
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }

    public ReaderService getReaderService() {
        return readerService;
    }
}
