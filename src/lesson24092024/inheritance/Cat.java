package lesson24092024.inheritance;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.println("Meow!");
    }

//    @Override
//    public void introduce() {
//        meow();
////        System.out.println("Hello! I'm cat");
//        super.introduce();
//    }


    @Override
    public void introduce() {
        System.out.println("Hello!" + " I'm animal - " + this.getClass().getSimpleName() + ". My name is " + getName());
    }
}