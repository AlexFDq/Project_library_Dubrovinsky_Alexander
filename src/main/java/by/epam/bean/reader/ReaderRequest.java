package by.epam.bean.reader;

import by.epam.bean.Request;
import by.epam.entity.Reader;

public class ReaderRequest extends Request {
    private Reader reader = new Reader();

    public String getLogin() {
        return reader.getLogin();
    }

    public void setLogin(String login) {
        this.reader.setLogin(login);
    }

    public String getPassword() {
        return reader.getPassword();
    }

    public void setPassword(String password) {
        this.reader.setPassword(password);
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
