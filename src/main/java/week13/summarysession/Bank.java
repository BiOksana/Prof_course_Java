package week13.summarysession;

public class Bank {
    //3. В банке имеется два счета. Реализовать потокобезопасным способом:
//   - перевод денег со счета A на счет Б
//   - извлечение информации о сумме счета A и счета Б
//   - извлечение общей суммы на двух счетах
    private int accountOne;
    private int accountTwo;

    private Object monitor = new Object();

    public Bank(int accountOne, int accountTwo) {
        this.accountOne = accountOne;
        this.accountTwo = accountTwo;
    }

    public int getAccountOne() {
        synchronized (monitor) {
            return accountOne;
        }
    }

    public int getAccountTwo() {
        synchronized (monitor) {
            return accountTwo;
        }
    }


    public void transferFromAccountTwoToAccountOne(int count) {
        synchronized (monitor) {
            if (accountTwo >= count) {
                accountOne += count;
                accountTwo -= count;
                System.out.println(Thread.currentThread().getName() + ": Transaction is successful");
                System.out.println(Thread.currentThread().getName() + ": There are " + getAccountOne() + " Euro on the accountOne");
                System.out.println(Thread.currentThread().getName() + ": There are " + getAccountTwo() + " Euro on the accountTwo");
            } else {
                System.out.println("There is not enough money on the accountTwo to make the transaction");
            }
        }
    }

    public void transferFromAccountOneToAccountTwo(int count) {
        synchronized (monitor) {
            if (accountOne >= count) {
                accountOne -= count;
                accountTwo += count;
                System.out.println(Thread.currentThread().getName() + ": Transaction is successful");
                System.out.println(Thread.currentThread().getName() + ": There are " + getAccountTwo() + " Euro on the accountTwo");
                System.out.println(Thread.currentThread().getName() + ": There are " + getAccountOne() + " Euro on the accountOne");
            } else {
                System.out.println(Thread.currentThread().getName() + ": There is not enough money on the accountOne to make the transaction");
            }
        }
    }

    public int getTotalAmount() {
        synchronized (monitor) {
            return accountOne + accountTwo;
        }
    }

}
