package service;

import model.Shareholder_Brand;
import repository.Shareholder_brandRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Shareholder_brandService {
    private final Scanner scanner = new Scanner(System.in);
    private final Shareholder_brandRepository shareholderBrandRepository ;

    public Shareholder_brandService(Shareholder_brandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository = shareholderBrandRepository;
    }

    public void register()throws SQLException {
        System.out.println("enter shareholder id :");
        int shareholderId = scanner.nextInt();

        System.out.println("enter brand id :");
        int brandId = scanner.nextInt();

        Shareholder_Brand shareholderBrand = new Shareholder_Brand(shareholderId,brandId);
        shareholderBrandRepository.register(shareholderBrand);
        System.out.println(shareholderBrand);
    }

    private Shareholder_Brand load(int id) throws SQLException {
        Shareholder_Brand shareholderBrand = shareholderBrandRepository.load(id);
        return shareholderBrand;
    }

    public void delete() throws SQLException {

        System.out.println("enter id that you want delete :");
        int id = scanner.nextInt();
        Shareholder_Brand shareholderBrand = load(id);
        shareholderBrandRepository.delete(shareholderBrand);
        System.out.println(shareholderBrand);
    }

}
