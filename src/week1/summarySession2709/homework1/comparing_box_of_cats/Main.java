package week1.summarySession2709.homework1.comparing_box_of_cats;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Vasya", 1);
        Cat cat2 = new Cat("Vasya", 1);
//        Box box1 = new Box(cat1);
//        Box box2 = new Box(cat2);
//        System.out.println(box1.equals(box2));
//        System.out.println(cat1.hashCode());
//        System.out.println(cat2.hashCode());
//        System.out.println(box1.hashCode());
//        System.out.println(box2.hashCode());

        Cat cat3 = new BlackCat("Vasya", 1);
        BlackCat blackCat = (BlackCat) cat3;
//        System.out.println(cat3);
//        System.out.println(BlackCat);
        System.out.println(cat1.equals(cat2));
        System.out.println(cat1.equals(cat3));
        System.out.println(cat3.equals(cat1));
        System.out.println(cat3.equals(blackCat));
        System.out.println(blackCat.equals(cat3));
//        System.out.println(cat1.getClass());
//        System.out.println(cat3.getClass());
    }
}
