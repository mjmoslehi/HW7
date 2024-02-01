package utility;

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
}
