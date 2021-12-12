package OReilly.RealWorld.Software.Development.businessRules;

public class DealValueAction implements Action{

    @Override
    public void perform(Facts facts) {
        Stage dealStage = Stage.valueOf(facts.getFact("stage"));
        double amount = Double.parseDouble(facts.getFact("amount"));
        double forecastedAmount = amount * switch(dealStage){
            case LEAD -> 0.2;
            case INTERESTED ->  0.5;
            case EVALUATING ->  0.8;
            case CLOSED ->  1;
        };

        facts.setFact("forecastedAmount", String.valueOf(forecastedAmount));
        System.out.println("Forecasted amount is " + forecastedAmount);
    }
}
