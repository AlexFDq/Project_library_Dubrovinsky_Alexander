package by.epam.bean.catalog;

import by.epam.bean.Request;
import by.epam.entity.Book;
import by.epam.entity.Catalog;

import java.util.List;

public class CatalogRequest extends Request {
    private Catalog catalog = new Catalog();

    public List<Book> getBooks() {
        return catalog.getBooks();
    }

    public void setBooks(List<Book> books) {
        this.catalog.setBooks(books);
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
