package week7.lesson_07_11.homework.customer_example;


import java.util.*;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Vasya", "allyn.walker@hotmail.com", "Italy", 36, true);
        Customer customer2 = new Customer("Dominique", "larraine.hartmann@gmail.com", "Germany", 87, true);
        Customer customer3 = new Customer("Ressie", "michale.roob@gmail.com", "Germany", 3000, true);
        Customer customer4 = new Customer("Randal", "granville.collins@gmail.com", "Great Britain", 769, true);
        Customer customer5 = new Customer("Mckenzie", "le.hand@gmail.com", "Spain", 0, false);
        Customer customer6 = new Customer("Blair", "malcom.toy@hotmail.com", "Spain", 150, true);
        Customer customer7 = new Customer("Benito", "brenton.goldner@gmail.com", "Spain", 200, true);
        Customer customer8 = new Customer("Bennie", "joanie.walter@yahoo.com", "Germany", 100, true);
        Customer customer9 = new Customer("Spencer", "reggie.rosenbaum@gmail.com", "Great Britain", 0, false);
        Customer customer10 = new Customer("Spencer", "reggie.rosenbaum@gmail.com", "Germany", 0, false);
        Customer customer11 = new Customer("Ariel", "aide.borer@yahoo.com", "Great Britain", 300, true);
        Customer customer12 = new Customer("Vincent", "taina.rolfson@hotmail.com", "Italy", 100, false);
        Customer customer13 = new Customer("Vince", "taina.rolfson@hotmail.com", "Italy", 100, true);

        List<Customer> customers = new ArrayList<>(List.of(customer1, customer2, customer3, customer4, customer5,
                customer6, customer7, customer8, customer9, customer10, customer11, customer12, customer13));

        //a. Получить Map email / страна

        Map<String, String> emailCountryMap = new HashMap<>();
        for (Customer customer : customers) {
            emailCountryMap.put(customer.getEmail(), customer.getCountry());
        }
        System.out.println("emailCountryMap.size() = " + emailCountryMap.size());
        System.out.println("emailCountryMap = " + emailCountryMap);

        //b. Получить Map email / покупатель

        Map<String, Customer> emailAndCustomerMap = new HashMap<>();
        for (Customer customer : customers) {
            emailAndCustomerMap.put(customer.getEmail(), customer);
        }
        System.out.println("emailAndCustomerMap.size() = " + emailAndCustomerMap.size());
        System.out.println("emailAndCustomerMap = " + emailAndCustomerMap);

        //c. Получить Map isEmailConfirmed / количество подтвержденных и неподтвержденных email
        Map<Boolean, Integer> confirmedUnconfirmedEmailMap = new HashMap<>();
        int count = 0;
        for (Customer customer : customers) {
            confirmedUnconfirmedEmailMap.put(customer.isEmailConfirmed(), confirmedUnconfirmedEmailMap.getOrDefault(customer.isEmailConfirmed(), 0) + 1);
        }

        System.out.println("confirmedUnconfirmedEmailMap = " + confirmedUnconfirmedEmailMap);

        //d. Получить Map> страна / список покупателей из данной страны
        Map<String, List<Customer>> countryToCustomersMap = new HashMap<>();
        for (Customer customer : customers) {
            List<Customer> customerList = countryToCustomersMap.getOrDefault(customer.getCountry(), new ArrayList<>());
            customerList.add(customer);
            countryToCustomersMap.put(customer.getCountry(), customerList);
        }

        System.out.println("countryToCustomersMap = " + countryToCustomersMap);

        //e. Получить Map страна / суммарный накопленный бонус покупателей из данной страны
        Map<String, Integer> countryToTotalBonusMap = new HashMap<>();
        for (Customer customer : customers) {
            countryToTotalBonusMap.put(customer.getCountry(), countryToTotalBonusMap.getOrDefault(customer.getCountry(), 0) + customer.getBonusAmount());
        }
        System.out.println("countryToTotalBonusMap = " + countryToTotalBonusMap);

    }
}
