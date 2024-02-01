package service;

import model.Product;
import repository.ProductRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class ProductService {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void register() throws SQLException, ParseException {

        System.out.println("product name :");
        String name = scanner.next();

        System.out.println("product create data :");
        String createDate = scanner.next();
        Date date =java.sql.Date.valueOf(createDate);

        System.out.println("product category id :");
        int categoryId = scanner.nextInt();

        System.out.println("product brand id :");
        int brandId = scanner.nextInt();

        Product product = new Product(name, date,categoryId,brandId);
        productRepository.register(product);
        System.out.println(product);
    }

    private Product load(int id) throws SQLException {
        Product product = productRepository.load(id);
        return product;
    }

    public void edit() throws SQLException {

        System.out.println("edit product id :");
        int id = scanner.nextInt();
        Product product = load(id);

        System.out.println("edit product name :");
        String name = scanner.next();
        product.setName(name);

        System.out.println("edit product date :");
        String createDate = scanner.next();
        Date date =java.sql.Date.valueOf(createDate);
        product.setCreateDate(date);


        System.out.println("edit product category id :");
        int categoryId = scanner.nextInt();
        product.setCategoryId(categoryId);

        System.out.println("edit product brand id :");
        int brandId = scanner.nextInt();
        product.setBrandId(brandId);

        productRepository.edit(product);
        System.out.println(product);

    }

    public void delete() throws SQLException {

        System.out.println("enter id that you want delete :");
        int id = scanner.nextInt();
        Product product = load(id);
        productRepository.delete(product);
        System.out.println(product);
    }

}
