package week14.lesson_09_01_25.homework.bankaccount;

public class AccountManager {
    private BankAccount bankAccount;


    public AccountManager(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public synchronized void moveMoneyAToB(int amount) {
            bankAccount.setAccountA(bankAccount.getAccountA() - amount);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bankAccount.setAccountB(bankAccount.getAccountB() + amount);
    }

    public synchronized BankAccount getBankAccount() {
            return new BankAccount(bankAccount.getAccountA(), bankAccount.getAccountB());
    }
}
