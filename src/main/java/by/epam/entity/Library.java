package by.epam.entity;

import java.io.Serializable;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;

    private Catalog catalog;

    private static Library instance;

    public Library() {}

//    public Library(Catalog catalog) {
//        this.catalog = catalog;
//    }

    public static Library getInstance() {
        if (instance == null) {
            return new Library();
        }
        return instance;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Library library = (Library) obj;
        return library.catalog.equals(this.catalog);
    }

    @Override
    public int hashCode() {
        return 31 + (catalog == null ? 0 : catalog.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "catalog = " + catalog;
    }
}