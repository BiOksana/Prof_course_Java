package week10.lesson_26_11.practice;

public class MyNumber implements MyComparable<MyNumber> {
    private Number myNumber;

    public MyNumber(Number myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public String toString() {
        return "MyNumber{" +
                "myNumber=" + myNumber +
                '}';
    }

    @Override
    public int compareTo(MyNumber o) {
        if (myNumber.floatValue() > o.myNumber.floatValue()) {
            return 1;
        } else if (myNumber.floatValue() < o.myNumber.floatValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}

