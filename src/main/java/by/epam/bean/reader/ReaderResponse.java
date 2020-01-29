package by.epam.bean.reader;

import by.epam.bean.Response;
import by.epam.entity.Reader;

public class ReaderResponse extends Response {
    private Reader reader = new Reader();

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
