package service;

import model.Brand;
import repository.BrandRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {
    private final Scanner scanner = new Scanner(System.in);
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void register() throws SQLException {

        System.out.println("brand name :");
        String name = scanner.next();

        String website = getBrandWebsite();

        System.out.println("brand description :");
        String description = scanner.next();

        Brand brand = new Brand(name, website, description);
        brandRepository.registerBrand(brand);
        System.out.println(brand);
    }
}
