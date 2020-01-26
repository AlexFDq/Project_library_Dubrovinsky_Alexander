package by.epam.entity;

import java.io.Serializable;
import java.util.Objects;

public class Reader implements Serializable {
    private static final long serialVersionUID = 6L;

    private String name;

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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Reader reader = (Reader) obj;
        return this.name.equals(reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "name = " + name;
    }
}
