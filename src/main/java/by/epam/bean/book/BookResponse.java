package by.epam.bean.book;

import by.epam.bean.Response;
import by.epam.entity.Book;

public class BookResponse extends Response {
    private Book book = new Book();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
