package mk.ukim.finki.webaud.service;

import mk.ukim.finki.webaud.model.Category;

import java.awt.*;
import java.util.List;

public interface CategoryService {
    Category create(String name,String description);

    Category update(String name,String description);

    void delete(String name);

    List<Category>listcategories();

    List<Category>searchCategories(String searchText);
}
