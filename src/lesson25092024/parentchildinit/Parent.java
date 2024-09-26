package lesson25092024.parentchildinit;

public class Parent {
    private String nonStaticValue;
    private static String staticValue;

    {
        System.out.println("Parent non-static init block");
    }

    static {
        System.out.println("Parent static init block");
    }

    public Parent() {
        System.out.println("Parent constructor");
    }

    public void nonStaticMethod() {
        System.out.println("Parent nonStaticMethod");
        System.out.println("nonStaticValue = " + nonStaticValue);
    }

    public static void staticMethod() {
        System.out.println("Parent staticMethod");
        System.out.println("staticValue = " + staticValue);
    }
}
