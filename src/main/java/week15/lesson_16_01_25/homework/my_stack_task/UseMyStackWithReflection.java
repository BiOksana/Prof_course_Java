package week15.lesson_16_01_25.homework.my_stack_task;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UseMyStackWithReflection {
    /*
    Через рефлексию:
вызвать методы push() и pop() на существующем объекте,
создать экземпляр класса,
добавить шестой элемент "F" в уже заполненный стек из пяти элементов:

     */
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        MyStack stack = new MyStack(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        Class<? extends MyStack> stackClass = stack.getClass();

        Method popMethod = stackClass.getDeclaredMethod("pop");
        popMethod.setAccessible(true);
        String deletedString = (String) popMethod.invoke(stack);
        System.out.println(deletedString);

        Method pushMethod = stackClass.getDeclaredMethod("push", String.class);
        pushMethod.setAccessible(true);
        pushMethod.invoke(stack, "F");

        System.out.println(stack);

        MyStack newInstance = (MyStack)Class.forName(stackClass.getName())
                .getConstructor(int.class).newInstance(3);
        pushMethod.invoke(newInstance, "F");
        System.out.println(newInstance.size());
        System.out.println(newInstance);
    }
}
