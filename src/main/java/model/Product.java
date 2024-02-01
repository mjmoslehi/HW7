package model;

import java.sql.Date;

public class Product {
    private int id ;
    private String name;
    private Date createDate;
    private int categoryId;
    private int brandId;

    public Product(int id, String name, Date createDate, int categoryId, int brandId) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public Product(String name, Date createDate, int categoryId, int brandId) {
        this.name = name;
        this.createDate = createDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
