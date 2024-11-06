package week7.lesson_05_11.homework.my_stack;

public class MyStack {
    //    Реализовать стек на основе массива. Создать класс MyStack:
////public class MyStack {
////    private String[] data;
////}
////реализовать для него методы push(), pop(), peek(), size(), isEmpty().
////Размер стека определяется на этапе создания. При попытке добавить элемент в заполненный стек выбрасывается exception.
////Протестировать работу класса.
    private int arrayCapacity;
    private String[] data;
    private int size = 0;

    public MyStack(int arrayCapacity) {
        data = new String[arrayCapacity];
    }

    public void push(String data) {
        if (size >= this.data.length) {
            throw new RuntimeException("Can't add new element to the stack. Stack is full!");
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
