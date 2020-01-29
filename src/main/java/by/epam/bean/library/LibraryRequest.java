package by.epam.bean.library;

import by.epam.bean.Request;
import by.epam.entity.Catalog;
import by.epam.entity.Library;

public class LibraryRequest extends Request {
    private Library library = new Library();

    public Catalog getCatalog() {
        return library.getCatalog();
    }

    public void setCatalog(Catalog catalog) {
        this.library.setCatalog(catalog);
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
