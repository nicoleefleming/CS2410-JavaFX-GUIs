package WheelOfFortue;

public class Account {

    private int amount;

    public Account ()
    {
        this.amount = 0;
    }
    public Account(int amount) {
        this.amount = amount;
    }

    public int credit(int amount) {
        return this.amount += amount;
    }

    public int debit(int amount) {
        return this.amount -= amount;
    }

    public int amount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("[amount=%d]", amount);
    }

} // Account