package WheelOfFortue;

class SpinOutCome {

    protected Player player;

    protected Integer round;

    public SpinOutCome(Player player, int round) {
        this.player = player;
        this.round = round;
    }

    public Player getPlayer() {
        return player;
    }


    // DOLLAR_AMOUNT, LOSE_A_TURN, BANKRUPT, SOLVE_PUZZLE
}
class SpinOutComeLoseATurn extends SpinOutCome {
    public SpinOutComeLoseATurn(Player player, Integer round) {
        super(player, round);
    }

}