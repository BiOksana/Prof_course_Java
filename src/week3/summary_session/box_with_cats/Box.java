package week3.summary_session.box_with_cats;

public class Box {

    private String name;
    private boolean canBeSold;
    private int count;
    private Cat cat;

    public Box(String name, boolean canBeSold, int count, Cat cat) {
        this.name = name;
        this.canBeSold = canBeSold;
        this.count = count;
        this.cat = cat;
    }

    public void empty() {
        this.count = 0;
        this.cat = null;
    }

    public Box makeCopy() {

        return new Box(this.name, this.canBeSold, this.count, this.cat);
    }

    public Box deepCopy() {
        Cat copiedCat = new Cat(this.cat.getName(), this.cat.getAge(), this.cat.getColour());
        return new Box(name, canBeSold, count, copiedCat);
    }

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", canBeSold=" + canBeSold +
                ", count=" + count +
                ", cat=" + cat +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanBeSold() {
        return canBeSold;
    }

    public void setCanBeSold(boolean canBeSold) {
        this.canBeSold = canBeSold;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
