package OReilly.RealWorld.Software.Development.businessRules;

public class Rule {
    Condition condition;
    Action action;

    public Rule(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    public void run(Facts facts){
        if (condition.evaluate(facts)){
            action.perform(facts);
        }
    }

}
