package by.epam.entity;

import java.io.Serializable;
import java.util.List;

public class Catalog implements Serializable {
    private static final long serialVersionUID = 3L;

    private List<Book> books;

    public Catalog() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Catalog catalog = (Catalog) obj;
        return this.books.equals(catalog.books);
    }

    @Override
    public int hashCode() {
        return 31 + (books == null ? 0 : books.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "books = " + books;
    }
}
