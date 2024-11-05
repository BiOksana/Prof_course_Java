package week6.lesson_29_10.homework.bank_cards;

import java.util.Objects;

public class MasterCard extends Card {
    private int masterCardId;

    public MasterCard(int masterCardId) {
        this.masterCardId = masterCardId;
    }

    @Override
    public int getId() {
        return masterCardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterCard that = (MasterCard) o;
        return masterCardId == that.masterCardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterCardId);
    }

    @Override
    public String toString() {
        return "MasterCard{" +
                "masterCardId=" + masterCardId +
                '}';
    }
}
