package WheelOfFortue;

class SpinOutComeProcessor {

    private Host host;

    private Player player;

    public SpinOutComeProcessor(Host host, Player player) {
        this.host = host;
        this.player = player;
    }

    public Host getHost() {
        return host;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean process() {
        return false;
    }
}
