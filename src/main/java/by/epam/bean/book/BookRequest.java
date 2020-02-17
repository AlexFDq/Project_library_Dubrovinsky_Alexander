package by.epam.bean.book;

import by.epam.bean.Request;
import by.epam.entity.Book;

public class BookRequest extends Request {// перебор у тебя с логикой
    // делать объект для перености другого объекта с полным дуляжом методов - поолный перебор
    // и если уже делаешь bean-классы - соблюдай для них все правила - где Serializable, equals, hashCode?
    private Book book = new Book();

    public int getYear() {
        return book.getYear();
    }

    public void setYear(int year) {
        this.book.setYear(year);
    }

    public String getName() {
        return book.getName();
    }

    public void setName(String name) {
        this.book.setName(name);
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public void setAuthor(String author) {
        this.book.setAuthor(author);
    }

    public int getId() {
        return book.getId();
    }

    public void setId(int id) {
        this.book.setId(id);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
