package WheelOfFortue;

public class Player {
    public enum Choice
    {
        SPIN_WHEEL, BUY_VOWEL
    }

    private String name;
    private Account account;
    private Host host;

    public Player(String name, Account account, Host host)
    {
        this.name = name;
        this.account = account;
        this.host = host;
    }

    public Account account()
    {
        return account;
    }

    public void buyVowel()
    {
        host.giveVowel();
    }

    Choice makeChoice()
    {
        //TODO Logic for Player to make a choice
     return null;
    }

    public boolean guessConsonant()
    {
        //TODO Logic to get a users guess for consoant
        char guess = 'h';
        return host.uncoverConsonant(guess);
    }

    public Wheel.SpinResult spinWheel(Wheel wheel)
    {
        return wheel.spin();
    }

//    public SpinOutCome spinWheel(Wheel wheel, int round)
//    {
//        //TODO LOGIC FOR SPIN OUTCOME, CALL DOLLAR RESULT OR SOMETHING
//
//        return SpinOutCome(wheel, round);
//    }

    public String solvePuzzle()
    {
        //TODO Logic for this to actually solve the puzzle
        return null;
    }


    public void giveToHost(Wheel.SpinResult spinResult)
    {
         host.doWhatsNeccessaryWith(this, spinResult);
    }

    public boolean solveWith(CharSequence solution)
    {
        return host.solveWith(solution);
    }

    public void acceptCashGift(int amount)
    {
        account.debit(amount);
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return String.format("[name=%s, account=%s}", name, account);
    }

}
