package by.epam.entity;

import java.io.Serializable;

public class Admin implements Serializable {
    private static final long serialVersionUID = 5L;

    private String name;

    public Admin() {
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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Admin admin = (Admin) obj;
        return (this.name.equals(admin.name));
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
