package by.epam.service.factory;

import by.epam.service.*;
import by.epam.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final AdminService adminService = new AdminServiceImpl();
    private final BookService bookService = new BookServiceImpl();
    private final CatalogService catalogService = new CatalogServiceImpl();
    private final LibrarianService librarianService = new LibrarianServiceImpl();
    private final LibraryService libraryService = new LibraryServiceImpl();
    private final ReaderService readerService = new ReaderServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }

    public LibrarianService getLibrarianService() {
        return librarianService;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }

    public ReaderService getReaderService() {
        return readerService;
    }
}
