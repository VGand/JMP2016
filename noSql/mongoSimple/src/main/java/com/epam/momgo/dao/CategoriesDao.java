package com.epam.momgo.dao;

import com.epam.momgo.beans.Category;

import java.util.List;

/**
 * Created by Полина on 16.10.2016.
 */
public interface CategoriesDao {

    List<Category> getCategories();

    void addCategory(Category category);

    Category getCategoryByName(String name);
}
