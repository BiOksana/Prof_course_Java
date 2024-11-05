package week6.lesson_29_10.homework.bank_cards;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BankCardAccountingSystem {
    //Имеются банковские карты разных платежных систем:
//public class MasterCard {
//private int masterCardId;
//}
//public class Visa {
//    private int visaId;
//}
//Реализовать возможность их хранения в общем TreeSet.
    public static void main(String[] args) {
        MasterCard masterCard1 = new MasterCard(16);
        MasterCard masterCard2 = new MasterCard(6);
        MasterCard masterCard3 = new MasterCard(1);
        Visa visa1 = new Visa(2);
        Visa visa2 = new Visa(23);
        Visa visa3 = new Visa(12);

        Set<Card> bankCardsSet = new TreeSet<>(List.of(masterCard1, masterCard2, masterCard3, visa1, visa2, visa3));
        for (Card card : bankCardsSet) {
            System.out.println(card);
        }
    }
}
