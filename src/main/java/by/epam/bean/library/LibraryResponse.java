package by.epam.bean.library;

import by.epam.bean.Response;
import by.epam.entity.Library;

public class LibraryResponse extends Response {
    private Library library = new Library();

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
