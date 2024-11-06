package week7.lesson_05_11.homework.customer;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
//  Реализовать для класса Customer возможность добавления в TreeSet, HashSet. Проверить, правильно ли добавляется.
    private String name;
    private String email;
    private int bonusAmount;
    private boolean isEmailConfirmed;

    public Customer(String name, String email, int bonusAmount, boolean isEmailConfirmed) {
        this.name = name;
        this.email = email;
        this.bonusAmount = bonusAmount;
        this.isEmailConfirmed = isEmailConfirmed;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }

    public boolean isEmailConfirmed() {
        return isEmailConfirmed;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bonusAmount=" + bonusAmount +
                ", isEmailConfirmed=" + isEmailConfirmed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return bonusAmount == customer.bonusAmount && isEmailConfirmed == customer.isEmailConfirmed && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, bonusAmount, isEmailConfirmed);
    }

    @Override
    public int compareTo(Customer another) {
        int result = this.name.compareTo(another.name);
        if (result == 0) {
            result = this.email.compareTo(another.email);
        }
        if (result == 0) {
            result = Integer.compare(this.bonusAmount, another.bonusAmount);
        }
        if (result == 0) {
            result = Boolean.compare(this.isEmailConfirmed, another.isEmailConfirmed);
        }
        return result;
    }
}
