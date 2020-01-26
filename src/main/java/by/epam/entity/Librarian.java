package by.epam.entity;

import java.io.Serializable;

public class Librarian implements Serializable {
    private static final long serialVersionUID = 4L;

    private String name;

    public Librarian() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Librarian librarian = (Librarian) obj;
        return this.name.equals(librarian.name);
    }

    @Override
    public int hashCode() {
        return 31 + (name == null ? 0 : name.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "name = " + name;
    }
}
