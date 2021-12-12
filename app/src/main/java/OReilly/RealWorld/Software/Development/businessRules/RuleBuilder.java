package OReilly.RealWorld.Software.Development.businessRules;

public class RuleBuilder {
    Condition condition;
    Action action;

    public RuleBuilder when(Condition condition){
        this.condition = condition;
        return this;
    }

    public RuleBuilder then(Action action){
        this.action = action;
        return this;
    }

    public Rule createRule(){
        return new Rule(condition, action);
    }

    public RuleBuilder() {

    }

    public static RuleBuilder builder(){
        return new RuleBuilder();
    }
}
