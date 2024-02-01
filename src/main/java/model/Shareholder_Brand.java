package model;

public class Shareholder_Brand {

    private int idShareholder;
    private int idBrand;

    public Shareholder_Brand(int idShareholder, int idBrand) {
        this.idShareholder = idShareholder;
        this.idBrand = idBrand;
    }


    public int getIdShareholder() {
        return idShareholder;
    }

    public void setIdShareholder(int idShareholder) {
        this.idShareholder = idShareholder;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    @Override
    public String toString() {
        return "Shareholder_Brand{" +
                "idShareholder=" + idShareholder +
                ", idBrand=" + idBrand +
                '}';
    }
}
