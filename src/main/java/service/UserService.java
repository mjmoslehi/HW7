package service;

import model.User;
import repository.UserRepository;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register() throws SQLException {
        System.out.println("enter name :");
        String name =scanner.nextLine();

        System.out.println("enter user name :");
        String userName = scanner.nextLine();

        String email = getUserEmail();
        String password = getUserPassword();

        User user = new User(name,userName,email,password);
        userRepository.register(user);
        System.out.println(user);

    }

    private String getUserEmail (){
        String email;
        while (true){
            System.out.println("enter email :");
            email = scanner.nextLine();
            if(Validation.isValidEmail(email))break;
            else System.out.println("email is not valid");
        }
        return email;
    }

    private String getUserPassword (){
        String password ;
        while (true){
            System.out.println("enter password :");
            password =scanner.nextLine();
            if (Validation.isValidPassword(password)) break;
            else System.out.println("password is not valid");
        }
        return password;
    }

}
