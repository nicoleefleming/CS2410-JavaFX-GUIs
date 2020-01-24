package WheelOfFortue;

public class Wheel {
    public enum SpinResultType{
        CASH, LOSE_A_TURN, BANKRUPT, SOLVE_PUZZLE
    }

    public SpinResult spin()
    {
        //TODO calculate random spin result
        return new SpinResult(SpinResultType.CASH, 100);
    }

    public class SpinResult{

        private SpinResultType type;
        private int amount;

        public SpinResult(SpinResultType type)
        {
            this(type, 0);
        }

        public SpinResult(SpinResultType result, int amount)
        {
            this.type = result;
            this.amount = amount;
        }

        public SpinResultType type()
        {
            return type;
        }

        public int amount()
        {
            return amount;
        }

        @Override
        public String toString()
        {
            return String.format("{type=%s, amount=%s}", type, amount);
        }

    }//end SpinResult

}//Wheel
