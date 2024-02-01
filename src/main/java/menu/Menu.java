package menu;

import service.*;
import utility.ApplicationContext;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    BrandService brandService = ApplicationContext.getBrandService();
    CategoryService categoryService = ApplicationContext.getCategoryService();
    ProductService productService = ApplicationContext.getProductService();
    Shareholder_brandService shareholderBrandService = ApplicationContext.getShareholderBrandService();
    ShareholderService shareholderService = ApplicationContext.getShareholderService();
    UserService userService = ApplicationContext.getUserService();


    public void publicMenu() throws SQLException, ParseException {
        System.out.println("Hello");
        System.out.println("1-register user");
        System.out.println("2-register brand");
        System.out.println("3-register category");
        System.out.println("4-register product");
        System.out.println("5-register shareholder");
        System.out.println("6-register shareholder and brand");

        System.out.println("7-edit brand");
        System.out.println("8-edit category ");
        System.out.println("9-edit product");
        System.out.println("10-edit shareholder");

        System.out.println("11-delete brand");
        System.out.println("12-delete category");
        System.out.println("13-delete product");
        System.out.println("14-delete shareholder");
        System.out.println("15-delete shareholder and brand");

        boolean check = false;
        do {
            System.out.println("enter a number");
            int num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 1 -> registerUser();
                case 2 -> registerBrand();
                case 3 -> registerCategory();
                case 4 -> registerProduct();
                case 5 -> registerShareholder();
                case 6 -> registerShareholderBrand();

                case 7 -> editBrand();
                case 8 -> editCategory();
                case 9 -> editProduct();
                case 10 -> editShareholder();

                case 11 -> deleteBrand();
                case 12 -> deleteCategory();
                case 13 -> deleteProduct();
                case 14 -> deleteShareholder();
                case 15 -> deleteShareholderBrand();
                default -> System.out.println("doesn't exist");
            }
        } while (!check);

    }

    public void registerUser() throws SQLException {
        System.out.println("user registering");
        userService.register();

    }

    public void registerBrand() throws SQLException {
        System.out.println("brand registering");
        brandService.register();
    }

    public void registerCategory() throws SQLException {
        System.out.println("category registering");
        categoryService.register();
    }

    public void registerProduct() throws SQLException, ParseException {

        if (categoryService.check() == 0) {
            System.out.println("plz enter category");
            categoryService.register();

        } else if (brandService.check() == 0) {
            System.out.println("plz enter brand");
            brandService.register();
        } else if (brandService.check() == 0 && categoryService.check() == 0) {
            System.out.println("plz enter brand and category");
            brandService.register();
            categoryService.register();
        } else System.out.println("brand and category exist");

        System.out.println("tables of the brand and category : ");
        brandService.loadAll();
        categoryService.loadAll();
        System.out.println("product registering");
        productService.register();

    }

    public void registerShareholder() throws SQLException {
        System.out.println("shareholder registering");
        shareholderService.register();
    }

    public void registerShareholderBrand() throws SQLException {
        System.out.println("shareholder and brand registering");
        shareholderBrandService.register();
    }

    public void editBrand() throws SQLException {
        System.out.println("brad editing");
        brandService.edit();
    }

    public void editCategory() throws SQLException {
        System.out.println("category editing");
        categoryService.edit();
    }

    public void editProduct() throws SQLException {
        System.out.println("product editing");
        productService.edit();
    }

    public void editShareholder() throws SQLException {
        System.out.println("shareholder editing");
        shareholderService.edit();
    }

    public void deleteBrand() throws SQLException {
        System.out.println("brand deleting");
        brandService.delete();
    }

    public void deleteCategory() throws SQLException {
        System.out.println("category deleting");
        categoryService.delete();
    }

    public void deleteProduct() throws SQLException {
        System.out.println("product deleting");
        productService.delete();
    }

    public void deleteShareholder() throws SQLException {
        System.out.println("shareholder deleting");
        shareholderService.delete();
    }

    public void deleteShareholderBrand()throws SQLException{
        System.out.println("shareholder and brand deleting");
        shareholderBrandService.delete();
    }
}
