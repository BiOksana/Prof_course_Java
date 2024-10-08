package week1.summarySession2709.homework1.comparing_box_of_cats;

import java.util.Objects;

public class Box {
    private Cat cat;

    public Box(Cat cat) {
        this.cat = cat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Box) {
            Box anotherBox = (Box) obj;
            return Objects.equals(this.cat, anotherBox.cat);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(cat);
    }
}
