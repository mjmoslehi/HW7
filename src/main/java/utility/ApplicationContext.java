package utility;

import connection.JdbcConnection;
import repository.*;
import service.*;

import java.sql.Connection;

public class ApplicationContext {
    private static final Connection CONNECTION;

    private static final BrandRepository BRAND_REPOSITORY;
    private static final CategoryRepository CATEGORY_REPOSITORY;
    private static final ProductRepository PRODUCT_REPOSITORY;
    private static final Shareholder_brandRepository SHAREHOLDER_BRAND_REPOSITORY;
    private static final ShareholderRepository SHAREHOLDER_REPOSITORY;
    private static final UserRepository USER_REPOSITORY;

    private static final BrandService BRAND_SERVICE;
    private static final CategoryService CATEGORY_SERVICE;
    private static final ProductService PRODUCT_SERVICE;
    private static final Shareholder_brandService SHAREHOLDER_BRAND_SERVICE;
    private static final ShareholderService SHAREHOLDER_SERVICE;
    private static final UserService USER_SERVICE;

    static {
        CONNECTION = JdbcConnection.getConnection();

        BRAND_REPOSITORY =new BrandRepository(CONNECTION);
        CATEGORY_REPOSITORY =new CategoryRepository(CONNECTION);
        PRODUCT_REPOSITORY =new ProductRepository(CONNECTION);
        SHAREHOLDER_BRAND_REPOSITORY =new Shareholder_brandRepository(CONNECTION);
        SHAREHOLDER_REPOSITORY =new ShareholderRepository(CONNECTION);
        USER_REPOSITORY = new UserRepository(CONNECTION);

        BRAND_SERVICE = new BrandService(BRAND_REPOSITORY);
        CATEGORY_SERVICE =new CategoryService(CATEGORY_REPOSITORY);
        PRODUCT_SERVICE =new ProductService(PRODUCT_REPOSITORY);
        SHAREHOLDER_BRAND_SERVICE = new Shareholder_brandService(SHAREHOLDER_BRAND_REPOSITORY);
        SHAREHOLDER_SERVICE = new ShareholderService(SHAREHOLDER_REPOSITORY);
        USER_SERVICE = new UserService(USER_REPOSITORY);

    }

    public static BrandService getBrandService(){return BRAND_SERVICE;}
    public static CategoryService getCategoryService(){return CATEGORY_SERVICE;}
    public static ProductService getProductService(){return PRODUCT_SERVICE;}
    public static Shareholder_brandService getShareholderBrandService(){return SHAREHOLDER_BRAND_SERVICE;}
    public static ShareholderService getShareholderService(){return SHAREHOLDER_SERVICE;}
    public static UserService getUserService() {return USER_SERVICE;}
}
