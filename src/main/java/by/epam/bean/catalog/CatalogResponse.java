package by.epam.bean.catalog;

import by.epam.bean.Response;
import by.epam.entity.Catalog;

public class CatalogResponse extends Response {
    private Catalog catalog = new Catalog();

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
