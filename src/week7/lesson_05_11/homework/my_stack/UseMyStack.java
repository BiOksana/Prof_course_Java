package week7.lesson_05_11.homework.my_stack;

public class UseMyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        System.out.println("myStack.isEmpty() = " + myStack.isEmpty());
        myStack.push("A");
        System.out.println("myStack.isEmpty() = " + myStack.isEmpty());
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        myStack.push("E");
        myStack.push("F");
        myStack.push("G");
        myStack.push("H");
        myStack.push("I");
        myStack.push("J");

        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack.peek() = " + myStack.peek());
        myStack.push("Z");
        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack.peek() = " + myStack.peek());
        int count = myStack.size();
        for (int i = 0; i < count; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println("myStack.isEmpty() = " + myStack.isEmpty());

    }
}
