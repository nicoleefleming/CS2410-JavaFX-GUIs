package WheelOfFortue;

public class DollarOutcome extends SpinOutCome {

    private Integer dollarAmount;

    public DollarOutcome(Player player, int dollarAmount, Integer round) {
        super(player, round);
        this.dollarAmount = dollarAmount;
    }

    public Integer getAmount() {
        return dollarAmount;
    }

}
