package service;

import model.Brand;
import repository.BrandRepository;
import utility.Validation;

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

    private String getBrandWebsite(){

        String website;
        while (true){
            System.out.println("enter brand website :");
            website=scanner.nextLine();
            if (Validation.isValidWebsite(website))break;
            else System.out.println("website is not valid");
        }
        return website;
    }

    private Brand load(int id) throws SQLException {
        Brand brand = brandRepository.load(id);
        return brand;
    }

    public void edit() throws SQLException {

        System.out.println("edit brand id :");
        int id = scanner.nextInt();
        Brand brand = load(id);

        System.out.println("edit brand name :");
        String name = scanner.next();
        brand.setName(name);

        System.out.println("edit brand website :");
        String website = scanner.next();
        brand.setWebsite(website);

        System.out.println("edit brand description :");
        String description = scanner.next();
        brand.setDescription(description);

        brandRepository.edit(brand);
        System.out.println(brand);

    }

    public void delete() throws SQLException {

        System.out.println("enter id that you want delete :");
        int id = scanner.nextInt();
        Brand brand = load(id);
        brandRepository.delete(brand);
        System.out.println(brand);
    }
}
