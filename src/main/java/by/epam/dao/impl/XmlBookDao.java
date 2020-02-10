package by.epam.dao.impl;

import by.epam.dao.BookDao;
import by.epam.dao.exception.DaoException;
import by.epam.entity.Book;
import by.epam.entity.Reader;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlBookDao implements BookDao {
    private final String BOOK_PATH = "D:\\IntroductionToJava\\Project_library_Dubrovinsky_Alexander\\src\\main\\resources\\books.xml";
    private final String AUTH_PATH = "D:\\IntroductionToJava\\Project_library_Dubrovinsky_Alexander\\src\\main\\resources\\authorization.xml";

    private List<Book> books = new ArrayList<>();
    private Reader authReader;

    @Override
    public void addBook(Book book) throws DaoException {
        deserializeAuth();
        if (authReader == null) {
            throw new DaoException("Error during adding procedure");
        }
        for (Book existingBook : books) {
            if (existingBook.getName().equals(book.getName())) {
                throw new DaoException("Book with the name " + book.getName() + " already exists");
            }
        }
        int maxID = 0;
        for (Book existingBook : books) {
            maxID = Math.max(existingBook.getId(), maxID);
        }
        book.setId(maxID + 1);
        books.add(book);
        serialize();
    }

    @Override
    public void deleteBook(int bookId) throws DaoException {
        deserializeAuth();
        if (authReader == null) {
            throw new DaoException("Error during deleting procedure");
        }
        deserialize();
        int index = -1;
        for (Book book : books)
            if (book.getId() == bookId) {
                index = books.indexOf(book);
                break;
            }
        if (index < 0) {
            throw new DaoException("Book with id " + bookId + " does not exist");
        } else {
            books.remove(index);
        }
        serialize();
    }

    @Override
    public void changeAuthor(int bookId, String author) throws DaoException {
        deserializeAuth();
        if (authReader == null) {
            throw new DaoException("Error during changing author's name procedure");
        }
        deserialize();
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.setAuthor(author);
                serialize();
                return;
            }
        }
        throw new DaoException("Book with id " + bookId + " does not exist");
    }

    @Override
    public void changeName(int bookId, String name) throws DaoException {
        deserializeAuth();
        if (authReader == null) {
            throw new DaoException("Error during changing book name procedure");
        }
        deserialize();
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.setName(name);
                serialize();
                return;
            }
        }
        throw new DaoException("Book with id " + bookId + " does not exist");
    }

    @Override
    public void changeYear(int bookId, int year) throws DaoException {
        deserializeAuth();
        if (authReader == null) {
            throw new DaoException("Error during changing book year procedure");
        }
        deserialize();
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.setYear(year);
                serialize();
                return;
            }
        }
        throw new DaoException("Book with id " + bookId + " does not exist");
    }

    private void serialize() throws DaoException {
        try (FileOutputStream fos = new FileOutputStream(BOOK_PATH)) {
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(books);
            encoder.close();
        } catch (FileNotFoundException e) {
            throw new DaoException("Data file not found");
        } catch (IOException e) {
            throw new DaoException("Serialization error");
        }
    }

    private void deserialize() throws DaoException {
        try (FileInputStream fis = new FileInputStream(BOOK_PATH)) {
            XMLDecoder decoder = new XMLDecoder(fis);
            books = (List<Book>) decoder.readObject();
            decoder.close();
        } catch (FileNotFoundException e) {
            throw new DaoException("Data file not found");
        } catch (IOException e) {
            throw new DaoException("Deserialization error");
        }
    }

    private void deserializeAuth() throws DaoException {
        try (FileInputStream fis = new FileInputStream(AUTH_PATH)) {
            XMLDecoder decoder = new XMLDecoder(fis);
            authReader = (Reader) decoder.readObject();
            decoder.close();
        } catch (FileNotFoundException e) {
            throw new DaoException("Data file not found");
        } catch (IOException e) {
            throw new DaoException("Deserialization error");
        }
    }
}
