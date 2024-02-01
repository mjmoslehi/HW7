package model;

public class Brand {
    private int id ;
    private String name ;
    private String website;
    private String description;

    public Brand(String name, String website, String description) {
        this.name = name;
        this.website = website;
        this.description = description;
    }

    public Brand(int id , String name, String website, String description) {
        this.id =id;
        this.name = name;
        this.website = website;
        this.description = description;
    }
}
