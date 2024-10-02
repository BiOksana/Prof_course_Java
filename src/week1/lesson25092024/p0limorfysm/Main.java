package week1.lesson25092024.p0limorfysm;

public class Main {
    public static void main(String[] args) {
        Parent link;

        boolean condition = true;
        if (condition) {
            link = new Parent();
        } else {
            link = new Child();
        }
        link.method();
        Object object = "string";
        object = 123;
        object = new Child();
        Child child = (Child) object; //unsave
        child.method();

        Parent parent = child;        //save

//        link = new Parent();
//        link.method();
//
//
//
//        link = new Child();
//        link.method();
    }
}
