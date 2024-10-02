package week1.summarySession2709.homework1.comparing_box_of_cats;

import java.util.Objects;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }


//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null || obj.getClass() != getClass()) {
//            return false;
//        }
//            Cat anotherCat = (Cat) obj;
//
////        if (Objects.equals(this.name, anotherCat.name) && this.age == anotherCat.age) {
////            return true;
////        } else {
////            return false;
////        }
//       return this.age == anotherCat.age &&
//               ((this.name == null && anotherCat.name == null) ||
//                       (this.name != null && this.name.equals(anotherCat.name)));
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat) {
            Cat anotherCat = (Cat) obj;
            return this.age == anotherCat.age &&
                    ((this.name == null && anotherCat.name == null) ||
                            (this.name != null && this.name.equals(anotherCat.name)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
