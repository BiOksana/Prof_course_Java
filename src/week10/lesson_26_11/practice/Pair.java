package week10.lesson_26_11.practice;

public class Pair<K, V> {

    private K elem1;
    private V elem2;

    public Pair(K elem1, V elem2) {
        this.elem1 = elem1;
        this.elem2 = elem2;
    }

    public K getElem1() {
        return elem1;
    }

    public void setElem1(K elem1) {
        this.elem1 = elem1;
    }

    public V getElem2() {
        return elem2;
    }

    public void setElem2(V elem2) {
        this.elem2 = elem2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "elem1=" + elem1 +
                ", elem2=" + elem2 +
                '}';
    }
}
