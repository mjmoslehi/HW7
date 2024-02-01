package service;

import model.Shareholder;
import repository.ShareholderRepository;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {
    private final Scanner scanner = new Scanner(System.in);
    private final ShareholderRepository shareholderRepository;

    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    public void register ()throws SQLException {

        System.out.println("enter name :");
        String name = scanner.next();

        String phoneNumber = getPhoneNumber();

        String nationalCode =getNationalCode();

        Shareholder shareholder = new Shareholder(name , phoneNumber ,nationalCode);
        shareholderRepository.register(shareholder);
        System.out.println(shareholder);

    }

    private String getPhoneNumber (){
        String phoneNumber ;
        while(true){
            System.out.println("enter phone number :");
            phoneNumber =scanner.nextLine();
            if (Validation.isValidPhoneNumber(phoneNumber))break;
            else System.out.println("phone number is not valid");
        }
        return phoneNumber;
    }

    private String getNationalCode (){
        String nationalCode ;
        while(true){
            System.out.println("enter national code :");
            nationalCode =scanner.nextLine();
            if (Validation.isValidNationalCode(nationalCode))break;
            else System.out.println("national code is not valid");
        }
        return nationalCode;
    }

    private Shareholder load (int id)throws SQLException{
        Shareholder shareholder = shareholderRepository.load(id);
        return shareholder;
    }

    public void edit ()throws SQLException{
        System.out.println("enter shareholder id :");
        int id = scanner.nextInt();
        Shareholder shareholder = load(id);

        System.out.println("enter shareholder name :");
        String name = scanner.next();
        shareholder.setName(name);

        System.out.println("enter shareholder phone number :");
        String phoneNumber = scanner.next();
        shareholder.setPhoneNumber(phoneNumber);

        System.out.println("enter shareholder national code :");
        String nationalCode = scanner.next();
        shareholder.setNationalCode(nationalCode);

        shareholderRepository.edit(shareholder);
        System.out.println(shareholder);
    }


    public void delete()throws SQLException{
        System.out.println("enter id that you want to delete :");
        int id = scanner.nextInt();
        Shareholder shareholder = load(id);
        shareholderRepository.delete(shareholder);
        System.out.println(shareholder);
    }

}
