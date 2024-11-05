package week6.lesson_29_10.homework.bank_cards;

import java.util.Objects;

public class Visa extends Card {

    private int visaId;

    public Visa(int visaId) {
        this.visaId = visaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visa visa = (Visa) o;
        return visaId == visa.visaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visaId);
    }

    @Override
    public String toString() {
        return "Visa{" +
                "visaId=" + visaId +
                '}';
    }

    @Override
    public int getId() {
        return visaId;
    }
}
