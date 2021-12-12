package OReilly.RealWorld.Software.Development.businessRules;

public class DealValueAction implements Action{
    @Override
    public void perform(Facts facts) {
        Stage dealStage = Stage.valueOf(facts.getFact("stage"));
        double amount = Double.parseDouble(facts.getFact("amount"));
        double forecastedAmount = 0.0;
        if(dealStage == Stage.LEAD){
            forecastedAmount = amount * 0.2;
        } else if (dealStage == Stage.EVALUATING) {
            forecastedAmount = amount * 0.5;
        } else if(dealStage == Stage.INTERESTED) {
            forecastedAmount = amount * 0.8;
        } else if(dealStage == Stage.CLOSED) {
            forecastedAmount = amount;
        }
        facts.setFact("forecastedAmount", String.valueOf(forecastedAmount));
        System.out.println("Forecasted amount is " + forecastedAmount);
    }
}
