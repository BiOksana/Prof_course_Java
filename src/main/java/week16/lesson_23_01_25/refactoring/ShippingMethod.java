package week16.lesson_23_01_25.refactoring;

public enum ShippingMethod {
    STANDARD(5.99),
    EXPRESS(9.99);


    private double price;

    ShippingMethod(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ShippingMethod{" +
                "price=" + price +
                '}';
    }
}
