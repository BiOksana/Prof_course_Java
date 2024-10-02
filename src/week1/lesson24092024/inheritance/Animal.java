package week1.lesson24092024.inheritance;

public abstract class Animal {

    private String name;

    private int age;

    private boolean isHungry = true;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    //    public void introduce() {
//        System.out.println("Hello!" + " I'm animal" + " My name is " + name);
//    }

    public abstract void introduce();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isHungry=" + isHungry +
                '}';
    }
}
