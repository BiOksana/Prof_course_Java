package lesson25092024.parentchildinit;

public class Child extends Parent {

    private String nonStaticValue;
    private static String staticValue;


    {
        System.out.println("Child non-static init block");
    }

    static {
        System.out.println("Child static init block");
    }

    public Child() {
        System.out.println("Parent constructor");
    }

    public void nonStaticMethod() {
        System.out.println("Child nonStaticMethod");
        System.out.println(this.nonStaticValue);
//        System.out.println(super.nonStaticValue);
        Parent.staticMethod();
    }

    public static void staticMethod() {
        System.out.println("Child staticMethod");
        System.out.println("staticValue = " + staticValue);
    }
}
