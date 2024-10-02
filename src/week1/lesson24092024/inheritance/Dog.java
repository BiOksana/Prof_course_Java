package week1.lesson24092024.inheritance;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    public void gav() {
        System.out.println("Gav! Gav!");
    }

//    @Override
//    public void introduce() {
//        gav();
//        super.introduce();
//    }


    @Override
    public void introduce() {
        System.out.println("Hello!" + " I'm animal - " + this.getClass().getSimpleName() + ". My name is " + getName());
    }
}
