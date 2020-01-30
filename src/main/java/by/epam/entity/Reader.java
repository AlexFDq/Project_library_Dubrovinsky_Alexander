package by.epam.entity;

import java.io.Serializable;

public class Reader implements Serializable {
    private static final long serialVersionUID = 4L;

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Reader reader = (Reader) obj;
        return this.login.equals(reader.login) &&
                this.password.equals(reader.password);
    }

    @Override
    public int hashCode() {
        return 31 + (login == null ? 0 : login.hashCode()) +
                    (password == null ? 0 : password.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "login = " + login +
                "password = " + password;
    }
}
