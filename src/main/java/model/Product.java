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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                '}';
    }
}
