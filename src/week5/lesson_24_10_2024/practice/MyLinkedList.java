package week5.lesson_24_10_2024.practice;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class MyLinkedList {
    private int number;
    private MyLinkedList next;

    public MyLinkedList(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyLinkedList getNext() {
        return next;
    }

    public void setNext(MyLinkedList next) {
        this.next = next;
    }

    public boolean isCycled(MyLinkedList head) {
        MyLinkedList slow = head;
        MyLinkedList fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList(1);
        MyLinkedList l2 = new MyLinkedList(0);
        MyLinkedList l3 = new MyLinkedList(4);
        MyLinkedList l4 = new MyLinkedList(8);
        MyLinkedList l5 = new MyLinkedList(12);
        l1.setNext(l2);
        l2.setNext(l1);
        l3.setNext(l4);
        l4.setNext(l5);
//        l5.setNext(l3);

        System.out.println(l1.isCycled(l1));

    }
}
