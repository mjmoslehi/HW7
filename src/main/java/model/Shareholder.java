package model;

public class Shareholder {
    private int id ;
    private String name;
    private String phoneNumber;
    private String nationalCode;
    public Shareholder(int id, String name, String phoneNumber, String nationalCode) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public Shareholder(String name, String phoneNumber, String nationalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

}
