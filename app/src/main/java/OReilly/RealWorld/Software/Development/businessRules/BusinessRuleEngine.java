package OReilly.RealWorld.Software.Development.businessRules;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
    List<Action> actions;
    Facts facts;

    public BusinessRuleEngine() {
        actions = new ArrayList<>();
        facts = new Facts();
    }

    public BusinessRuleEngine(Facts facts) {
        actions = new ArrayList<>();
        this.facts = facts;
    }


    public void addAction(Action action){
        actions.add(action);
    }

    public int count(){
        return actions.size();
    }

    public void run() {

        actions.forEach(action -> action.perform(facts));

    }

    public static void main(String[] args) {

        Facts myFacts = new Facts();
        myFacts.setFact("amount", "2100");
        myFacts.setFact("stage", "LEAD");

        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(myFacts);

        businessRuleEngine.addAction(new DealValueAction());

//        businessRuleEngine.addAction( (facts) -> {
//            if (facts.getFact("jobTitle").equals("CEO")){
//                final String name = facts.getFact("name");
//                System.out.println("Sending Email to " + name);
//            }
//        });

        businessRuleEngine.run();
    }
}
