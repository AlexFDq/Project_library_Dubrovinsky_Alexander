package by.epam.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 2L;

    private int year;
    private String name;
    private String author;

    public Book() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return (this.year == book.year) &&
                (this.author.equals(book.author)) &&
                (this.name.equals(book.name));
    }

    @Override
    public int hashCode() {
        return 31 * year + (name == null ? 0 : name.hashCode())
                + (author == null ? 0 : author.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "@" + "year = " + year +
                "name = " + name +
                "author" + author;
    }
}
