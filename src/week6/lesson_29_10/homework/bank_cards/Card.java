package week6.lesson_29_10.homework.bank_cards;

public abstract class Card implements Comparable<Card> {

public abstract int getId();

    @Override
    public int compareTo(Card another) {
        return Integer.compare(this.getId(), another.getId());
    }
}
