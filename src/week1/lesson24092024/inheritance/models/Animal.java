package week1.lesson24092024.inheritance.models;

public abstract class Animal extends Creature {

    private int age;

    private boolean isHungry = true;

    public Animal(String name, int age) {
        super(name);
        this.age = age;
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


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + getName() + '\'' +
                ", age=" + age +
                ", isHungry=" + isHungry +
                '}';
    }
}
