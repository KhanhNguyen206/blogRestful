package com.khanhnn.blog.formatter;

import com.khanhnn.blog.service.CategoryService;
import com.khanhnn.blog.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {

    private CategoryService categoryService;

    @Autowired
    public CategoryFormatter(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return categoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
