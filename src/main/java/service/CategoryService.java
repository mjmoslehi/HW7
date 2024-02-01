package service;

import repository.CategoryRepository;

import java.util.Scanner;

public class CategoryService {
    private final Scanner scanner = new Scanner(System.in);
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
