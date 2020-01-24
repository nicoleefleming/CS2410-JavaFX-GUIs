package WheelOfFortue;

import java.util.List;

class DollarAmountSpinOutcomeProcessor extends SpinOutComeProcessor {

    private DollarOutcome dollarSpinOutCome;

    public DollarAmountSpinOutcomeProcessor(Host host, DollarOutcome dollarSpinOutCome) {
        super(host, dollarSpinOutCome.getPlayer());
        this.dollarSpinOutCome = dollarSpinOutCome;
    }
    public class DollarAmoutSpinOutcome extends DollarAmountSpinOutcomeProcessor{

        public DollarAmoutSpinOutcome(Host host, DollarOutcome dollarOutcome)
        {
            super(host, dollarOutcome);

        }

        public boolean process() {
            boolean isTurnOver;
            char getIt = 't';

            boolean character = getPlayer().guessConsonant();//TODO make a choice in player for guessing consonant
            List<Integer> characterOccurences = getHost().getCharacterOccurences(getIt);
            if (characterOccurences.size() > 0) {
                getPlayer().acceptCashGift(dollarSpinOutCome.getAmount() * characterOccurences.size());
                getHost().uncoverConsonent(characterOccurences);
                isTurnOver = false;
            }
            else {
                isTurnOver = true;
            }
            return isTurnOver;
        }
    }
}
