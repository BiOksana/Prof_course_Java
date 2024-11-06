package week7.lesson_05_11.homework.customer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CustomerApp {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Vasya", "allyn.walker@hotmail.com", 36, true);
        Customer customer2 = new Customer("Dominique", "larraine.hartmann@gmail.com", 87, true);
        Customer customer3 = new Customer("Ressie", "michale.roob@gmail.com", 3000, true);
        Customer customer4 = new Customer("Randal", "granville.collins@gmail.com", 769, true);
        Customer customer5 = new Customer("Mckenzie", "le.hand@gmail.com", 0, false);
        Customer customer6 = new Customer("Blair", "malcom.toy@hotmail.com", 150, true);
        Customer customer7 = new Customer("Benito", "brenton.goldner@gmail.com", 200, true);
        Customer customer8 = new Customer("Bennie", "joanie.walter@yahoo.com", 100, true);
        Customer customer9 = new Customer("Spencer", "reggie.rosenbaum@gmail.com", 0, false);
        Customer customer10 = new Customer("Spencer", "reggie.rosenbaum@gmail.com", 0, false);
        Customer customer11 = new Customer("Ariel", "aide.borer@yahoo.com", 300, true);
        Customer customer12 = new Customer("Vince", "taina.rolfson@hotmail.com", 100, false);
        Customer customer13 = new Customer("Vince", "taina.rolfson@hotmail.com", 100, true);

        Set<Customer> customerHashSet = new HashSet<>(List.of(customer1, customer2, customer3, customer4, customer5,
                customer6, customer7, customer8, customer9, customer10, customer11, customer12, customer13));
        System.out.println("customerSet.size() = " + customerHashSet.size());
        for (Customer customer : customerHashSet) {
            System.out.println(customer);
        }

        Set<Customer> customerTreeSet = new TreeSet<>(List.of(customer1, customer2, customer3, customer4, customer5,
                customer6, customer7, customer8, customer9, customer10, customer11, customer12, customer13));
        System.out.println("customerTreeSet.size() = " + customerTreeSet.size());
        for (Customer customer : customerTreeSet) {
            System.out.println(customer);
        }
    }
}
