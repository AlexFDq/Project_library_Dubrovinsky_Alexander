package by.epam.dao.impl;

import by.epam.dao.ReaderDao;
import by.epam.dao.exception.DaoException;
import by.epam.entity.Reader;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlReaderDao implements ReaderDao {
    private List<Reader> readers = new ArrayList<>();
    private Reader authUser;
    private String readersPath = "D:\\IntroductionToJava\\Project_library_Dubrovinsky_Alexander\\src\\main\\resources\\readers.xml";
    private String authPath = "D:\\IntroductionToJava\\Project_library_Dubrovinsky_Alexander\\src\\main\\resources\\authorization.xml";

    @Override
    public void signIn(String login, String password) throws DaoException {
        deserialize();
        for (Reader signedReader : readers) {
            if (signedReader.getLogin().equals(login) && signedReader.getPassword().equals(password)) {
                authUser = signedReader;
                serializeAuth();
                return;
            }
        }
        throw new DaoException("Incorrect login or password");
    }

    @Override
    public void register(Reader reader) throws DaoException {
        deserialize();
        for (Reader signedReader : readers) {
            if (signedReader.getLogin().equals(reader.getLogin())) {
                throw new DaoException("Login '" + reader.getLogin() + "' is not available");
            }
        }
        readers.add(reader);
        serialize();
    }

    private void serialize() throws DaoException {
        try (FileOutputStream fos = new FileOutputStream(readersPath)) {
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(readers);
            encoder.close();
        } catch (FileNotFoundException e) {
            throw new DaoException("Data file not found");
        } catch (IOException e) {
            throw new DaoException("Serialization error");
        }
    }

    private void serializeAuth() throws DaoException{
        try (FileOutputStream fos = new FileOutputStream(authPath)) {
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(authUser);
            encoder.close();
        } catch (FileNotFoundException e) {
            throw new DaoException("Data file not found");
        } catch (IOException e) {
            throw new DaoException("Serialization error");
        }
    }

    private void deserialize() throws DaoException {
        try (FileInputStream fis = new FileInputStream(readersPath)){
            XMLDecoder decoder = new XMLDecoder(fis);
            readers = (List<Reader>)decoder.readObject();
            decoder.close();
        } catch (FileNotFoundException e) {
            throw new DaoException("Data file not found");
        } catch (IOException e) {
            throw new DaoException("Deserialization error");
        }
    }
}
