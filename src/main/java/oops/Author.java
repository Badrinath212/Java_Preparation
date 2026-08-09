package oops;

public @interface Author {
    String name();
    String email();
    int version() default 1;
}