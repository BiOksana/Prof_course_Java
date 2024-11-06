package week7.lesson_05_11.homework.my_stack;

import java.util.Arrays;

public class MyStackBasedOnDynamicArray {

    private static final int ARRAY_CAPACITY = 10;
    private String[] data = new String[ARRAY_CAPACITY];

    private int size = 0;

    public void push(String data) {
        if (size >= this.data.length) {
            grow();
        }
        this.data[size] = data;
        size++;
    }

    public String peek() {
        return size > 0 ? data[size - 1] : null;
    }

    public String pop() {
        if (size < 0) {
            return null;
        }
        String elemToDelete = peek();
        this.data[size - 1] = null;
        size--;
        return elemToDelete;
    }

    private void grow() {
        String[] newData = Arrays.copyOf(data, data.length * 2);
        this.data = newData;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        MyStackBasedOnDynamicArray myStackBasedOnDynamicArray = new MyStackBasedOnDynamicArray();
        System.out.println("myStackBasedOnDynamicArray.isEmpty() = " + myStackBasedOnDynamicArray.isEmpty());
        myStackBasedOnDynamicArray.push("A");
        System.out.println("myStackBasedOnDynamicArray.isEmpty() = " + myStackBasedOnDynamicArray.isEmpty());
        myStackBasedOnDynamicArray.push("B");
        myStackBasedOnDynamicArray.push("C");
        myStackBasedOnDynamicArray.push("D");
        myStackBasedOnDynamicArray.push("E");
        myStackBasedOnDynamicArray.push("F");
        myStackBasedOnDynamicArray.push("G");
        myStackBasedOnDynamicArray.push("H");
        myStackBasedOnDynamicArray.push("I");
        myStackBasedOnDynamicArray.push("J");

        System.out.println("myStackBasedOnDynamicArray.size() = " + myStackBasedOnDynamicArray.size());
        System.out.println("myStackBasedOnDynamicArray.peek() = " + myStackBasedOnDynamicArray.peek());
        myStackBasedOnDynamicArray.push("Z");
        System.out.println("myStackBasedOnDynamicArray.size() = " + myStackBasedOnDynamicArray.size());
        System.out.println("myStackBasedOnDynamicArray.peek() = " + myStackBasedOnDynamicArray.peek());
        int count = myStackBasedOnDynamicArray.size();
        for (int i = 0; i < count; i++) {
            System.out.println(myStackBasedOnDynamicArray.pop());
        }
        System.out.println("myStackBasedOnDynamicArray.isEmpty() = " + myStackBasedOnDynamicArray.isEmpty());
    }
}
