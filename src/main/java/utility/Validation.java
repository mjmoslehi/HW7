package utility;

import java.util.regex.Pattern;

public class Validation {

    private static final Pattern USER_EMAIL_PATTERN;
    private static final Pattern USER_PASSWORD_PATTERN;
    private static final Pattern BRAND_WEBSITE_PATTERN;
    private static final Pattern SHAREHOLDER_PHONE_NUMBER_PATTERN;
    private static final Pattern SHAREHOLDER_NATIONAL_CODE_PATTERN;

    static {
        USER_EMAIL_PATTERN =Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]" +
                "+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" + ")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$",Pattern.CASE_INSENSITIVE);
        USER_PASSWORD_PATTERN =Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#!%&*])" +
                "[A-Za-z0-9@#!%&*]{8,10}$");
        BRAND_WEBSITE_PATTERN = Pattern.compile("<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]" +
                "*[-a-zA-Z0-9+&@#/%=~_|]>");
        SHAREHOLDER_PHONE_NUMBER_PATTERN =Pattern.compile("(0|\\+98)?([ ]|-|[()]){0,2}9[1|2|3|4]" +
                "([ ]|-|[()]){0,2}(?:[0-9]([ ]|-|[()]){0,2}){8}");
        SHAREHOLDER_NATIONAL_CODE_PATTERN =Pattern.compile("[0-9]{10}");
    }
}
