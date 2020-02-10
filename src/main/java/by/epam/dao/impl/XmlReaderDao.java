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
    private final String READERS_PATH = "D:\\IntroductionToJava\\Project_library_Dubrovinsky_Alexander\\src\\main\\resources\\readers.xml";
    private final String AUTH_PATH = "D:\\IntroductionToJava\\Project_library_Dubrovinsky_Alexander\\src\\main\\resources\\authorization.xml";

    private List<Reader> readers = new ArrayList<>();
    private Reader authUser;

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
        try (FileOutputStream fos = new FileOutputStream(READERS_PATH)) {
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
        try (FileOutputStream fos = new FileOutputStream(AUTH_PATH)) {
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
        try (FileInputStream fis = new FileInputStream(READERS_PATH)){
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
