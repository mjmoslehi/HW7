package service;

import model.Category;
import repository.CategoryRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {
    private final Scanner scanner = new Scanner(System.in);
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void register() throws SQLException {

        System.out.println("category name :");
        String name = scanner.next();

        System.out.println("category description :");
        String description = scanner.next();

        Category category = new Category(name, description);
        categoryRepository.register(category);
        System.out.println(category);
    }


    private Category load(int id) throws SQLException {
        Category category = categoryRepository.load(id);
        return category;
    }

    public void edit() throws SQLException {

        System.out.println("edit category id :");
        int id = scanner.nextInt();
        Category category = load(id);

        System.out.println("edit category name :");
        String name = scanner.next();
        category.setName(name);

        System.out.println("edit category description :");
        String description = scanner.next();
        category.setDescription(description);

        categoryRepository.edit(category);
        System.out.println(category);

    }
}
