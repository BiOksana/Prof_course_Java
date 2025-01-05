package week13.summarysession;

public class BankApp {
    public static void main(String[] args) {

        Bank bank = new Bank(1000, 1000);
        Thread thread1 = new Thread(() -> {
            bank.transferFromAccountTwoToAccountOne(300);
        });

        Thread thread2 = new Thread(() -> {
            bank.transferFromAccountOneToAccountTwo(500);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Account One = " + bank.getAccountOne());
        System.out.println("Account Two = " + bank.getAccountTwo());
        System.out.println("Total Amount = " + bank.getTotalAmount());
    }

}
