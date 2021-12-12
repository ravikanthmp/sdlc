package OReilly.RealWorld.Software.Development.businessRules;

public class DealValueAction implements Action{

    @Override
    public void perform(Facts facts) {
        Stage dealStage = Stage.valueOf(facts.getFact("stage"));
        double amount = Double.parseDouble(facts.getFact("amount"));
        double forecastedAmount = 0.0;

        switch (dealStage){
            case LEAD:
                forecastedAmount = amount * 0.2;
                break;
            case EVALUATING:
                forecastedAmount = amount * 0.5;
                break;
            case INTERESTED:
                forecastedAmount = amount * 0.8;
                break;
            case CLOSED:
                forecastedAmount = amount;
                break;
        }

        facts.setFact("forecastedAmount", String.valueOf(forecastedAmount));
        System.out.println("Forecasted amount is " + forecastedAmount);
    }
}
